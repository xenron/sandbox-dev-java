To take advantage of Maven's dependency management, this example was
developed using Maven as a build tool.



It can be built using either Maven or ANT. The command to build the code depends on what build tool is being used:


With Maven:

"mvn package" 


With ANT:

"ant package"


Either command will automatically download all required dependencies from the central Maven repository, therefore you must be online for the build to work.



After the dependencies have been downloaded, the code will be compiled and a war file named jasper-struts.war will be placed in the "target" directory. 

Simply deploy the war file as usual by copying it to the "webapps" tomcat  subdirectory.

To see the example in action, point the browser to the following URL: 
http://localhost:8080/jasper-struts/generate_report.do.


