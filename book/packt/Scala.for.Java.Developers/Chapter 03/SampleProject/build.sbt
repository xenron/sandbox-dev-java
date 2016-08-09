name := "SampleProject"

organization := "com.samples"

version := "1.0"

scalaVersion := "2.10.3"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"