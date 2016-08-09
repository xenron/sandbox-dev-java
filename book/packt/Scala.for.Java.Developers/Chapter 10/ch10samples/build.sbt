name := "ch10samples"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.mongodb" %% "casbah" % "2.7.0-RC1"
)     

play.Project.playScalaSettings
