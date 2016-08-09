name:="sbtjpasample"

scalaVersion:="2.10.3"

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.11",
        "org.hibernate" % "hibernate-core" % "3.5.6-Final",
	"org.hibernate" % "hibernate-entitymanager" % "3.5.6-Final",
	"org.springframework" % "spring-core" % "4.0.0.RELEASE",
	"org.springframework" % "spring-context" % "4.0.0.RELEASE",
        "org.springframework" % "spring-beans" % "4.0.0.RELEASE",
	"org.springframework" % "spring-tx" % "4.0.0.RELEASE",
	"org.springframework" % "spring-jdbc" % "4.0.0.RELEASE",
	"org.springframework" % "spring-orm" % "4.0.0.RELEASE", 
	"org.slf4j" % "slf4j-simple" % "1.6.4",
	"org.apache.derby" % "derbyclient" % "10.8.1.2",
	"org.scalatest" % "scalatest_2.10" % "2.0.M7"
)

