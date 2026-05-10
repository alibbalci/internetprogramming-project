package facade;

import entity.Meeting;
import facadeLocal.MeetingFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class MeetingFacade extends AbstractFacade<Meeting> implements MeetingFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public MeetingFacade() {
        super(Meeting.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Meeting find(Long id) {
        return super.find(id);
    }
}
