





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class MicroMarketRow(zipCode : Option[String], radius : Option[Int], areaLength : Option[Int], areaWidth : Option[Int])

// Definition of the MicroMarketRow table
object MicroMarket extends Table[MicroMarketRow]("MICRO_MARKET") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def zipCode = column[String]("ZIP_CODE", O.PrimaryKey) 
  
  
  def radius = column[Option[Int]]("RADIUS") 
  
  
  def areaLength = column[Option[Int]]("AREA_LENGTH") 
  
  
  def areaWidth = column[Option[Int]]("AREA_WIDTH") 
  
    
  
  def * = zipCode.? ~ radius ~ areaLength ~ areaWidth <> (MicroMarketRow.apply _, MicroMarketRow.unapply _)
  //def autoInc = id.? ~ zipCode.? ~ radius ~ areaLength ~ areaWidth <> (MicroMarketRow.apply _, MicroMarketRow.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- MicroMarket
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: String) =
    for (entity <- MicroMarket if entity.zipCode === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.zipCode -> zipCode)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[MicroMarketRow].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "zipCode" => ru.typeOf[MicroMarket.type].declaration(ru.newTermName("zipCode")).asMethod
      
      case "radius" => ru.typeOf[MicroMarket.type].declaration(ru.newTermName("radius")).asMethod
      
      case "areaLength" => ru.typeOf[MicroMarket.type].declaration(ru.newTermName("areaLength")).asMethod
      
      case "areaWidth" => ru.typeOf[MicroMarket.type].declaration(ru.newTermName("areaWidth")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
