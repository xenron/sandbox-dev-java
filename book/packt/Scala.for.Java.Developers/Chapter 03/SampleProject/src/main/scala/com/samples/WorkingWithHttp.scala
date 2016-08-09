package com.samples

import dispatch._, Defaults._

object WorkingWithHttp extends App {
  
  val request = url("http://freegeoip.net/xml/www.google.com")
  
  val result = Http( request OK as.String)
  
  val resultAsString = result()
  
  // Here you need to register at Groupon to get your own client_key
  val grouponCitiesURL = url("http://api.groupon.com/v2/divisions.xml?client_id=<your own client_key>")
  
  val citiesAsText = Http(grouponCitiesURL OK as.String)
  
  citiesAsText()
  
  val citiesAsXML = Http(grouponCitiesURL OK as.xml.Elem)
  
  citiesAsXML()
  
  def printer = new scala.xml.PrettyPrinter(90, 2)
  
  // Produces a long output
  for (xml <- citiesAsXML)
    println(printer.format(xml))
    
  val cityDivisions = citiesAsXML() map ( city => city \\ "division")
  
  val cityNames = cityDivisions map ( div => (div \ "name").text)
  
  for {
    elem <- List(1,2,3,4,5)
  } yield "T" + elem
  
  for {
    word <- List("Hello","Scala")
    char <- word
  } yield char.isLower
  
  for {
    word <- List("Hello","Scala")
    char <- word if char.isUpper
  } yield char
  
  for {
    word <- List("Hello","Scala")
    char <- word
    lowerChar = char.toLower
  } yield lowerChar
  
  def extractCityNames(xml: scala.xml.Elem) =
    for {
      elem <- xml \\ "division"
      name <- elem \ "name"
    } yield name.text
    
  val cityNames2 = extractCityNames(citiesAsXML())
  
  def extractCityLocations(xml: scala.xml.Elem) =
    for {
      elem<- xml \\ "division"
      name <- elem \ "name"
      latitude <- elem \ "lat"
      longitude <- elem \ "lng"
    } yield (name.text,latitude.text,longitude.text)
    
  val cityLocations = extractCityLocations(citiesAsXML())
    
  val (honolulu,lat,lng) = cityLocations find (_._1 == "Honolulu") getOrElse("Honolulu","21","-157")
  
  val honolulu2 = 
    cityLocations find { case( city, _, _ ) =>
      city == "Honolulu"
    }
  println("honolulu2: "+honolulu2)
  
  // Here you need to use your own Groupon client_id
  val dealsByGeoArea = url("http://api.groupon.com/v2/deals.xml?client_id=<your client_id>") 
  
  case class Deal(title:String = "",dealUrl:String = "", tag:String= "")
  
  def extractDeals(xml: scala.xml.Elem) =
    for {
      deal <- xml \\ "deal"
      title = (deal \\ "title").text
      dealUrl = (deal \\ "dealUrl").text
      tag = (deal \\ "tag" \ "name").text
    } yield Deal(title, dealUrl, tag)

  val dealsInHonolulu =
    Http(dealsByGeoArea <<? Map("lat"->lat,"lng"->lng) OK as.xml.Elem)
    
  val deals = extractDeals(dealsInHonolulu())
  
  val sortedDeals = deals groupBy(_.tag)
    
  val nbOfDealsPerTag = sortedDeals mapValues(_.size)
  println("nbOfDealsPerTag: "+nbOfDealsPerTag)
}