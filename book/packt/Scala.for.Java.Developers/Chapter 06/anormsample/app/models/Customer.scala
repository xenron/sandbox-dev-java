package models

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import scala.language.postfixOps

case class Customer(id: Pk[Int] = NotAssigned, name: String)

object Customer {
  
  /**
   * Retrieve a Customer from an id.
   */
  def findById(id: Int): Option[Customer] = {
    DB.withConnection { implicit connection =>
      println("Connection: "+connection)
      val query = SQL("select * from app.customer where customer_id = {custId}").on('custId -> id)
      query.as(Customer.simple.singleOpt)
    }
  }
    
  /**
   * Parse a Customer from a ResultSet
   */
  val simple = {
    get[Pk[Int]]("customer.customer_id") ~
    get[String]("customer.name") map {
      case id~name => Customer(id, name)
    }
  }
}