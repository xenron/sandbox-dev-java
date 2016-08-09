Default ANT task will compile the reports and the source, it will also generate a deployable war file  named jasperbookch5.war.

 

To execute the generated servlets, deploy the war file and point the browser to http://localhost:8080/jasperbookch5/<servlet url pattern>
 
Substitute <servlet url pattern> with the appropriate url pattern from the
<servlet-mapping> element in web.xml. 



ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.
 


To execute TableModelReport, the following command can be executed:
ant tablemodel
