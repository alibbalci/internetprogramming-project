package facade;

import entity.NotificationRecord;
import facadeLocal.NotificationRecordFacadeLocal;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class NotificationRecordFacade extends AbstractFacade<NotificationRecord> implements NotificationRecordFacadeLocal {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public NotificationRecordFacade() {
        super(NotificationRecord.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
