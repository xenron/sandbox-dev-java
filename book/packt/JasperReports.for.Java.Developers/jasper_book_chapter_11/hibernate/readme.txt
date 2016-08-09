To execute this example, copy the following jar files from the Hibernate
distribution to the lib directory:

antlr-2.7.5H3.jar  
asm.jar        
dom4j-1.6.jar    
hibernate3.jar
asm-attrs.jar      
cglib-2.1.jar  
ehcache-1.1.jar  
jta.jar

The "compile" ant target compiles the JRXML template and the source.

The "fillReport" ant target fills the report.

To view the generated report, type the following in the command line: "ant
-Drpt=HibernateQueryDemoReport view" (minus the double quotes).
