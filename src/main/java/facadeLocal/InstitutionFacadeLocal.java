package facadeLocal;

import entity.Institution;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface InstitutionFacadeLocal {

    void create(Institution institution);

    Institution edit(Institution institution);

    void remove(Institution institution);

    Institution find(Long id);

    List<Institution> findAll();
}