package facade;

import entity.Company;
import facadeLocal.CompanyFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CompanyFacade extends AbstractFacade<Company> implements CompanyFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public CompanyFacade() {
        super(Company.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Company find(Long id) {
        return super.find(id);
    }
}
