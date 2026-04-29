package bean;

import entity.Institution;
import facadeLocal.InstitutionFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("institutionBean")
@SessionScoped
public class InstitutionBean implements Serializable {

    @EJB
    private InstitutionFacadeLocal institutionFacade;

    private Institution institution = new Institution();

    public void save() {
        institutionFacade.create(institution);
        institution = new Institution();
    }

    public void update() {
        institutionFacade.edit(institution);
        institution = new Institution();
    }

    public void delete(Institution selectedInstitution) {
        institutionFacade.remove(selectedInstitution);
        institution = new Institution();
    }

    public void select(Institution selectedInstitution) {
        this.institution = selectedInstitution;
    }

    public void clear() {
        this.institution = new Institution();
    }

    public List<Institution> getList() {
        return institutionFacade.findAll();
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}