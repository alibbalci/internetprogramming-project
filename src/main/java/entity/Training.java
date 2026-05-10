package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "training")
public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "training_type")
    private String trainingType;

    @Column(name = "general_subjects")
    private Boolean generalSubjects;

    @Column(name = "health_subjects")
    private Boolean healthSubjects;

    @Column(name = "technical_subjects")
    private Boolean technicalSubjects;

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public Boolean getGeneralSubjects() {
        return generalSubjects;
    }

    public void setGeneralSubjects(Boolean generalSubjects) {
        this.generalSubjects = generalSubjects;
    }

    public Boolean getHealthSubjects() {
        return healthSubjects;
    }

    public void setHealthSubjects(Boolean healthSubjects) {
        this.healthSubjects = healthSubjects;
    }

    public Boolean getTechnicalSubjects() {
        return technicalSubjects;
    }

    public void setTechnicalSubjects(Boolean technicalSubjects) {
        this.technicalSubjects = technicalSubjects;
    }
}
