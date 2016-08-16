package dg.mon.hw.ch10;

import java.io.FileNotFoundException;

public class AnnotationTest {

    public static void test() {
        System.out.println("test method");
    }

    @AutoMethod(comments = "AutoMethod")
    public static void genericsTest() throws FileNotFoundException {
        System.out.println("AutoMethod Start !!!");
    }
}
