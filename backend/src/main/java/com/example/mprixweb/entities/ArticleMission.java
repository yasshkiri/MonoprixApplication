package com.example.mprixweb.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="ArticleMission")
public class ArticleMission implements Serializable {
    public enum scanner { SCAN , BORNE}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name="id_miss")
    private mission id_miss ;
    private String codebarre_artM ;
    private String design_artM ;
    private boolean planifie ;
    private boolean traite ;
    @Enumerated(EnumType.STRING)
    @Column(name="TypeScan")
    private scanner  TypeScan ;
    private double dernier_prix ;
    private double prixActuel ;
    private double dernier_prixpromo ;
    private double prixpromoActuel ;
    @Column(name="imageArticleM")
    private String img_artM ;
    @Column(name="EnStock")
    private boolean enstock_artM ;
    private boolean reconnue ;
    private int gamme_artM ;
    private String famille_artM ;
    private String marque_artM ;
    private String poids ;
    private String volume  ;
    @Column(name="fournisseur")
    private String fournisseur ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_Releve", nullable=true )
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_releve ;
    private Long id_user ;

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

    public ArticleMission(Long id, mission id_miss, String codebarre_artM, String design_artM, boolean planifie, boolean traite, scanner typeScan, double dernier_prix, double prixActuel, double dernier_prixpromo, double prixpromoActuel, String img_artM, boolean enstock_artM, boolean reconnue, int gamme_artM, String famille_artM, String marque_artM, String poids, String volume, String fournisseur, Date date_releve, Long id_user, Date datecreation, User usercreation, Date dateUpdate, User userUpdate) {
        this.id = id;
        this.id_miss = id_miss;
        this.codebarre_artM = codebarre_artM;
        this.design_artM = design_artM;
        this.planifie = planifie;
        this.traite = traite;
        TypeScan = typeScan;
        this.dernier_prix = dernier_prix;
        this.prixActuel = prixActuel;
        this.dernier_prixpromo = dernier_prixpromo;
        this.prixpromoActuel = prixpromoActuel;
        this.img_artM = img_artM;
        this.enstock_artM = enstock_artM;
        this.reconnue = reconnue;
        this.gamme_artM = gamme_artM;
        this.famille_artM = famille_artM;
        this.marque_artM = marque_artM;
        this.poids = poids;
        this.volume = volume;
        this.fournisseur = fournisseur;
        this.date_releve = date_releve;
        this.id_user = id_user;
        this.datecreation = datecreation;
        this.usercreation = usercreation;
        this.dateUpdate = dateUpdate;
        this.userUpdate = userUpdate;
    }

    public ArticleMission(Articles article, mission id_miss){
        //this.id = id;
        this.id_miss = id_miss;
        this.codebarre_artM = article.getCode_art();
        this.design_artM = article.getDesign_art();
        this.planifie = true;
        this.traite = false;
        this.dernier_prix = article.getPrix_art();
        //this.prixActuel = prixActuel;
        //this.dernier_prixpromo = dernier_prixpromo;
        //this.prixpromoActuel = prixpromoActuel;
        //this.img_artM = img_artM;
        //this.enstock_artM = enstock_artM;
        this.reconnue = true;
        this.gamme_artM = article.getGamme_art();
        //this.famille_artM = famille_artM;
        this.marque_artM = article.getMarque_art();
        //this.poids = poids;
        //this.volume = volume;
        //this.fournisseur = fournisseur;
        //this.date_releve = date_releve;
        //this.id_user = id_user;
        this.datecreation = new Date();
        //this.usercreation = usercreation;
        this.dateUpdate = new Date();
        //this.userUpdate = userUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_miss(mission id_miss) {
        this.id_miss = id_miss;
    }

    public mission getId_miss() {
        return id_miss;
    }

    public String getCodebarre_artM() {
        return codebarre_artM;
    }

    public void setCodebarre_artM(String codebarre_artM) {
        this.codebarre_artM = codebarre_artM;
    }

    public String getDesign_artM() {
        return design_artM;
    }

    public void setDesign_artM(String design_artM) {
        this.design_artM = design_artM;
    }

    public boolean isPlanifie() {
        return planifie;
    }

    public void setPlanifie(boolean planifie) {
        this.planifie = planifie;
    }

    public boolean isTraite() {
        return traite;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public scanner getTypeScan() {
        return TypeScan;
    }

    public void setTypeScan(scanner typeScan) {
        TypeScan = typeScan;
    }

    public double getDernier_prix() {
        return dernier_prix;
    }

    public void setDernier_prix(double dernier_prix) {
        this.dernier_prix = dernier_prix;
    }

    public double getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(double prixActuel) {
        this.prixActuel = prixActuel;
    }

    public double getDernier_prixpromo() {
        return dernier_prixpromo;
    }

    public void setDernier_prixpromo(double dernier_prixpromo) {
        this.dernier_prixpromo = dernier_prixpromo;
    }

    public double getPrixpromoActuel() {
        return prixpromoActuel;
    }

    public void setPrixpromoActuel(double prixpromoActuel) {
        this.prixpromoActuel = prixpromoActuel;
    }

    public String getImg_artM() {
        return img_artM;
    }

    public void setImg_artM(String img_artM) {
        this.img_artM = img_artM;
    }

    public boolean isEnstock_artM() {
        return enstock_artM;
    }

    public void setEnstock_artM(boolean enstock_artM) {
        this.enstock_artM = enstock_artM;
    }

    public boolean isReconnue() {
        return reconnue;
    }

    public void setReconnue(boolean reconnue) {
        this.reconnue = reconnue;
    }

    public int getGamme_artM() {
        return gamme_artM;
    }

    public void setGamme_artM(int gamme_artM) {
        this.gamme_artM = gamme_artM;
    }

    public String getFamille_artM() {
        return famille_artM;
    }

    public void setFamille_artM(String famille_artM) {
        this.famille_artM = famille_artM;
    }

    public String getMarque_artM() {
        return marque_artM;
    }

    public void setMarque_artM(String marque_artM) {
        this.marque_artM = marque_artM;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Date getDate_releve() {
        return date_releve;
    }

    public void setDate_releve(Date date_releve) {
        this.date_releve = date_releve;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
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

    public ArticleMission () {

    }

}
