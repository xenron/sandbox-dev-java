README  README  README  README  README  README  README  README  README  README  
================================================================================

Author:             Peter A. Pilgrim
Original Date:      01/October/2012
Impression Date:    31/July/2013
Email:              peter.pilgrim@gmail.com


================================================================================
    J A V A  E E  7  H A N D B O O K
================================================================================

This is software to go with the book with ``The Java EE 7 Developer Handbook'' 
written by Peter A. Pilgrim, published by Packt Publishing. (September 2013)

You can purchase a copy of the book from Packt Pub at this URL:

http://www.packtpub.com/java-ee-7-developer-handbook/book


This source code distribution can be found on GitHub after the book's 
publication date:

http://github.com/peterpilgrim/javaee7-developer-handbook

(The code will be uploaded simultaneously with the book's publication date ;-)


LICENSE
------------
The entire source code and software for the book falls under the GNU 
GENERAL PUBLIC LICENSE (Version 3, 29 June 2007)
http://www.gnu.org/licenses/gpl-3.0.txt

See the ``LICENSE.txt'' for the full legal text.



COMPILATION
------------

Each of the chapters in the book has its own folder, and within those 
chapter folder there is at least one project folder with a Gradle project.
You will recognize them, because they have a ``build.gradle' file inside
them. This is the project build file. 

Go http://gradle.org/ and download Gradle version 1.6 or better

To compile the program

	% gradle build


Explicitly to just compile the sources, run this command line:

	% gradle compileJava


To clean the project and reset to the start, run this command line:

	% gradle clean




TEST
-----

Ask Gradle to run the Unit Tests with the following comand:

    % gradle test --info


Look for the results in the folder `build/reports' and view the HTML file inside
a web browser or examine the XML test file. By the way all of the tests from 
the source code were written with JUnit.



ECLIPSE
------------

Ask Gradle to (re-)create Eclipse project artifacts ``.classpath'' and ``.project''

    % gradle eclipse



IDEA
---------

Ask Gradle to (re-)create IDEA project configuration files ``*.ipr'' and ``*.iml'' etc

    % gradle idea


SUB PROJECTS
----------------

You can find out the list of sub projects with gralde. Execute the following:

    % gradle projects


Read the Gradle documentation to find out how to switch between projects, 
and execute sub projects. Here is a decent URL:
http://www.gradle.org/docs/current/userguide/multi_project_builds.html


DEPENDENCIES
-----------------

You can ask a gradle project about its dependencies with the following:

    % gradle dependencies


And you can find out about the tasks that you can invoke with:

    % gradle tasks



OTHER ARTIFACTS
-----------------

Some project create WAR files. Gradle plugin for WAR files bind automatically 
`assemble'. This also applies to EAR and RAR files. So this implies that 

    % gradle assemble

Will do the right thing for certain projects.

    % gradle jar        // for project that builds a JAR
    % gradle war        // ditto 
    % gradle ear        // ditto



MISCELLANEOUS
----------------

I had to disable the multi-module nature of the root Gradle project, because 
it does not work intuitively for sub modules. With multi-module enables, running
`gradle idea' for any of the sub module causes Gradle to copy all the other 
dependencies into that module, which is definitely not acceptable!

Sadly, the only thing the root Gradle project can do is build a 
distribution ZIP file. If you don't belive me, I shared my problem with 
Luke Daley, the Gradleware committer and he told me that is the way Gradle
works.

    % gradle myZip
    



All the best.
Peter Pilgrim, 2013


To send comments, email me : peter.pilgrim@gmail.com
http://www.xenonique.co.uk/blog/

