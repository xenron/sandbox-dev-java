package dg.mon.hw.ch05;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentDefinitionWithAnnotationTest {
    private static String configLocation = "classpath:dg/mon/hw/ch05/componentDefinitionWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

    public static void main(String[] args) throws Exception {
        TakeFilePathAndName component = ctx.getBean("takeFilePathAndName", TakeFilePathAndName.class);
        component.getFile("D://tmp");
    }

    public void testComponent() {
        TestCompoment component = ctx.getBean("component", TestCompoment.class);
        Assert.assertNotNull(component.getCtx());
    }
}