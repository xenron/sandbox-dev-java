package org.cdibook.chapter9;

import org.cdibook.chapter9.service.AbstractService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TestDeployment {

    public static WebArchive deployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage("org.cdibook.chapter9.annotations")
                .addPackage("org.cdibook.chapter9.bean")
                .addPackage("org.cdibook.chapter9.event")
                .addPackage("org.cdibook.chapter9.exception")
                .addPackage("org.cdibook.chapter9.interceptor")
                .addPackage("org.cdibook.chapter9.model")
                .addPackage("org.cdibook.chapter9.enums")
                .addPackage("org.cdibook.chapter9.util")
                .addClass(AbstractService.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml")
                                    .resolve("commons-codec:commons-codec")
                                    .withoutTransitivity()
                                    .asFile());
    }
}
