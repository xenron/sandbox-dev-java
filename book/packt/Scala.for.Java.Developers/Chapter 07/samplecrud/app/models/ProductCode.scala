





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class ProductCod(prodCode : Option[String], discountCode : String, description : Option[String])

// Definition of the ProductCod table
object ProductCode extends Table[ProductCod]("PRODUCT_CODE") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def prodCode = column[String]("PROD_CODE", O.PrimaryKey) 
  
  
  def discountCode = column[String]("DISCOUNT_CODE") 
  
  
  def description = column[Option[String]]("DESCRIPTION") 
  
    
  
  def * = prodCode.? ~ discountCode ~ description <> (ProductCod.apply _, ProductCod.unapply _)
  //def autoInc = id.? ~ prodCode.? ~ discountCode ~ description <> (ProductCod.apply _, ProductCod.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- ProductCode
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: String) =
    for (entity <- ProductCode if entity.prodCode === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.prodCode -> prodCode)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[ProductCod].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "prodCode" => ru.typeOf[ProductCode.type].declaration(ru.newTermName("prodCode")).asMethod
      
      case "discountCode" => ru.typeOf[ProductCode.type].declaration(ru.newTermName("discountCode")).asMethod
      
      case "description" => ru.typeOf[ProductCode.type].declaration(ru.newTermName("description")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
