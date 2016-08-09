package se.sfjd.ch8.supervision

import akka.actor.Actor
import akka.event.LoggingReceive
import scala.concurrent.forkjoin.ThreadLocalRandom

object Flight {
  case class BookSeat(number:Int) {
    require(number > 0)
  }
  case object Done
  case object Failed
  class FlightBookingException extends Exception("Unavailable Flight Booking Service")
}
class Flight extends Actor {
  import Flight._
  var seatsLeft = 50
  def receive = LoggingReceive {
    case BookSeat(nb) if nb <= seatsLeft =>
      unreliable()
      seatsLeft -= nb
      sender ! Done
    case _ => sender ! Failed
  }
  
  private def unreliable(): Unit =
    // the service is only working 75 percent of the time
    if (ThreadLocalRandom.current().nextDouble() < 0.25)
      throw new FlightBookingException
}