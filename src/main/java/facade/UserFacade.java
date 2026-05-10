package facade;

import entity.Users;
import facadeLocal.UserFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Stateless
public class UserFacade extends AbstractFacade<Users> implements UserFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public UserFacade() {
        super(Users.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void createUser(Users u) {
        getEntityManager().persist(u);
    }

    public Users editUser(Users entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(Users entity) {
        Users merged = getEntityManager().merge(entity);
        getEntityManager().remove(merged);
    }

    public List<Users> usersList() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);

        cq.select(root);

        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    public Users login(String email, String password) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);

        cq.select(root)
                .where(
                        cb.equal(root.get("email"), email),
                        cb.equal(root.get("password"), password)
                );

        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        List<Users> found = q.getResultList();

        return found.isEmpty() ? null : found.get(0);
    }
}