package net.ensode.glassfishbook.criteriaapi.namedbean;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import net.ensode.glassfishbook.criteriaapi.entity.UsState;

@Named
@RequestScoped
public class CriteriaApiDemoBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<UsState> matchingStatesList;

    public String findStates() {
        String retVal = "confirmation";
        try {
            CriteriaBuilder criteriaBuilder = entityManager.
                    getCriteriaBuilder();
            CriteriaQuery<UsState> criteriaQuery = criteriaBuilder.
                    createQuery(UsState.class);
            Root<UsState> root = criteriaQuery.from(UsState.class);

            Metamodel metamodel = entityManager.getMetamodel();
            EntityType<UsState> usStateEntityType = metamodel.entity(
                    UsState.class);
            SingularAttribute<UsState, String> usStateAttribute
                    = usStateEntityType.getDeclaredSingularAttribute("usStateNm",
                    String.class);
            Path<String> path = root.get(usStateAttribute);
            Predicate predicate = criteriaBuilder.like(
                    path, "New%");
            criteriaQuery = criteriaQuery.where(predicate);

            TypedQuery typedQuery = entityManager.createQuery(
                    criteriaQuery);

            matchingStatesList = typedQuery.getResultList();

        } catch (Exception e) {
            retVal = "error";
            e.printStackTrace();
        }

        return retVal;
    }

    public List<UsState> getMatchingStatesList() {
        return matchingStatesList;
    }

    public void setMatchingStatesList(List<UsState> matchingStatesList) {
        this.matchingStatesList = matchingStatesList;
    }

}
