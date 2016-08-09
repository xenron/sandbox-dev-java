Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch6.war.



To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/jasperbookch6/<servlet url pattern>



Substitute <servlet url pattern> with the appropriate url pattern from the
<servlet-mapping> element in web.xml



ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.



To fill ReportBackgroundDemo, the following command must be executed:

java -cp build/WEB-INF/classes/:/opt/jasperreports-3.5.2/dist/jasperreports-3.5.2.jar:/opt/jasperreports-3.5.2/lib/commons-logging-1.0.2.jar:/opt/jasperreports-3.5.2/lib/jdt-compiler.jar:/opt/jasperreports-3.5.2/lib/commons-collections-2.1.jar:/opt/jasperreports-3.5.2/lib/commons-digester-1.7.jar net.ensode.jasperbook.ReportBackgroundDemo


Substitute jar file locations with the appropriate path on your system. On Windows systems, the ":" separator must be substituted with ";".
