package entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "institution")
public class Institution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="osgb_title")
    private String osgbTitle;

    private String address;

    public Institution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOsgbTitle() {
        return osgbTitle;
    }

    public void setOsgbTitle(String osgbTitle) {
        this.osgbTitle = osgbTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}