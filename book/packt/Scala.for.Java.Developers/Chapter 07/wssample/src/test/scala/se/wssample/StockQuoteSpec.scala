package se.wssample

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.xml.{ XML, PrettyPrinter }

class StockQuoteSpec extends FlatSpec with ShouldMatchers {
  "Getting a quote for Apple" should "give appropriate data" in {
    
    val pp = new PrettyPrinter(80, 2)
    
    val service = 
      (new se.wssample.StockQuoteSoap12Bindings 
        with scalaxb.SoapClients 
        with scalaxb.DispatchHttpClients {}).service
    
    val stockquote = service.getQuote(Some("AAPL"))
    
    stockquote match {
      case Left(err) => fail("Problem with stockquote invocation")
      case Right(success) => success.GetQuoteResult match {
        case None => println("No info returned for that stockquote")
        case Some(x) => {
          println("Stockquote: "+pp.format(XML.loadString(x)))
          x should startWith ("<StockQuotes><Stock><Symbol>AAPL</Symbol>")
        }
      }
    }
  }
}
