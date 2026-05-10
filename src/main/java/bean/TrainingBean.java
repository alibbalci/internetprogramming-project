package bean;

import entity.Training;
import entity.Company;
import facadeLocal.CompanyFacadeLocal;
import facadeLocal.TrainingFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TrainingBean implements Serializable {

    private Training training = new Training();

    @EJB
    private TrainingFacadeLocal trainingFacade;

    @EJB
    private CompanyFacadeLocal companyFacade;

    private Long companyId;

    public void createTraining() {
        if (!bindCompany()) {
            return;
        }
        trainingFacade.create(training);
        clearForm();
    }

    public void updateTraining() {
        if (training.getId() == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "Güncelleme", "Önce listeden bir eğitim seçin.");
            return;
        }
        if (!bindCompany()) {
            return;
        }
        trainingFacade.edit(training);
        clearForm();
    }

    public void deleteTraining(Training selectedTraining) {
        trainingFacade.remove(selectedTraining);
        if (training.getId() != null && training.getId().equals(selectedTraining.getId())) {
            clearForm();
        }
    }

    public void selectTraining(Training selectedTraining) {
        this.training = selectedTraining;
        if (selectedTraining.getCompany() != null) {
            this.companyId = selectedTraining.getCompany().getId();
        } else {
            this.companyId = null;
        }
    }

    public void clearForm() {
        this.training = new Training();
        this.companyId = null;
    }

    public List<Training> getTrainings() {
        return trainingFacade.findAll();
    }

    public List<Company> getCompanies() {
        return companyFacade.findAll();
    }

    public Training getTraining() {
        if (training == null) {
            training = new Training();
        }
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
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
        training.setCompany(company);
        return true;
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
