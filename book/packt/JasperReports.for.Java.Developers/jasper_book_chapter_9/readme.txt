Default ANT task will compile the reports and source code.

ant.properties contains the locations of all the required libraries. It needs to be modified to suit your environment.

DbConnectionReportFill executable can be used to fill all report templates.

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).

To execute it, change directory to the generated "build" directory and type the following on the console:

java -cp .;classes;"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\dist\\jasperreports-1.1.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-logging-1.0.2.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-collections-2.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\mysql-connector-java-3.1.12\\mysql-connector-java-3.1.12-bin.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jfreechart-1.0.0-rc1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jcommon-1.0.0-rc1.jar" net.ensode.jasperbook.DbConnectionReportFill CrossTabDemoReport

Substitute the classpath to match your environment, the last argument must match the report name.

To view generated reports, the type the following on the console:

ant -Drpt=CrossTabDemoReport view

The value for the rpt parameter must match the name of the report to view.

To execute all ExportDemo executables, change to the build directory and execute the following command from
the command line:

java -cp .;classes;"C:\Documents and Settings\david.heffelfinger\java_libs\jasperreports-1.2.0\dist\jasperreports-1.2.0.jar";"C:\Documents and Settings\david.heffelfinger\java_libs\jasperreports-1.2.0\lib\commons-logging-1.0.2.jar";"C:\Documents and Settings\david.heffelfinger\java_libs\jasperreports-1.2.0\lib\itext-1.3.1.jar";"C:\Documents and Settings\david.heffelfinger\java_libs\jasperreports-1.2.0\lib\commons-collections-2.1.jar";"C:\Documents and Settings\david.heffelfinger\java_libs\jasperreports-1.2.0\lib\poi-2.0-final-20040126.jar" net.ensode.jasperbook.XmlExportDemo DatasetDemoReport

Substitute the executable as appropriate. Argument in each case should be DatasetDemoReport, except for PlainTextExportDemo, in which case it should be PlainTextExportDemoReport

To deploy HtmlReportServlet, execute the "war" ant target in build.xml and deploy the resulting war file to a servlet container. BarChartReportDemo.jrxml must be compiled and filled before creating the war file.


