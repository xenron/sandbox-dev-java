package anormsample

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.db._
import play.api.Play.current

@RunWith(classOf[JUnitRunner])
class CustomerSpec extends Specification {
  
  import models._
  
  "Customer model" should {
    
    "be retrieved by id" in {
      DB.withConnection { implicit c =>
        
        val Some(newent) = Customer.findById(2)
      
        newent.name must equalTo("New Enterprises")      
      }
    }
  }
}