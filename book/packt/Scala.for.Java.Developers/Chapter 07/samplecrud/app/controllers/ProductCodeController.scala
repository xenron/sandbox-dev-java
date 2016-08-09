

package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import views._
import models._

import play.api.db.DB
import play.api.Play.current

// Use H2Driver to connect to an H2 database
import scala.slick.driver.H2Driver.simple._

// Use the implicit threadLocalSession
import Database.threadLocalSession

/**
 * Controller
 */
object ProductCodeController extends Controller { 

  lazy val database = Database.forDataSource(DB.getDataSource())

  val pageSize = 3

  /**
   * This result directly redirect to the application home.
   */
  val Home = Redirect(routes.ProductCodeController.list(0, 2, ""))

  //val supplierSelect = database withSession {
  //  Suppliers.options.list.map(item => (item._1.toString, item._2))
  //}
  
  /**
   * Describe the entity form (used in both edit and create screens).
   */ 
  val form = Form(
    mapping(
      //"id" -> optional(number),
      "prodCode" -> optional(nonEmptyText),
      "discountCode" -> nonEmptyText,
      "description" -> optional(nonEmptyText)
    )(ProductCod.apply)(ProductCod.unapply)
  )
  
  // -- Actions

  /**
   * Handle default path requests, redirect to list
   */  
  def index = Action { Home }
  
  /**
   * Display the paginated list of product_code.
   *
   * @param page Current page number (starts from 0)
   * @param orderBy Column to be sorted
   * @param filter Filter applied on entity names
   */
  def list(page: Int, orderBy: Int, filter: String = "%") = Action { implicit request =>
    database withSession {
      Ok(html.productcode.list(
        Page(ProductCode.list(page, pageSize, orderBy, filter).list,
        page, 
        offset = pageSize * page,
        ProductCode.findAll(filter).list.size),
        orderBy,
        filter))
    }
  }
  
  /**
   * Display the 'new form'.
   */
  def create = Action {
    database withSession {
      Ok(html.productcode.createForm(form)) // ,supplierSelect))
    }
  }
  
  /**
   * Handle the 'new form' submission.
   */
  def save = Action { implicit request =>
    form.bindFromRequest.fold(
      formWithErrors => BadRequest(html.productcode.createForm(formWithErrors)), // supplierSelect)),
      entity => {
        database withTransaction {
          ProductCode.insert(entity)
          Home.flashing("success" -> s"Entity ${entity} has been created")
        }
      })
  }
  
  /**
   * Display the 'edit form' of an existing entity.
   *
   * @param pk primary key of the entity to edit
   */
  def edit(pk: String) = Action {
    database withSession {
      ProductCode.findByPK(pk).list.headOption match {
        case Some(e) => Ok(html.productcode.editForm(pk, form.fill(e))) //, supplierSelect))
        case None => NotFound
      }
    }
  }

  /**
   * Handle the 'edit form' submission
   *
   * @param pk primary key of the entity to edit
   */
  def update(pk: String) = Action { implicit request =>
    database withSession {
      form.bindFromRequest.fold(
        formWithErrors => BadRequest(html.productcode.editForm(pk, formWithErrors)), // supplierSelect)),
        entity => {
          Home.flashing(ProductCode.findByPK(pk).update(entity) match {
            case 0 => "failure" -> s"Could not update entity ${entity}"
            case _ => "success" -> s"Entity ${entity} has been updated"
          })
        })
    }
  }
  
  /**
   * Handle entity deletion.
   */
  def delete(pk: String) = Action {
    database withSession {
      Home.flashing(ProductCode.findByPK(pk).delete match {
        case 0 => "failure" -> "Entity has Not been deleted"
        case x => "success" -> s"Entity has been deleted (deleted $x row(s))"
      })
    }
  }

}
            