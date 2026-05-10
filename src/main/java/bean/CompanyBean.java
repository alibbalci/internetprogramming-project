package bean;

import entity.Company;
import facadeLocal.CompanyFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CompanyBean implements Serializable {

    private Company company = new Company();

    @EJB
    private CompanyFacadeLocal companyFacade;

    public void createCompany() {
        companyFacade.create(company);
        company = new Company();
    }

    public void updateCompany() {
        companyFacade.edit(company);
        company = new Company();
    }

    public void deleteCompany(Company selectedCompany) {
        companyFacade.remove(selectedCompany);
    }

    public void selectCompany(Company selectedCompany) {
        this.company = selectedCompany;
    }

    public void clearForm() {
        this.company = new Company();
    }

    public List<Company> getCompanies() {
        return companyFacade.findAll();
    }

    public Company getCompany() {
        if (company == null) {
            company = new Company();
        }
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
