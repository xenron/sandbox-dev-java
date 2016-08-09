Default ANT task will compile the reports and the source, it will also generate a deployable war file. 

To execute the generated servlet, deploy the war file and point the browser to http://localhost:8080/app (substitute "localhost" and "8080" with the appropriate host name and port.
 


ant.properties contains the locations of all the required libraries. It might need to be modified to suit your environment.
 


An ANT target is provided to execute FirstReportFill, the target is called "fill", executing "ant fill" in the command line should do the trick. 



To compile the report, execute "ant compile" in the command line.




To view the JRXML template, type "ant viewDesignXML" on the
 command line.



To view the Jasper binary template, type "ant viewDesign"
. 


To view the final report in JasperReports' native format, type "ant view" on the command line.
 


The build.xml developed in the chapter can be found under "build/reports".
