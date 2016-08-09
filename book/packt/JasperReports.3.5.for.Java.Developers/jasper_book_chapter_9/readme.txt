Default ANT task will compile the reports and source code.



ant.properties contains the locations of all the required libraries. It needs to be modified to suit your environment.



EmptyDSReportFill executable can be used to fill all report templates not requiring a database connection.

To execute it, an ANT target is provided, it can be used as illustrated in the following example:

ant -Drpt=PlainTextExportDemoReport fillReport

The value of the rpt property must match the report name.



DbConnectionReportFill executable can be used to fill all report templates requiring a database connection.

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).


To execute it, an ANT target is provided, it can be used as illustrated in the following example:

ant -Drpt=BarChartReportDemo fillDbReport


The value of the rpt property must match the report name.



To view generated reports, the type the following on the console:


ant -Drpt=BarChartReportDemo view


The value for the rpt parameter must match the name of the report to view.


To execute all ExportDemo executables, an ANT target is provided. It can be used as illustrated in the following example:


ant -Drpt=BarChartReportDemo -Dclass=PdfExportDemo export


Substitute the value of the class property to match the class filename to execute.



To deploy HtmlReportServlet, execute the "war" ant target in build.xml and deploy the resulting war file to a servlet container. BarChartReportDemo.jrxml must be compiled and filled before creating the war file.


