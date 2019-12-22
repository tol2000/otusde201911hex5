/*
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt

before - remove .sdk, .sbt, sdk and in .bashrc
 */

package org.kliusa.otusde201911hex5.jsonreader

import org.apache.spark.sql.SparkSession
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization

object JsonReader extends App{

  val jsonName = { if (args.length > 0) args(0) else "winemag-data-130k-v2.json" }

  val sparkSession = SparkSession.builder().master("local").getOrCreate()
  val sparkContext = sparkSession.sparkContext

  val jsonRdd = sparkContext.textFile(jsonName)

  println("Tolyan's json megaparser! :)");
  println("JSON name: " + jsonName)
  println("JSON RDD count: " + jsonRdd.count())

  implicit val formats = { Serialization.formats(FullTypeHints(List(classOf[WineObj]))) }

  var i = 0

  for ( wineRow <- jsonRdd ) {

    try {

      val parsedRow = parse(wineRow).extract[WineObj]
      if (parsedRow.getId % 10000 == 0) println(parsedRow) // Печатаем выборочно
      i += 1

    } catch {

      case ex: Exception => {
        println(s"EXCEPTION AT STEP ${i}\nValue: ${wineRow}")
        sys.exit(1)
      }

    }

  }

}
