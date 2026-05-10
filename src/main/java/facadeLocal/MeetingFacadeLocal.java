package facadeLocal;

import entity.Meeting;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface MeetingFacadeLocal {

    void create(Meeting meeting);

    Meeting edit(Meeting meeting);

    void remove(Meeting meeting);

    Meeting find(Long id);

    List<Meeting> findAll();
}
