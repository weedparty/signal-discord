name := "signal-discord"

version := "0.1"

organization := "io.github.weedparty"

scalaVersion := "2.13.1"

resolvers += Resolver.JCenterRepository
libraryDependencies ++= Seq(
  "net.katsstuff" %% "ackcord" % "0.15.0",
  "org.json4s" %% "json4s-jackson" % "3.7.0-M2"
)