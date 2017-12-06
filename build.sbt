name := "abgabe2"

version := "0.1"

scalaVersion := "2.12.4"

lazy val akkaVersion = "2.5.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)