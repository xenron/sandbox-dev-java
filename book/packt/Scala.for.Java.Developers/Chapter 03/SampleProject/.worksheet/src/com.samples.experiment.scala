package com.samples

object experiment {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 

  val number = 1 + 2;System.out.println("""number  : Int = """ + $show(number ));$skip(55); val res$0 = 

  List(1, 2, 3, 3, 3, 4) filter (x => x < 4) distinct

  case class Customer(name: String);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(58); val res$1 = 

  Customer("Helen");System.out.println("""res1: com.samples.experiment.Customer = """ + $show(res$1));$skip(23); val res$2 = 

  new SimpleServlet();System.out.println("""res2: com.samples.SimpleServlet = """ + $show(res$2))}
}
