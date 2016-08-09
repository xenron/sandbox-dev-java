package se.sfjd
 
import org.springframework.beans.factory.annotation._
import org.springframework.stereotype._
import org.springframework.transaction.annotation.{Propagation, Transactional}
import javax.persistence._
import scala.collection.JavaConversions._
 
@Repository("languageDao")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
class LanguageDaoImpl extends LanguageDao {
 
    @Autowired
    var entityManager: EntityManager = _
 
    def save(language: Language): Unit = language.id match {
        case 0 => entityManager.persist(language)
        case _ => entityManager.merge(language)
    }
 
    def find(id: Int): Option[Language] = {
        Option(entityManager.find(classOf[Language], id))
    }
 
    def getAll: List[Language] = {
        entityManager.createQuery("FROM Language", classOf[Language]).getResultList.toList
    }
 
    def getByName(name : String): List[Language] = {
        entityManager.createQuery("FROM Language WHERE name = :name", classOf[Language]).setParameter("name", name).getResultList.toList
    }
}