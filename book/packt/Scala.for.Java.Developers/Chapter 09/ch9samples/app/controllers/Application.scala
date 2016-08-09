package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee._
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def connect =  WebSocket.using[String] { request =>
    
    //Concurernt.broadcast returns (Enumerator, Concurrent.Channel)
    val (out,channel) = Concurrent.broadcast[String]
    
    //log the message to stdout and send response back to client
    val in = Iteratee.foreach[String] {
      msg => println(msg)
      //the channel will push to the Enumerator
      channel push("RESPONSE: " + msg)
      }
    (in,out)
  }
}