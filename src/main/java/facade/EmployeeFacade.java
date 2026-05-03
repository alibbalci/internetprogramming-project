package facade;

import entity.Employee;
import facadeLocal.EmployeeFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Employee find(Long id) {
        return super.find(id);
    }
}
