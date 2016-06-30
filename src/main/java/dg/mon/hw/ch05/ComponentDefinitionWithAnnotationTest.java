package dg.mon.hw.ch05;

public class ComponentDefinitionWithAnnotationTest {
    private static String configLocation = "classpath:chapter12/componentDefinitionWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
    @Test
    public void testComponent() {
        TestCompoment component = ctx.getBean("component", TestCompoment.class);
        Assert.assertNotNull(component.getCtx());
    }
}