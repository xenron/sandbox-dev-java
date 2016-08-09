package se.sfjd

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.springframework.context.support.ClassPathXmlApplicationContext

@RunWith(classOf[JUnitRunner])
class CustomerTest extends FunSuite {
  
  val ctx = new ClassPathXmlApplicationContext("application-context.xml")
  
  test("There are 13 Customers in the derby DB") {
    
    val customerDao  = ctx.getBean(classOf[CustomerDao])
    val customers = customerDao.getAll
    assert(customers.size === 13) 
    println(customerDao
      .find(3)
      .getOrElse("No customer found with id 3"))
//    customerDao.find(3) match {
//      case Some(x) => println(x)
//      case None => println("No customer found with id 3")
//    }
  }
    
  test("Persisting 3 new languages") {
    val languageDao = ctx.getBean(classOf[LanguageDao])
    languageDao.save(new Language("English"))
    languageDao.save(new Language("French"))
    languageDao.save(new Language("Swedish"))
    val languages = languageDao.getAll
    assert(languages.size === 3) 
    assert(languageDao.getByName("French").size ===1) 
  }
}