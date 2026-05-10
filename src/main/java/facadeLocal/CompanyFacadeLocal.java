package facadeLocal;

import entity.Company;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface CompanyFacadeLocal {

    void create(Company company);

    Company edit(Company company);

    void remove(Company company);

    Company find(Long id);

    List<Company> findAll();
}