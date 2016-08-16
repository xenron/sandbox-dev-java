package dg.mon.hw.ch05;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ComponentDefinitionWithAnnotationTest {
    private static String configLocation = "classpath:dg/mon/hw/ch05/componentDefinitionWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filter = br.readLine();
        TakeFilePathAndName component = ctx.getBean("takeFilePathAndName", TakeFilePathAndName.class);
        String basePath = "D://tmp//data";
        component.getFile(basePath, filter);
    }

    public void testComponent() {
        TestCompoment component = ctx.getBean("component", TestCompoment.class);
        Assert.assertNotNull(component.getCtx());
    }
}