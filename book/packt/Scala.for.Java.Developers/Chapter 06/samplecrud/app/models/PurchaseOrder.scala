





package models

import play.api.db._
import play.api.Play.current
import java.sql.Date

import scala.slick.driver.H2Driver.simple._
import scala.reflect.runtime._
import scala.reflect.runtime.{ universe => ru }

case class PurchaseOrderRow(orderNum : Option[Int], customerId : Int, productId : Int, quantity : Option[Int], shippingCost : Option[Int], salesDate : Option[Date], shippingDate : Option[Date], freightCompany : Option[String])

// Definition of the PurchaseOrder table
object PurchaseOrder extends Table[PurchaseOrderRow]("PURCHASE_ORDER") {
 
  def orderNum = column[Int]("ORDER_NUM", O.PrimaryKey) 
  def customerId = column[Int]("CUSTOMER_ID")  
  def productId = column[Int]("PRODUCT_ID")   
  def quantity = column[Option[Int]]("QUANTITY") 
  def shippingCost = column[Option[Int]]("SHIPPING_COST") 
  def salesDate = column[Option[Date]]("SALES_DATE")  
  def shippingDate = column[Option[Date]]("SHIPPING_DATE") 
  def freightCompany = column[Option[String]]("FREIGHT_COMPANY") 
 
  def * = orderNum.? ~ customerId ~ productId ~ quantity ~ shippingCost ~ salesDate ~ shippingDate ~ freightCompany <> (PurchaseOrderRow.apply _, PurchaseOrderRow.unapply _)

  def findAll(filter: String = "%") = {
    for {
      entity <- PurchaseOrder
      // if (entity.name like ("%" + filter))
    } yield entity
  }

  def findByPK(pk: Int) =
    for (entity <- PurchaseOrder if entity.orderNum === pk) yield entity
  
    
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options = this.findAll().map(x => x.orderNum -> orderNum)
  
  val mirror = ru.runtimeMirror(getClass.getClassLoader)
  
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, order: String, asc: Boolean = false, filter: String = "%") = {
    val members = ru.typeOf[PurchaseOrderRow].members.filter(m => m.isTerm && !m.isMethod).toList
    val fields = members.map(_.name.decoded.trim).reverse.toVector
    println("Fields of Supplier class: " + fields)

    val sortField: String = fields(orderBy.abs - 1)
    println("The field to sort against is: " + sortField)

    // Need to give the sorting field at compile time... is there a better way ?
    val methodFields = sortField match {
      
      case "orderNum" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("orderNum")).asMethod
      
      case "customerId" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("customerId")).asMethod
      
      case "productId" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("productId")).asMethod
      
      case "quantity" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("quantity")).asMethod
      
      case "shippingCost" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("shippingCost")).asMethod
      
      case "salesDate" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("salesDate")).asMethod
      
      case "shippingDate" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("shippingDate")).asMethod
      
      case "freightCompany" => ru.typeOf[PurchaseOrder.type].declaration(ru.newTermName("freightCompany")).asMethod
      
    }

    findAll().sortBy { x =>    
      val reflectedMethod = mirror.reflect(x).reflectMethod(methodFields)().asInstanceOf[Column[Any]]
      if (orderBy >= 0) reflectedMethod.asc
      else reflectedMethod.desc
    }.drop(page * pageSize).take(pageSize)
  }

}
