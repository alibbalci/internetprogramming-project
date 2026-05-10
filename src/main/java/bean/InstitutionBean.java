package bean;

import entity.Institution;
import facadeLocal.InstitutionFacadeLocal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class InstitutionBean implements Serializable {

    private Institution institution = new Institution();

    @EJB
    private InstitutionFacadeLocal institutionFacade;

    @PostConstruct
    public void init() {
        loadInstitution();
    }

    public void loadInstitution() {
        List<Institution> institutions = institutionFacade.findAll();

        if (institutions != null && !institutions.isEmpty()) {
            institution = institutions.get(0);
        } else {
            institution = new Institution();
        }
    }

    public void saveOrUpdate() {
        if (institution.getId() == null) {
            institutionFacade.create(institution);
        } else {
            institutionFacade.edit(institution);
        }

        loadInstitution();
    }

    public void clear() {
        institution = new Institution();
    }

    public Institution getInstitution() {
        if (institution == null) {
            institution = new Institution();
        }
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
