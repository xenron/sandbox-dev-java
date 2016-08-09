package controllers

import scala.concurrent._
import scala.concurrent.duration._

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout

import play.api._
import play.api.mvc._
import play.api.libs.iteratee._
import play.api.libs.json._
import play.api.libs.concurrent._
import play.api.mvc.WebSocket.FrameFormatter
import akka.event.LoggingReceive

// Implicits
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits._

import org.mandubian.actorroom._

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.extensions._

import actors._

object Receiver {
  val flightBookingActor = Akka.system.actorOf(Props[Flight],"flight")
}
class Receiver extends Actor {
  import Receiver.flightBookingActor
  
  def receive = LoggingReceive {
    case x:Int => 
          play.Logger.info(s"Received number of seats left: $x")
          val placesLeft:String = if (x<0) "Fully Booked" else x.toString
          context.parent ! Broadcast("flight", Json.obj("placesLeft" -> placesLeft))  
    case Received(from, js: JsValue) =>
      js match {
        case json"""{
          "booking":"flight",
          "numberOfPersons":$v1
        }""" => 
          play.Logger.info(s"received $v1")
          val nbOfPersons = v1.as[String]
          flightBookingActor ! Flight.BookSeat(nbOfPersons.toInt)
          val placesCount = flightBookingActor ! Flight.GetSeatsLeft           
        case _ => play.Logger.info(s"no match found")
      }
  }
}

object Application extends Controller {

  implicit val msgFormatter = new AdminMsgFormatter[JsValue]{
    def connected(id: String) = Json.obj("kind" -> "connected", "id" -> id)
    def disconnected(id: String) = Json.obj("kind" -> "disconnected", "id" -> id)
    def error(id: String, msg: String) = Json.obj("kind" -> "error", "id" -> id, "msg" -> msg)
  }

  val room = Room()

  def index = Action {
    Ok(views.html.index())
  }

  def connect(id: Option[String]) = Action { implicit request =>
    Ok(views.html.index(id))
  }

  def websocketJs(id: String) = Action{ implicit request =>
    Ok(views.js.websocket(id))
  }

  def websocket(id: String) = room.websocket[Receiver, JsValue](id)

  def listMembers = Action.async {
    room.members.map( ids => Ok(Json.toJson(ids)) )
  }
}

