The following jar files must be copied to the war/WEB-INF/lib directory:

jasperreports-1.2.0.jar
itext-1.3.1.jar
commons-collections-2.1.jar  
antlr.jar                    
commons-fileupload.jar  
jakarta-oro.jar
commons-beanutils.jar        
commons-logging.jar     
commons-validator.jar   
struts.jar
commons-digester.jar         

jasperreports-1.2.0.jar can be found in the JasperReports project zip file
under the dist directory.

itext-1.3.1.jar and commons-collections-2.1 can be found in the JasperReports
project zip file under the lib directory.

The easiest way to obtain the remaining jar files is to download Struts
classic from http://struts.apache.org/download.cgi, extract the included
struts-blank.war file, and copy the jar files found under the WEB-INF/lib
directory.

Default ANT target will compile the source and generate the war file.

To execute the default ANT target, type "ant" in the current directory (Apache
ANT must be installed and the ant executable must be in the path for this
to work).

Make sure the there is a MySQL instance installed with a flightstats database
as described in the readme for chapter 4.

Make sure your servlet container has access to the MySQL JDBC driver. For
Tomcat, this can be accomplished by copying the jar file containing the driver
to ${TOMCAT_DIR}/common/lib, where ${TOMCAT_DIR} is the directory where Tomcat
is installed.

To test the example, deploy the generated war file, jasperstruts.war and point
your browser to http://localhost:8080/jasperstruts/generate_report.jsp.
Substitute the host name and port to match your environment (the values shown
are the default for an instance of Tomcat installed in the local workstation).
