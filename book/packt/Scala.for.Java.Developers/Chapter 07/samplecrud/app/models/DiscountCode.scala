





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class DiscountCod(discountCode : Option[String], rate : Option[Int])

// Definition of the DiscountCod table
object DiscountCode extends Table[DiscountCod]("DISCOUNT_CODE") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def discountCode = column[String]("DISCOUNT_CODE", O.PrimaryKey) 
  
  
  def rate = column[Option[Int]]("RATE") 
  
    
  
  def * = discountCode.? ~ rate <> (DiscountCod.apply _, DiscountCod.unapply _)
  //def autoInc = id.? ~ discountCode.? ~ rate <> (DiscountCod.apply _, DiscountCod.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- DiscountCode
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: String) =
    for (entity <- DiscountCode if entity.discountCode === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.discountCode -> discountCode)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[DiscountCod].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "discountCode" => ru.typeOf[DiscountCode.type].declaration(ru.newTermName("discountCode")).asMethod
      
      case "rate" => ru.typeOf[DiscountCode.type].declaration(ru.newTermName("rate")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
