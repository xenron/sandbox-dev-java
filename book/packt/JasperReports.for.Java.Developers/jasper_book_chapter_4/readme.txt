Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch4.war.

Before any of the examples for this chapter can be executed, the flightstats
database needs to be created and populated. Refer to the MySQL web site at
http://www.mysql.com for MySQL installation instructions.

Once MySQL is installed, create a new, empty databased named "flightstats",
download flightstats.zip from this book web site and extract it into any
directory. The zip file contains a single file called flightstats_myisam.sql,
to load the data in this file into the newly created database, issue the
following command:

"mysql -u USER -p flightstats < flightstats_myisam.sql" 

Substitute USER with a user that can create tables.

To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/jasperbookch4/dbReport for the report passing a JDBC connection to the report and http://localhost:8080/jasperbookch4/dbDSReport for the servlet passing a ResultSetDataSource to the report (substitute "localhost" and "8080" with the appropriate host name and port.

ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.

To execute DbReportFill, the following command must be executed:

java -cp build/WEB-INF/classes/:/usr/local/share/java/jasperreports-1.1.0/dist/jasperreports-1.1.0.jar:/usr/share/java/mysql-connector-java-3.1.8.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.0/lib/jdt-compiler.jar net.ensode.jasperbook.DbReportFill

Substitute jar file locations with the appropriate path on your system. On Windows systems, the ":" separator must be substituted with ";".

To execute DbReportDSFill, the following command must be executed:

java -cp build/WEB-INF/classes/:/usr/local/share/java/jasperreports-1.1.0/dist/jasperreports-1.1.0.jar:/usr/share/java/mysql-connector-java-3.1.8.jar:/usr/local/share/java/jasperreports-1.1.0/lib/commons-logging-1.0.2.jar:/usr/local/share/java/jasperreports-1.1.0/lib/jdt-compiler.jar net.ensode.jasperbook.DbReportDSFill

Again, paths will need to be modified to match the local system.
