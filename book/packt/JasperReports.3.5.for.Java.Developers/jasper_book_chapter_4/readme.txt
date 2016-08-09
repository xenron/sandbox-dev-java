Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch4.war.

 

Before any of the examples for this chapter can be executed, the flightstats 
database needs to be created and populated. 

Refer to the MySQL web site at 
http://www.mysql.com for MySQL installation instructions.
 


Additionally, before all the ANT targets can be successfully built, the MySQL JDBC driver needs to be downloaded from http://dev.mysql.com/downloads/connector/j/. 

The driver location in the filesystem must be specified in the mysql.jbc.jar property in ant.properties. 

Once MySQL is installed, create a new, empty database named "flightstats".
 

Extract flightstats.zip from this folder into any 
directory. This ZIP file contains a single file called flightstats_myisam.sql,
 to load the data in this file into the newly created database, issue the 
following command:

"mysql -u USER -p flightstats < flightstats_myisam.sql". 

Substitute USER with a user that can create tables.

 

To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/reports/dbReport for the report passing a JDBC connection to the report and http://localhost:8080/reports/dbDSReport for the servlet passing a ResultSetDataSource to the report (substitute "localhost" and "8080" with the appropriate host name and port. 



ant.properties contains the locations of all the required libraries. It will need to be modified to suit your environment. 



To execute DbReportFill, the following command can be executed:

ant fill 

To execute DbReportDSFill, the following command can be executed:

ant fillds


p.s. there are database credentials embedded in the code, which need to be changed to a valid user/password combination for your MySQL installation. Changes need to be made at the following location in all java files: 
connection = DriverManager.getConnection "jdbc:mysql://localhost:3306/flightstats?user=dbUser&password=secret");








