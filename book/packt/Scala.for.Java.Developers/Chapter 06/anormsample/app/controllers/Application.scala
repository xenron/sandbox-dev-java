package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current
import models._

object Application extends Controller {

  def index = Action {
    
    val result = 
      DB.withConnection { implicit c =>
        
        Customer.findById(2) match {
          case Some(customer) => s"Found the customer: ${customer.name}"
          case None => "No customer was found."
      }
    }
    
    Ok(views.html.index(result))
  }
}