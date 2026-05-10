package facadeLocal;

import entity.Employee;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    Employee edit(Employee employee);

    void remove(Employee employee);

    Employee find(Long id);

    List<Employee> findAll();
}
