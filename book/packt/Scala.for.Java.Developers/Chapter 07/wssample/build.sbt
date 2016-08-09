import ScalaxbKeys._

name:="wssample"

scalaVersion:="2.10.2"
 
scalaxbSettings



libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.0.M7" % "test"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.2.1"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"

sourceGenerators in Compile <+= scalaxb in Compile

packageName in scalaxb in Compile := "se.wssample"