Default ANT task will compile the reports and the source, it will also generate a deployable war file. To execute the generated servlet, deploy the war file and point the browser to http://localhost:8080/app (substitute "localhost" and "8080" with the appropriate host name and port.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

To execute FirstReportFill, jasperreports-1.1.0.jar, commons-logging-1.0.2.jar
must be in the CLASSPATH, the following example will successfully execute it:

 java -cp
WEB-INF/classes:WEB-INF/lib/jasperreports-1.1.0.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.0/lib/jdt-compiler.jar
net.ensode.jasperbook.FirstReportFill

Substitute '/usr/local/share/java' above with the location where JasperReports
is installed in your system. When under Windows, the ":" separator must be
replaced with ";".

Due to a bug in JasperReports 1.1, jdt-compiler.jar must be included in the
CLASSPATH as well, according to JasperReports developers, a fix is already in
CVS and should be publicly available by the time the book is published.

To execute FirstReportCompile, the following command in the command line must
be executed:

java -cp
build/WEB-INF/classes:/usr/local/share/java/jasperreports-1.1.0/dist/jasperreports-1.1.0.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-digester-1.7.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-collections-2.1.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-beanutils-1.5.jar
net.ensode.jasperbook.FirstReportCompile

Substitute /usr/local/share/java/jasperreports-1.1.0 with the location where
JasperReports is installed on your system. On Windows systems, the ":"
separator must be substituted with ";".

To view the JRXML template, type "ant viewDesignXML -Drpt=FirstReport" on the
command line.

To view the Jasper binary template, type "ant viewDesign -Drpt=FirstReport"

To view the final report in JasperReports native format, type "ant view -Drpt=FirstReport" on the command line.

The build.xml developed in the chapter can be found under "build/reports".
