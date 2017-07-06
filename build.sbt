name := "minihaskell"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies ++=
  Seq (
    "com.googlecode.kiama" %% "kiama" % "1.8.0"
  )

sbtRatsSettings