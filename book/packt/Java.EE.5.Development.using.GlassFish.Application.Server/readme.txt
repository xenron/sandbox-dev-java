Maven 2 is recommended to build the code.

Maven 2 can be downloaded from http://maven.apache.org/download.html.

Maven 2 installation instructions can also be found at the above URL.

Each example contains a Maven pom.xml file. To build the code and generate the example's WAR, JAR or EAR file, simply execute "mvn install" from the directory containing pom.xml.

The example's WAR, JAR or EAR file will be created in a subdirectory called "target". To deploy the file, simply copy it to [glassfish installation directory]/domains/domain1/autodeploy (assuming the default domain is being used, modify the directory as appropriate to deploy to another domain.
