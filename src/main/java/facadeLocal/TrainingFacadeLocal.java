package facadeLocal;

import entity.Training;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface TrainingFacadeLocal {

    void create(Training training);

    Training edit(Training training);

    void remove(Training training);

    Training find(Long id);

    List<Training> findAll();
}
