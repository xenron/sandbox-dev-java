package org.javaee7.batch.flow;

import org.javaee7.util.BatchTestHelper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * The Batch specification allows you to implement process workflow using a Job Specification Language (JSL). In this
 * sample, by using the +flow+ element, we define a sequence of elements that execute together as a unit. When the
 * flow is finished the flow transitions to the next execution element. The execution elements of a flow cannot
 * transition to elements outside the flow.
 *
 * include::myJob.xml[]
 *
 * The flow element is useful to build a self contained workflow that you can reference and build as a part of a bigger
 * workflow.
 *
 * @author Roberto Cortez
 */
@RunWith(Arquillian.class)
public class BatchFlowTest {
    /**
     * We're just going to deploy the application as a +web archive+. Note the inclusion of the following files:
     *
     * [source,file]
     * ----
     * /META-INF/batch-jobs/myJob.xml
     * ----
     *
     * The +myJob.xml+ file is needed for running the batch definition.
     */
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
            .addClass(BatchTestHelper.class)
            .addPackage("org.javaee7.batch.flow")
            .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
            .addAsResource("META-INF/batch-jobs/myJob.xml");
        System.out.println(war.toString(true));
        return war;
    }

    /**
     * In the test, we're just going to invoke the batch execution and wait for completion. To validate the test
     * expected behaviour we need to query +javax.batch.operations.JobOperator#getStepExecutions+ and the
     * +javax.batch.runtime.Metric+ object available in the step execution.
     *
     * @throws Exception an exception if the batch could not complete successfully.
     */
    @Test
    public void testBatchFlow() throws Exception {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Long executionId = jobOperator.start("myJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);

        jobExecution = BatchTestHelper.keepTestAlive(jobExecution);

        List<StepExecution> stepExecutions = jobOperator.getStepExecutions(executionId);
        List<String> executedSteps = new ArrayList<>();
        for (StepExecution stepExecution : stepExecutions) {
            executedSteps.add(stepExecution.getStepName());

            if (stepExecution.getStepName().equals("step2")) {
                Map<Metric.MetricType, Long> metricsMap = BatchTestHelper.getMetricsMap(stepExecution.getMetrics());
                System.out.println(metricsMap);
                assertEquals(5L, metricsMap.get(Metric.MetricType.READ_COUNT).longValue());
                assertEquals(5L, metricsMap.get(Metric.MetricType.WRITE_COUNT).longValue());
                assertEquals(5L / 3 + (5 % 3 > 0 ? 1 : 0), metricsMap.get(Metric.MetricType.COMMIT_COUNT).longValue());
            }
        }

        // <1> Make sure all the steps were executed.
        assertEquals(3, stepExecutions.size());
        // <2> Make sure all the steps were executed in order of declaration.
        assertArrayEquals(new String[] { "step1", "step2", "step3" }, executedSteps.toArray());
        // <3> Job should be completed.
        assertEquals(BatchStatus.COMPLETED, jobExecution.getBatchStatus());
    }
}
