@cls
@ECHO ###-------------------------------------------------------------------------###
@ECHO ### run WAR
@ECHO ###-------------------------------------------------------------------------###

@echo off

REM set MAVEN_OPTS="-noverify -Xbootclasspath/p:%JREBEL_HOME%\jrebel-bootstrap.jar;%JREBEL_HOME%\jrebel.jar"
set JAVA_OPTS="-Xmx512m -XX:MaxPermSize=512m"

set project.root="C:\\usr\\SYNCH\\PACKT\\3166\\Chapters"

@echo on

@ECHO [INFO] ------------------------------------------------------------------
@ECHO JAVA_HOME to %JAVA_HOME%
@ECHO JAVA_OPTS to %JAVA_OPTS%
java -version
jruby --version
@ECHO MAVENT_OPTS to %MAVENT_OPTS%
@ECHO project.root to %project.root%
@ECHO [INFO] ------------------------------------------------------------------
@ECHO [INFO]  mvn clean install -e
@ECHO [INFO] ------------------------------------------------------------------

@call mvn clean install -e

set /p status=Please hit ENTER to close window
