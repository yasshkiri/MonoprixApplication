package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;


@Entity
@Table(name="EnseigneConcurrent")
public class EnseigneConcurrent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id ;
    private String nom_ens ;
    private String img_ens ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreation", nullable = false, updatable = false ,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date datecreation ;
    @ManyToOne
    @JoinColumn(name="usercreation")
    private User usercreation ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateUpdate", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateUpdate ;
    @ManyToOne
    @JoinColumn(name="userUpdate")
    private User userUpdate ;

    @OneToMany(mappedBy="enseigne")
    @JsonIgnoreProperties(value ={"enseigne"},allowSetters = true)
    private List<sites> site ;

    public EnseigneConcurrent(Long id, String nom_ens, String img_ens, Date datecreation, User usercreation, Date dateUpdate, User userUpdate , List<sites> site) {
        this.id = id;
        this.nom_ens = nom_ens;
        this.img_ens = img_ens;
        this.datecreation = datecreation;
        this.usercreation = usercreation;
        this.dateUpdate = dateUpdate;
        this.userUpdate = userUpdate;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_ens() {
        return nom_ens;
    }

    public void setNom_ens(String nom_ens) {
        this.nom_ens = nom_ens;
    }

    public String getImg_ens() {
        return img_ens;
    }

    public void setImg_ens(String img_ens) {
        this.img_ens = img_ens;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public User getUsercreation() {
        return usercreation;
    }

    public void setUsercreation(User usercreation) {
        this.usercreation = usercreation;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public User getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(User userUpdate) {
        this.userUpdate = userUpdate;
    }

    public List<sites> getSite() {
       return site;
    }

    public void setSite(List<sites> site) {
        this.site = site;
    }

    public EnseigneConcurrent() {}
}
