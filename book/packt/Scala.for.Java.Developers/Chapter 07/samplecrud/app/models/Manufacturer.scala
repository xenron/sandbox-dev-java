





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class Manufacture(manufacturerId : Option[Int], name : Option[String], addressline1 : Option[String], addressline2 : Option[String], city : Option[String], state : Option[String], zip : Option[String], phone : Option[String], fax : Option[String], email : Option[String], rep : Option[String])

// Definition of the Manufacture table
object Manufacturer extends Table[Manufacture]("MANUFACTURER") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def manufacturerId = column[Int]("MANUFACTURER_ID", O.PrimaryKey) 
  
  
  def name = column[Option[String]]("NAME") 
  
  
  def addressline1 = column[Option[String]]("ADDRESSLINE1") 
  
  
  def addressline2 = column[Option[String]]("ADDRESSLINE2") 
  
  
  def city = column[Option[String]]("CITY") 
  
  
  def state = column[Option[String]]("STATE") 
  
  
  def zip = column[Option[String]]("ZIP") 
  
  
  def phone = column[Option[String]]("PHONE") 
  
  
  def fax = column[Option[String]]("FAX") 
  
  
  def email = column[Option[String]]("EMAIL") 
  
  
  def rep = column[Option[String]]("REP") 
  
    
  
  def * = manufacturerId.? ~ name ~ addressline1 ~ addressline2 ~ city ~ state ~ zip ~ phone ~ fax ~ email ~ rep <> (Manufacture.apply _, Manufacture.unapply _)
  //def autoInc = id.? ~ manufacturerId.? ~ name ~ addressline1 ~ addressline2 ~ city ~ state ~ zip ~ phone ~ fax ~ email ~ rep <> (Manufacture.apply _, Manufacture.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- Manufacturer
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: Int) =
    for (entity <- Manufacturer if entity.manufacturerId === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.manufacturerId -> manufacturerId)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[Manufacture].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "manufacturerId" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("manufacturerId")).asMethod
      
      case "name" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("name")).asMethod
      
      case "addressline1" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("addressline1")).asMethod
      
      case "addressline2" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("addressline2")).asMethod
      
      case "city" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("city")).asMethod
      
      case "state" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("state")).asMethod
      
      case "zip" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("zip")).asMethod
      
      case "phone" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("phone")).asMethod
      
      case "fax" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("fax")).asMethod
      
      case "email" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("email")).asMethod
      
      case "rep" => ru.typeOf[Manufacturer.type].declaration(ru.newTermName("rep")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
