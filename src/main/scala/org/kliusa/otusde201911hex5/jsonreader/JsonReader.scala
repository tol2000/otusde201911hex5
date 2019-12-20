package org.kliusa.otusde201911hex5.jsonreader

import org.apache.spark.sql.SparkSession
import org.json4s._

object JsonReader extends App{

  val jsonName = { if (args.length > 0) args(0) else "winemag-data-130k-v2.json" }

  val sparkSession = SparkSession.builder().master("local").getOrCreate()
  val sparkContext = sparkSession.sparkContext

  val jsonRdd = sparkContext.textFile(jsonName)

  println("Tolyan's json megaparser! :)")
  println("JSON name: " + jsonName)
  println("Top raw lines:")
  println("------------------")
  for ( s <- jsonRdd.top(5)) println(s)
  println("------------------")

  val jsn = parse()

}
