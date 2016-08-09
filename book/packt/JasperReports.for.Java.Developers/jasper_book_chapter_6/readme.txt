Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch6.war.

To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/jasperbookch6/<servlet url pattern>

Substitute <servlet url pattern> with the appropriate url pattern from the
<servlet-mapping> element in web.xml

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

To execute ReportBackgroundDemo, the following command must be executed:

java -cp
build/WEB-INF/classes/:/usr/local/share/java/jasperreports-1.1.1/dist/jasperreports-1.1.1.jar:/usr/local/share/java/jasperreports-1.1.1/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.1/lib/jdt-compiler.jar:/usr/local/share/java/jasperreports-1.1.1/lib/commons-collections-2.1.jar
net.ensode.jasperbook.ReportBackgroundDemo

Substitute jar file locations with the appropriate path on your system. On Windows systems, the ":" separator must be substituted with ";".
