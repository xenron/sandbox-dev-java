package actors

import akka.actor.Actor
import akka.event.LoggingReceive

object Flight {
  case class BookSeat(number:Int) {
    require(number > 0)
  }
  case object GetSeatsLeft
  case object Done
  case object Failed
}
class Flight extends Actor {
  import Flight._
  
  def book(seats:Int):Receive = LoggingReceive {
    case BookSeat(nb) if nb <= seats =>
      context.become(book(seats-nb))
    case GetSeatsLeft => sender ! seats
    case _ => sender ! Failed
  }
  
  def receive = book(50) // Initial number of available seats
}