package facade;

import entity.FindingRecommendation;
import facadeLocal.FindingRecommendationFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FindingRecommendationFacade extends AbstractFacade<FindingRecommendation> implements FindingRecommendationFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public FindingRecommendationFacade() {
        super(FindingRecommendation.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public FindingRecommendation find(Long id) {
        return super.find(id);
    }
}
