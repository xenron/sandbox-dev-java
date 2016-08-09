





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class LanguageRow(id : Option[Int], name : Option[String])

// Definition of the LanguageRow table
object Language extends Table[LanguageRow]("LANGUAGE") {

  //def id = column[Int]("ID", O.PrimaryKey, O AutoInc) // This is the primary key column
  
  
  def id = column[Int]("ID", O.PrimaryKey) 
  
  
  def name = column[Option[String]]("NAME") 
  
    
  
  def * = id.? ~ name <> (LanguageRow.apply _, LanguageRow.unapply _)
  //def autoInc = id.? ~ id.? ~ name <> (LanguageRow.apply _, LanguageRow.unapply _) returning id 

  def findAll(filter: String = "%") = {
    for {
      entity <- Language
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: Int) =
    for (entity <- Language if entity.id === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.id -> id)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[LanguageRow].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "id" => ru.typeOf[Language.type].declaration(ru.newTermName("id")).asMethod
      
      case "name" => ru.typeOf[Language.type].declaration(ru.newTermName("name")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
