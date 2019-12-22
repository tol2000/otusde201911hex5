name := "otusde201911hex5"

version := "1"

scalaVersion := "2.11.12"

//resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.0.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kinesis-asl" % "2.0.0"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"
//libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"