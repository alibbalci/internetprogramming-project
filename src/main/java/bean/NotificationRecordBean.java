package bean;

import entity.NotificationRecord;
import facadeLocal.NotificationRecordFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class NotificationRecordBean implements Serializable {

    @EJB
    private NotificationRecordFacadeLocal notificationRecordFacade;

    public List<NotificationRecord> getNotificationRecords() {
        return notificationRecordFacade.findAll();
    }
}
