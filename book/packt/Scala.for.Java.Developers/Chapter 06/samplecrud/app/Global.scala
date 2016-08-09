
import play.api.GlobalSettings

import models._
import play.api.db.DB
import play.api.Application
import play.api.Play.current

import scala.slick.driver.H2Driver.simple._
// import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

import org.dbunit.dataset.xml.FlatXmlDataSetBuilder
import java.io.FileInputStream
import org.dbunit.operation.DatabaseOperation
import org.dbunit.database.DatabaseDataSourceConnection

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    lazy val database = Database.forDataSource(DB.getDataSource())

    database withSession {
    
      // Create the tables, including primary and foreign keys
      val ddl = (Customer.ddl ++ Manufacturer.ddl ++ PurchaseOrder.ddl ++ Language.ddl ++ MicroMarket.ddl ++ DiscountCode.ddl ++ ProductCode.ddl ++ Product.ddl)

      //ddl.drop
      ddl.create

      // Insert some suppliers (comment out these lines if you are using a different DB
      // Suppliers.insertAll(
      // Supplier(Some(101), "Acme, Inc.", "99 Market Street", "Groundsville", "CA", "95199"),
      // Supplier(Some(49), "Superior Coffee", "1 Party Place", "Mendocino", "CA", "95460"),
      // Supplier(Some(150), "The High Ground", "100 Coffee Lane", "Meadows", "CA", "93966"))

      // Insert some coffees (using JDBC's batch insert feature, if supported by the DB)
      // Coffees.insertAll(
      // Coffee(Some("Colombian"), 101, 799, 0, 0),
      // Coffee(Some("French_Roast"), 49, 899, 0, 0),
      // Coffee(Some("Espresso"), 150, 999, 0, 0),
      // Coffee(Some("Colombian_Decaf"), 101, 899, 0, 0),
      // Coffee(Some("French_Roast_Decaf"), 49, 999, 0, 0))
    }

    // Import testdata with DBUnit
    val connection = new DatabaseDataSourceConnection(DB.getDataSource())
    try {
      val data = new FlatXmlDataSetBuilder().build(new FileInputStream("./test/resources/testdata.xml"))
      DatabaseOperation.CLEAN_INSERT.execute(connection, data)
    } finally {
      connection.close()
    }
  }
}