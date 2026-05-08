package facadeLocal;

import entity.Professional;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ProfessionalFacadeLocal {

    void create(Professional professional);

    Professional edit(Professional professional);

    void remove(Professional professional);

    Professional find(Object id);

    List<Professional> findAll();
}