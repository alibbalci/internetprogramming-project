package entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "finding_recommendation")
public class FindingRecommendation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Temporal(TemporalType.DATE)
    @Column(name = "finding_date")
    private Date findingDate;

    @Lob
    @Column(name = "finding")
    private String finding;

    @Lob
    @Column(name = "recommendation")
    private String recommendation;

    public FindingRecommendation() {
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

    public Date getFindingDate() {
        return findingDate;
    }

    public void setFindingDate(Date findingDate) {
        this.findingDate = findingDate;
    }

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
