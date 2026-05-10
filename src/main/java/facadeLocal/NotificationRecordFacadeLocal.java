package facadeLocal;

import entity.NotificationRecord;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface NotificationRecordFacadeLocal {

    List<NotificationRecord> findAll();
}
