Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch5.war.

To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/jasperbookch5/<servlet url pattern>

Substitute <servlet url pattern> with the appropriate url pattern from the
<servlet-mapping> element in web.xml

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

To execute TableModelReport, the following command must be executed:

java -cp
build/WEB-INF/classes/:/usr/local/share/java/jasperreports-1.1.0/dist/jasperreports-1.1.0.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.0/lib/jdt-compiler.jar
net.ensode.jasperbook.TableModelReport

Substitute jar file locations with the appropriate path on your system. On Windows systems, the ":" separator must be substituted with ";".
