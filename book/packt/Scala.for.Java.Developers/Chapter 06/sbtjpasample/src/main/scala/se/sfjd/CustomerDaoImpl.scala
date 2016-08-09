package se.sfjd
 
import org.springframework.beans.factory.annotation._
import org.springframework.stereotype._
import org.springframework.transaction.annotation.{Propagation, Transactional}
import javax.persistence._
import scala.collection.JavaConversions._
 
@Repository("customerDao")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
class CustomerDaoImpl extends CustomerDao {
 
    @Autowired
    var entityManager: EntityManager = _
 
    def save(customer: Customer): Unit = customer.id match {
        case 0 => entityManager.persist(customer)
        case _ => entityManager.merge(customer)
    }
 
    def find(id: Int): Option[Customer] = {
        Option(entityManager.find(classOf[Customer], id))
    }
 
    def getAll: List[Customer] = {
        entityManager.createQuery("FROM Customer", classOf[Customer]).getResultList.toList
    }
}