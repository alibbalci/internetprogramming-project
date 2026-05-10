package bean;

import entity.Company;
import entity.FindingRecommendation;
import facadeLocal.CompanyFacadeLocal;
import facadeLocal.FindingRecommendationFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class FindingRecommendationBean implements Serializable {

    private FindingRecommendation findingRecommendation = new FindingRecommendation();

    private Long companyId;

    @EJB
    private FindingRecommendationFacadeLocal findingRecommendationFacade;

    @EJB
    private CompanyFacadeLocal companyFacade;

    public void createFindingRecommendation() {
        if (!bindCompany()) {
            return;
        }
        findingRecommendationFacade.create(findingRecommendation);
        clearForm();
    }

    public void updateFindingRecommendation() {
        if (findingRecommendation.getId() == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Güncelleme", "Önce listeden bir tespit seçin.");
            return;
        }
        if (!bindCompany()) {
            return;
        }
        findingRecommendationFacade.edit(findingRecommendation);
        clearForm();
    }

    public void deleteFindingRecommendation(FindingRecommendation selectedFindingRecommendation) {
        findingRecommendationFacade.remove(selectedFindingRecommendation);
        if (findingRecommendation.getId() != null
                && findingRecommendation.getId().equals(selectedFindingRecommendation.getId())) {
            clearForm();
        }
    }

    public void selectFindingRecommendation(FindingRecommendation selectedFindingRecommendation) {
        this.findingRecommendation = selectedFindingRecommendation;
        if (selectedFindingRecommendation.getCompany() != null) {
            this.companyId = selectedFindingRecommendation.getCompany().getId();
        } else {
            this.companyId = null;
        }
    }

    public void clearForm() {
        this.findingRecommendation = new FindingRecommendation();
        this.companyId = null;
    }

    public List<FindingRecommendation> getFindingRecommendations() {
        return findingRecommendationFacade.findAll();
    }

    public List<Company> getCompanies() {
        return companyFacade.findAll();
    }

    public FindingRecommendation getFindingRecommendation() {
        if (findingRecommendation == null) {
            findingRecommendation = new FindingRecommendation();
        }
        return findingRecommendation;
    }

    public void setFindingRecommendation(FindingRecommendation findingRecommendation) {
        this.findingRecommendation = findingRecommendation;
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
        Company company = companyFacade.find(companyId);
        if (company == null) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Firma", "Seçilen firma bulunamadı.");
            return false;
        }
        findingRecommendation.setCompany(company);
        return true;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
