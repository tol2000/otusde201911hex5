package org.kliusa.otusde201911hex5.jsonreader

case class WineObj(
                    id: Option[Int],
                    country:Option[String],
                    points:Option[Int],
                    price:Option[Double],
                    title:Option[String],
                    variety:Option[String],
                    winery:Option[String]
                  ) {

  private val hzVal = "ХЗ"

  def getId:Int = id.getOrElse(-1)

  override def toString: String = {
    "===================================================\n" +
    s"Бухло # ${getId}" + "\n" +
      s"  гнали в ${country.getOrElse(hzVal)} " + "\n" +
      s"  набрал ${points.getOrElse(hzVal)} лайков" + "\n" +
      s"  барыжат за ${price.getOrElse(hzVal)}" + "\n" +
      s"  трезвые произносят как ${title.getOrElse(hzVal)}" + "\n" +
      s"  вид бухла ${variety.getOrElse(hzVal)}" + "\n" +
      s"  из бочки ${winery.getOrElse(hzVal)}" + "\n"
  }
}