name := "ch8samples"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scala-lang.modules" %% "scala-async" % "0.9.0"
)     

play.Project.playScalaSettings
