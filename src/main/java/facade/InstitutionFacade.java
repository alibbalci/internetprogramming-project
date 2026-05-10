package facade;

import entity.Institution;
import facadeLocal.InstitutionFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class InstitutionFacade extends AbstractFacade<Institution> implements InstitutionFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public InstitutionFacade() {
        super(Institution.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Institution find(Long id) {
        return super.find(id);
    }
}