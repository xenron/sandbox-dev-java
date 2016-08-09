
import play.Project._

name := "samplecrud"

version := "1.0"

libraryDependencies ++= Seq(
	jdbc, 
	anorm,
	"com.typesafe.slick" % "slick_2.10" % "1.0.0",
	"org.slf4j" % "slf4j-nop" % "1.7.5",
	"com.h2database" % "h2" % "1.3.166",
	"org.xerial" % "sqlite-jdbc" % "3.6.20",
	"org.apache.derby" % "derby" % "10.6.1.0",
	"org.hsqldb" % "hsqldb" % "2.0.0",
	"postgresql" % "postgresql" % "8.4-701.jdbc4",
	"mysql" % "mysql-connector-java" % "5.1.13",
	"org.dbunit" % "dbunit" % "2.4.9"
	)

playScalaSettings
