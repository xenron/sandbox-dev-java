Default ANT task will compile the reports and source code.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

EmptyDSReportFill executable can be used to fill EllipseDemoReport.jasper, ImageDemoReport.jasper, LineDemoReport.jasper and RectangleDemoReport.jasper

To execute it, an ANT target is provided, it can be used as illustrated in the following example:

ant -Drpt=LineDemoReport fillReport

The value of the rpt property must match the report name (LineDemoReport, EllipseDemoReport, ImageDemoReport or RectangleDemoReport).

DbChartReportFill executable can be used to fill BarChartDemoReport.jasper, PieChartDemoReport.jasper and XYLineChartDemoReport.jasper 

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).

To execute it, an ANT target is provided, it can be used as illustrated in the following example.

ant -Drpt=BarChartReportDemo fillDbReport

The value of the rpt property must match the report name (BarChartReportDemo, PieChartDemoReport or XYLineChartReportDemo).

To view generated reports, type the following on the console:

ant -Drpt=ImageDemoReport view

The value for the rpt parameter must match the name of the report to view.
