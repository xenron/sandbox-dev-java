package se.sfjd.ch8.supervision

import akka.actor.Actor
import akka.event.LoggingReceive
import scala.concurrent.forkjoin.ThreadLocalRandom

object Hotel {
  case class BookRoom(number:Int) {
    require(number > 0)
  }
  case object Done
  case object Failed
  class HotelBookingException extends Exception("Unavailable Hotel Booking Service")
}

class Hotel extends Actor {
  import Hotel._
  var roomsLeft = 15
  def receive = LoggingReceive {
    case BookRoom(nb) if nb <= roomsLeft =>
      unreliable()
      roomsLeft -= nb
      sender ! Done
    case _ => sender ! Failed
  }
  
  private def unreliable(): Unit =
    // the service is only working 75 percent of the time
    if (ThreadLocalRandom.current().nextDouble() < 0.25)
      throw new HotelBookingException
      
}