package controllers

import play.api._
import play.api.mvc._
import play.api.libs.ws.WS
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.concurrent.Future
import views._
import models._

object MarketplaceController extends Controller {

  val pageSize = 10
  val appStoreUrl = "https://itunes.apple.com/search"

  def list(page: Int, orderBy: Int, filter: String = "*") = Action.async { implicit request =>
    val futureWSResponse: Future[play.api.libs.ws.Response] =
      WS.url(appStoreUrl)
        .withQueryString("term" -> filter, "country" -> "se", "entity" -> "software")
        .get()
    
      futureWSResponse map { resp =>
        val json = resp.json
        val jsResult = json.validate[AppResult]
        jsResult.map {
          case AppResult(count, res) =>
            Ok(html.marketplace.list(
              Page(res,
                page,
                offset = pageSize * page,
                count),
              orderBy,
              filter))
        }.recoverTotal {
          e => BadRequest("Detected error:" + JsError.toFlatJson(e))
        }
      } 
  }
}