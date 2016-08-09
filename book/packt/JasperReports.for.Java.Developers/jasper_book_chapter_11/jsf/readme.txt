The following jar files need to be in the war/WEB-INF/lib directory to compile
and execute this example:

jasperreports-1.2.0.jar
itext-1.3.1.jar
myfaces-api.jar
myfaces-impl.jar
commons-beanutils.jar    
commons-el.jar         
jakarta-oro.jar
commons-codec.jar        
commons-lang.jar       
commons-collections.jar  
commons-validator.jar  
commons-digester.jar     

The first two files are can be found in the JasperReports project file. The
easiest way to obtain the remaining jar files is to download the MyFaces
Examples distribution from http://myfaces.apache.org/download.html, extract
any of the included war files and copy the jar files from the WEB-INF/lib
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

To test the example, deploy the generated war file, jasperjsf.war and point
your browser to http://localhost:8080/jasperjsf/generate_report.jsf.
Substitute the host name and port to match your environment (the values shown
are the default for an instance of Tomcat installed in the local workstation).
