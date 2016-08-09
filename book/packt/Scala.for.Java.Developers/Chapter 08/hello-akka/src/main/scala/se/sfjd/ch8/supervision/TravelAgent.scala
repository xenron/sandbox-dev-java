package se.sfjd.ch8.supervision

import akka.actor.{Actor,ActorRef,Props,OneForOneStrategy,ActorLogging}
import akka.event.LoggingReceive
import akka.actor.SupervisorStrategy.{Restart, Resume, Stop}

object TravelAgent {
  case class BookTrip(nbOfPersons: Int)
  case object Done
  case object Failed
}
class TravelAgent extends Actor with ActorLogging {
  import TravelAgent._
  
  override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
    case _: Flight.FlightBookingException =>
      log.warning("Flight Service Failed. Restarting")
      Restart
    case _: Hotel.HotelBookingException =>
      log.warning("Hotel Service Failed. Restarting")
      Restart
    case e =>
      log.error("Unexpected failure", e.getMessage)
      Stop
  }
  
  var flightAgent = context.actorOf(Props[Flight], "FlightAgent")
  var hotelAgent = context.actorOf(Props[Hotel], "HotelAgent")
  
  override def preStart(): Unit = {
    flightAgent = context.actorOf(Props[Flight], "UnreliableFlightAgent")
    hotelAgent = context.actorOf(Props[Hotel], "UnreliableHotelAgent")
  }
  
  def receive = LoggingReceive {
    case BookTrip(persons) =>
      flightAgent ! Flight.BookSeat(persons)
      hotelAgent ! Hotel.BookRoom(persons)
      context.become(awaitTransportOrAccomodation(flightAgent, hotelAgent,sender))
  }
  
  def awaitTransportOrAccomodation(transport: ActorRef, accomodation: ActorRef, customer:ActorRef): Receive = LoggingReceive {
    case Flight.Done =>
      context.become(awaitAccomodation(customer))
    case Hotel.Done =>
      context.become(awaitTransport(customer))
    case Flight.Failed | Hotel.Failed =>
      customer ! Failed
      context.stop(self) 
  }
  
  def awaitTransport(customer: ActorRef): Receive = LoggingReceive {
    case Flight.Done =>
      customer ! Done
      context.stop(self)
    case Flight.Failed => 
      customer ! Failed
      context.stop(self)
  }
  
  def awaitAccomodation(customer: ActorRef): Receive = LoggingReceive {
    case Hotel.Done =>
      customer ! Done
      context.stop(self)
    case Hotel.Failed =>
      customer ! Failed
      context.stop(self)
  }
}