package controllers

import play.api.mvc._
import play.api.libs.json._
import views._

object MockMarketplaceController extends Controller {

  val mockUrl = "http://localhost:9000/mocksearch"

  case class AppStoreSearch(artistName: String, artistLinkUrl: String)
  implicit val appStoreSearchFormat = Json.format[AppStoreSearch]

  def mockSearch() = Action {
    val result = List(AppStoreSearch("Van Gogh", " http://www.vangoghmuseum.nl/"), AppStoreSearch("Monet", " http://www.claudemonetgallery.org "))
    Ok(Json.toJson(result))
  }
}
