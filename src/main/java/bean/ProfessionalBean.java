package bean;

import entity.Professional;
import facadeLocal.ProfessionalFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProfessionalBean implements Serializable {

    private Professional professional = new Professional();

    @EJB
    private ProfessionalFacadeLocal professionalFacade;

    public void createProfessional() {
        professionalFacade.create(professional);
        professional = new Professional();
    }

    public void updateProfessional() {
        professionalFacade.edit(professional);
        professional = new Professional();
    }

    public void deleteProfessional(Professional selectedProfessional) {
        professionalFacade.remove(selectedProfessional);
    }

    public void selectProfessional(Professional selectedProfessional) {
        this.professional = selectedProfessional;
    }

    public void clearForm() {
        this.professional = new Professional();
    }

    public List<Professional> getProfessionals() {
        return professionalFacade.findAll();
    }

    public Professional getProfessional() {
        if (professional == null) {
            professional = new Professional();
        }
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
