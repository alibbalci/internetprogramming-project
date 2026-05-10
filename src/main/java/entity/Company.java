package entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "sgk_number")
    private String sgkNumber;

    @Column(name = "nace_code")
    private String naceCode;

    @Column(name = "business_line")
    private String businessLine;

    @Column(name = "hazard_class")
    private String hazardClass;

    @Column(name = "sgk_address", length = 500)
    private String sgkAddress;

    @Column(name = "authorized_person")
    private String authorizedPerson;

    private String phone;

    private String email;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSgkNumber() {
        return sgkNumber;
    }

    public void setSgkNumber(String sgkNumber) {
        this.sgkNumber = sgkNumber;
    }

    public String getNaceCode() {
        return naceCode;
    }

    public void setNaceCode(String naceCode) {
        this.naceCode = naceCode;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public String getHazardClass() {
        return hazardClass;
    }

    public void setHazardClass(String hazardClass) {
        this.hazardClass = hazardClass;
    }

    public String getSgkAddress() {
        return sgkAddress;
    }

    public void setSgkAddress(String sgkAddress) {
        this.sgkAddress = sgkAddress;
    }

    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}