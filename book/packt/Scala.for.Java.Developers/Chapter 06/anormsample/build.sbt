name := "anormsample"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.derby" % "derbyclient" % "10.8.1.2"
)     

play.Project.playScalaSettings
