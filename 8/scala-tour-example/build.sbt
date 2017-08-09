lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
      "org.json4s" %% "json4s-jackson" % "3.5.2",
      "org.scala-sbt" %% "io" % "1.0.0-M13",
      "org.scalatest" %% "scalatest" % "3.0.1" % Test)
  )
