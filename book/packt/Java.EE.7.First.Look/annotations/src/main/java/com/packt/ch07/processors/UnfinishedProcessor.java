/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch07.processors;

import com.packt.ch07.annotations.Unfinished;
import java.util.Set;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.SourceVersion;
import java.lang.reflect.Field;

/**
 *
 * @author Administrator
 */
@SupportedAnnotationTypes("com.packt.ch07.annotations.Unfinished")
//@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class UnfinishedProcessor extends AbstractProcessor {

    /**
     * For the ServiceLoader
     */
    public UnfinishedProcessor() {
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            //For each annotated element do ...
            for (Element e : roundEnv.getElementsAnnotatedWith(Unfinished.class)) {        
                Unfinished unf = e.getAnnotation(Unfinished.class);
                System.out.println("***** Class :"+e.getEnclosingElement()+", "
                        + "Annotated element : " + e.getSimpleName()+", "
                        + " Kind : "+e.getKind()+", Message : "+unf.message()+"**** ");                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
