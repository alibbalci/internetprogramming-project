package bean;

import entity.Company;
import entity.Employee;
import facadeLocal.CompanyFacadeLocal;
import facadeLocal.EmployeeFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @EJB
    private CompanyFacadeLocal companyFacade;

    private Employee employee = new Employee();

    private Long companyId;

    public void prepareNew() {
        employee = new Employee();
        companyId = null;
    }

    public void createEmployee() {
        if (!bindCompany()) {
            return;
        }
        employeeFacade.create(employee);
        prepareNew();
    }

    public void updateEmployee() {
        if (employee.getId() == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Güncelleme", "Önce listeden bir çalışan seçin.");
            return;
        }
        if (!bindCompany()) {
            return;
        }
        employeeFacade.edit(employee);
        prepareNew();
    }

    public void deleteEmployee(Employee selected) {
        employeeFacade.remove(selected);
        if (employee.getId() != null && employee.getId().equals(selected.getId())) {
            prepareNew();
        }
    }

    public void deleteCurrent() {
        if (employee == null || employee.getId() == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Silme", "Formda kayıtlı bir çalışan yok. Önce listeden Düzenle ile seçin.");
            return;
        }
        employeeFacade.remove(employee);
        prepareNew();
    }

    public String refresh() {
        return null;
    }

    public void selectEmployee(Employee selected) {
        this.employee = selected;
        if (selected.getCompany() != null) {
            this.companyId = selected.getCompany().getId();
        } else {
            this.companyId = null;
        }
    }

    public void clearForm() {
        prepareNew();
    }

    public List<Employee> getEmployees() {
        return employeeFacade.findAll();
    }

    public List<Company> getCompanies() {
        return companyFacade.findAll();
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    private boolean bindCompany() {
        if (companyId == null) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Firma", "Firma seçilmelidir.");
            return false;
        }
        Company c = companyFacade.find(companyId);
        if (c == null) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Firma", "Seçilen firma bulunamadı.");
            return false;
        }
        employee.setCompany(c);
        return true;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
