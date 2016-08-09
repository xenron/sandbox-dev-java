





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class Custome(customerId : Option[Int], discountCode : String, zip : String, name : Option[String], addressline1 : Option[String], addressline2 : Option[String], city : Option[String], state : Option[String], phone : Option[String], fax : Option[String], email : Option[String], creditLimit : Option[Int])

// Definition of the Custome table
object Customer extends Table[Custome]("CUSTOMER") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def customerId = column[Int]("CUSTOMER_ID", O.PrimaryKey) 
  
  
  def discountCode = column[String]("DISCOUNT_CODE") 
  // def discountCodeEntity = foreignKey("FOREIGNKEY_DISCOUNT_CODE", discountCode, DiscountCode)(_.id)
  
  def zip = column[String]("ZIP") 
  
  
  def name = column[Option[String]]("NAME") 
  
  
  def addressline1 = column[Option[String]]("ADDRESSLINE1") 
  
  
  def addressline2 = column[Option[String]]("ADDRESSLINE2") 
  
  
  def city = column[Option[String]]("CITY") 
  
  
  def state = column[Option[String]]("STATE") 
  
  
  def phone = column[Option[String]]("PHONE") 
  
  
  def fax = column[Option[String]]("FAX") 
  
  
  def email = column[Option[String]]("EMAIL") 
  
  
  def creditLimit = column[Option[Int]]("CREDIT_LIMIT") 
  
    
  
  def * = customerId.? ~ discountCode ~ zip ~ name ~ addressline1 ~ addressline2 ~ city ~ state ~ phone ~ fax ~ email ~ creditLimit <> (Custome.apply _, Custome.unapply _)
  //def autoInc = id.? ~ customerId.? ~ discountCode ~ zip ~ name ~ addressline1 ~ addressline2 ~ city ~ state ~ phone ~ fax ~ email ~ creditLimit <> (Custome.apply _, Custome.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- Customer
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: Int) =
    for (entity <- Customer if entity.customerId === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.customerId -> customerId)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[Custome].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "customerId" => ru.typeOf[Customer.type].declaration(ru.newTermName("customerId")).asMethod
      
      case "discountCode" => ru.typeOf[Customer.type].declaration(ru.newTermName("discountCode")).asMethod
      
      case "zip" => ru.typeOf[Customer.type].declaration(ru.newTermName("zip")).asMethod
      
      case "name" => ru.typeOf[Customer.type].declaration(ru.newTermName("name")).asMethod
      
      case "addressline1" => ru.typeOf[Customer.type].declaration(ru.newTermName("addressline1")).asMethod
      
      case "addressline2" => ru.typeOf[Customer.type].declaration(ru.newTermName("addressline2")).asMethod
      
      case "city" => ru.typeOf[Customer.type].declaration(ru.newTermName("city")).asMethod
      
      case "state" => ru.typeOf[Customer.type].declaration(ru.newTermName("state")).asMethod
      
      case "phone" => ru.typeOf[Customer.type].declaration(ru.newTermName("phone")).asMethod
      
      case "fax" => ru.typeOf[Customer.type].declaration(ru.newTermName("fax")).asMethod
      
      case "email" => ru.typeOf[Customer.type].declaration(ru.newTermName("email")).asMethod
      
      case "creditLimit" => ru.typeOf[Customer.type].declaration(ru.newTermName("creditLimit")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
