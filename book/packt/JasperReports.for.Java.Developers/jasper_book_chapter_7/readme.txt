Default ANT task will compile the reports and source code.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

EmptyDSReportFill executable can be used to fill EllipseDemoReport.jasper, ImageDemoReport.jasper, LineDemoReport.jasper and RectangleDemoReport.jasper

To execute it, change directory to the generated "build" directory and type the following on the console:

java -cp .;classes;"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\dist\\jasperreports-1.1.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-logging-1.0.2.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-collections-2.1.jar" net.ensode.jasperbook.EmptyDSReportFill LineDemoReport

Substitute the classpath to match your environment, the last argument must match the report name (LineDemoReport, EllipseDemoReport, ImageDemorReport or RectangleDemoReport).

DbChartReportFill executable can be used to fill BarChartDemoReport.jasper, PieChartDemoReport.jasper and XYLineChartDemoReport.jasper 

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).

To execute it, change directory to the generated "build" directory and type the following on the console:

java -cp .;classes;"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\dist\\jasperreports-1.1.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-logging-1.0.2.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-collections-2.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\mysql-connector-java-3.1.12\\mysql-connector-java-3.1.12-bin.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jfreechart-1.0.0-rc1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jcommon-1.0.0-rc1.jar" net.ensode.jasperbook.DbChartReportFill BarChartReportDemo

Substitute the classpath to match your environment, the last argument must match the report name BarChartReportDemo, PieChartDemoReport or XYLineChartReportDemo).

To view generated reports, the type the following on the console:

ant -Drpt=ImageDemoReport view

The value for the rpt parameter must match the name of the report to view.
