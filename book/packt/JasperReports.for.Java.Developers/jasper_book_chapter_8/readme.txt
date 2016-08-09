Default ANT task will compile the reports and source code.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

EmptyDSReportFill executable can be used to fill HyperLinkDemoReport.jasper, LocalizationDemoReport.jasper and ScriptletDemoReport.jasper

To execute it, change directory to the generated "build" directory and type the following on the console:

java -cp .;classes;"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\dist\\jasperreports-1.1.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-logging-1.0.2.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-collections-2.1.jar";reports net.ensode.jasperbook.EmptyDSReportFill HyperLinkDemoReport

Substitute the classpath to match your environment, the last argument must match the report name (HyperLinkDemoReport, LocalizationDemoReport or ScriptletDemoReport)

DbConnectionReportFill executable can be used to fill CrossTabDemoReport.jasper, DatasetDemoReport.jasper and ChartDatasetDemoReport.jasper.

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).

To execute it, change directory to the generated "build" directory and type the following on the console:

java -cp .;classes;"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\dist\\jasperreports-1.1.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-logging-1.0.2.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\commons-collections-2.1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\mysql-connector-java-3.1.12\\mysql-connector-java-3.1.12-bin.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jfreechart-1.0.0-rc1.jar";"C:\\Documents and Settings\\david.heffelfinger\\java_libs\\jasperreports-1.1.1\\lib\\jcommon-1.0.0-rc1.jar" net.ensode.jasperbook.DbConnectionReportFill CrossTabDemoReport

Substitute the classpath to match your environment, the last argument must match the report name.

To view generated reports, the type the following on the console:

ant -Drpt=CrossTabDemoReport view

The value for the rpt parameter must match the name of the report to view.
