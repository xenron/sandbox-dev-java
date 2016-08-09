package se.wssample

object StockQuoteMain {
  def main(args: Array[String]){

    val service = (new se.wssample.StockQuoteSoap12Bindings with scalaxb.SoapClients with scalaxb.DispatchHttpClients {}).service
    
    println(service.getQuote(Some("AAPL")))

  }
}