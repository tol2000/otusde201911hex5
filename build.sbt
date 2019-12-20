name := "otusde201911hex5"

version := "0.1"

scalaVersion := "2.11.12"

//resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"