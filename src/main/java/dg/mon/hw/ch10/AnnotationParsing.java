package dg.mon.hw.ch10;

import java.lang.reflect.Method;

public class AnnotationParsing {
    public static void main(String[] args) throws Exception {
        try {
            String targetClassName = "dg.mon.hw.ch10.AnnotationTest";
            Class targetClass = AnnotationParsing.class.getClassLoader().loadClass(targetClassName);
            Object targetObject = targetClass.newInstance();
            for (Method method : targetClass.getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(AutoMethod.class)) {
                    try {
                        AutoMethod methodAnno = method.getAnnotation(AutoMethod.class);
                        method.invoke(targetObject);
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
