package com.samples

object experiment {

  val number = 1 + 2                              //> number  : Int = 3

  List(1, 2, 3, 3, 3, 4) filter (x => x < 4) distinct
                                                  //> res0: List[Int] = List(1, 2, 3)

  case class Customer(name: String)

  Customer("Helen")                               //> res1: com.samples.experiment.Customer = Customer(Helen)

  new SimpleServlet()                             //> res2: com.samples.SimpleServlet = com.samples.SimpleServlet@51d098b7
}