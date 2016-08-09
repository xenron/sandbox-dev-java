Maven 2 is recommended to build the code.

Maven 2 can be downloaded from http://maven.apache.org/download.html.

On each subdirectory there is a Maven pom.xml file. To build the code and generate each war file, simply execute "mvn install" from the directory containing the pom.xml.

A war file will be created in a subdirectory called "target". To deploy each war file, simply copy it to [glassfish installation directory]/domains/domain1/autodeploy (assuming the default domain is being used, modify the directory as appropriate to deploy to another domain.
