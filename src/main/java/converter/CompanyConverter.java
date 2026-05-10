package converter;

import entity.Company;
import facadeLocal.CompanyFacadeLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Named;

/**
 * CompanyConverter, JSF arayüzündeki (XHTML) seçim menülerinde (dropdown) 
 * kullanılan String tipindeki ID'leri, Java tarafındaki Company nesnesine 
 * dönüştürmek için kullanılır. 
 * 
 * Bu sınıf olmadan, açılır menüden bir firma seçildiğinde JSF bu veriyi 
 * hangi Company nesnesine atayacağını bilemez ve hata verir.
 */
@Named
@RequestScoped
public class CompanyConverter implements Converter<Company> {

    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    public Company getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return companyFacade.find(Long.valueOf(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Company value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return String.valueOf(value.getId());
    }
}
