package facade;

import entity.Training;
import facadeLocal.TrainingFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TrainingFacade extends AbstractFacade<Training> implements TrainingFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public TrainingFacade() {
        super(Training.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Training find(Long id) {
        return super.find(id);
    }
}
