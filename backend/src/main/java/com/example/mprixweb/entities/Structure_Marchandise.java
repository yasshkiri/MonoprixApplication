package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

@Entity
@Table(name="structuremarchandise")
public class Structure_Marchandise implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
	private int depart ; 
	private String libelle_depart ; 
	private int groupe ; 
    private String libelle_grp ; 
    private int rayon ; 
    private String libelle_rayon ; 
    private int famille ; 
    private int code_fam ; 
    private String libelle_fam ;
    private int sous_famille ; 
    private String libelle_sfamille ; 
    private int categorie ; 
    private String libelle_categ ; 
    private int sous_categ ; 
    private String libelle_scateg ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreation", nullable = false, updatable = false ,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date datecreation ;
    @ManyToOne
    @JoinColumn(name="usercreation")
    private User usercreation  ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateUpdate", nullable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateUpdate ;
    @ManyToOne
    @JoinColumn(name="userUpdate")
    private User userUpdate  ;

    public Structure_Marchandise( Long id, int depart, String libelle_depart, int groupe, String libelle_grp, int rayon, String libelle_rayon, int famille, int code_fam, String libelle_fam, int sous_famille, String libelle_sfamille, int categorie, String libelle_categ, int sous_categ, String libelle_scateg, Date datecreation, User usercreation, Date dateUpdate, User userUpdate) {
        this.id = id;
        this.depart = depart;
        this.libelle_depart = libelle_depart;
        this.groupe = groupe;
        this.libelle_grp = libelle_grp;
        this.rayon = rayon;
        this.libelle_rayon = libelle_rayon;
        this.famille = famille;
        this.code_fam = code_fam;
        this.libelle_fam = libelle_fam;
        this.sous_famille = sous_famille;
        this.libelle_sfamille = libelle_sfamille;
        this.categorie = categorie;
        this.libelle_categ = libelle_categ;
        this.sous_categ = sous_categ;
        this.libelle_scateg = libelle_scateg;
        this.datecreation = datecreation;
        this.usercreation = usercreation;
        this.dateUpdate = dateUpdate;
        this.userUpdate = userUpdate;
    }

    public Long getId() {
        return id ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public String getLibelle_depart() {
        return libelle_depart;
    }

    public void setLibelle_depart(String libelle_depart) {
        this.libelle_depart = libelle_depart;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public String getLibelle_grp() {
        return libelle_grp;
    }

    public void setLibelle_grp(String libelle_grp) {
        this.libelle_grp = libelle_grp;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public String getLibelle_rayon() {
        return libelle_rayon;
    }

    public void setLibelle_rayon(String libelle_rayon) {
        this.libelle_rayon = libelle_rayon;
    }

    public int getFamille() {
        return famille;
    }

    public void setFamille(int famille) {
        this.famille = famille;
    }

    public int getCode_fam() {
        return code_fam;
    }

    public void setCode_fam(int code_fam) {
        this.code_fam = code_fam;
    }

    public String getLibelle_fam() {
        return libelle_fam;
    }

    public void setLibelle_fam(String libelle_fam) {
        this.libelle_fam = libelle_fam;
    }

    public int getSous_famille() {
        return sous_famille;
    }

    public void setSous_famille(int sous_famille) {
        this.sous_famille = sous_famille;
    }

    public String getLibelle_sfamille() {
        return libelle_sfamille;
    }

    public void setLibelle_sfamille(String libelle_sfamille) {
        this.libelle_sfamille = libelle_sfamille;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getLibelle_categ() {
        return libelle_categ;
    }

    public void setLibelle_categ(String libelle_categ) {
        this.libelle_categ = libelle_categ;
    }

    public int getSous_categ() {
        return sous_categ;
    }

    public void setSous_categ(int sous_categ) {
        this.sous_categ = sous_categ;
    }

    public String getLibelle_scateg() {
        return libelle_scateg;
    }

    public void setLibelle_scateg(String libelle_scateg) {
        this.libelle_scateg = libelle_scateg;
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

    public Structure_Marchandise() {

    }


}
