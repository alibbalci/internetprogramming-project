package facade;

import entity.Professional;
import facadeLocal.ProfessionalFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProfessionalFacade extends AbstractFacade<Professional> implements ProfessionalFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public ProfessionalFacade() {
        super(Professional.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}