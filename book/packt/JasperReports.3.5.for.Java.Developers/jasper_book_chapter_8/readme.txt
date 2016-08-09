Default ANT task will compile the source code.

To compile the reports, the "compileReports" ANT task needs to be executed.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

EmptyDSReportFill executable can be used to fill HyperLinkDemoReport.jasper, LocalizationDemoReport.jasper and ScriptletDemoReport.jasper

To execute it, an ANT target is provided, it can be used as illustrated in the following example:

ant -Drpt=LineDemoReport fillReport

The value of the rpt property must match the report name (HyperLinkDemoReport, LocalizationDemoReport or ScriptletDemoReport)

DbConnectionReportFill executable can be used to fill CrossTabDemoReport.jasper, DatasetDemoReport.jasper and ChartDatasetDemoReport.jasper.

It requires an instance of MySQL containing the flightstats database to be running on the local host (download flightstats.zip for details).

To execute it, an ANT target is provided, it can be used as illustrated in the following example.

ant -Drpt=CrossTabDemoReport fillDbReport

The value of the rpt property must match the report name.

To view generated reports, type the following on the console:

ant -Drpt=CrossTabDemoReport view

The value for the rpt parameter must match the name of the report to view.
