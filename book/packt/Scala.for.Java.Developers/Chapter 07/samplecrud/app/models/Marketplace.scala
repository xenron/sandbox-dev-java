package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class AppInfo(id: Long, name: String, author: String, authorUrl:String,
    category: String, picture: String, formattedPrice: String, price: Double)
object AppInfo {
  implicit val appInfoFormat = (
    (__ \ "trackId").format[Long] and
    (__ \ "trackName").format[String] and
    (__ \ "artistName").format[String] and
    (__ \ "artistViewUrl").format[String] and
    (__ \ "primaryGenreName").format[String] and
    (__ \ "artworkUrl60").format[String] and
    (__ \ "formattedPrice").format[String] and
    (__ \ "price").format[Double])(AppInfo.apply, unlift(AppInfo.unapply))
}

case class AppResult(resultCount: Int, results: Array[AppInfo])
object AppResult {
  implicit val appResultFormat = (
    (__ \ "resultCount").format[Int] and
    (__ \\ "results").format[Array[AppInfo]])(AppResult.apply, unlift(AppResult.unapply))
}