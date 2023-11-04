package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

@Entity
@Table(name="mission")
public class mission implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nom_miss ; 
    private String descrip_miss ;
    @ManyToOne
    @JoinColumn(name="id_type")
    private Types_mission id_type ;
    private String etat ;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_miss ;
    private int maxdiff ; 
    private String tags ; 
    private boolean rupture ; 
    private boolean  nonreconnue ; 
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_debut  ; 
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_cloturer ;
    private double longitude ; 
    private double latitude ;


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

    @ManyToMany
    @JoinTable(name ="user_mission",
            joinColumns = @JoinColumn(name="id_miss"),
            inverseJoinColumns = @JoinColumn(name="id_user")
    )
    private List<User> users ;

    @ManyToMany
    @JoinTable( name="sites_mission" ,
            joinColumns = @JoinColumn(name="id_miss"),
            inverseJoinColumns = @JoinColumn(name="id_site")
    )
    @JsonIgnoreProperties("mission")
    private List<sites> site ;


    public mission(Long id, String nom_miss, String descrip_miss, Types_mission id_type, String etat, Date date_miss, int maxdiff, String tags, boolean rupture, boolean nonreconnue, Date date_debut, Date date_cloturer, double longitude, double latitude, Date datecreation, User usercreation, Date dateUpdate, User userUpdate, List<User> users, List<sites> site) {
        this.id = id;
        this.nom_miss = nom_miss;
        this.descrip_miss = descrip_miss;
        this.id_type = id_type;
        this.etat = etat;
        this.date_miss = date_miss;
        this.maxdiff = maxdiff;
        this.tags = tags;
        this.rupture = rupture;
        this.nonreconnue = nonreconnue;
        this.date_debut = date_debut;
        this.date_cloturer = date_cloturer;
        this.longitude = longitude;
        this.latitude = latitude;
        this.datecreation = datecreation;
        this.usercreation = usercreation;
        this.dateUpdate = dateUpdate;
        this.userUpdate = userUpdate;
        this.users = users;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_miss() {
        return nom_miss;
    }

    public void setNom_miss(String nom_miss) {
        this.nom_miss = nom_miss;
    }

    public String getDescrip_miss() {
        return descrip_miss;
    }

    public void setDescrip_miss(String descrip_miss) {
        this.descrip_miss = descrip_miss;
    }

    public Types_mission getId_type() {
        return id_type;
    }

    public void setId_type(Types_mission id_type) {
        this.id_type = id_type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDate_miss() {
        return date_miss;
    }

    public void setDate_miss(Date date_miss) {
        this.date_miss = date_miss;
    }

    public int getMaxdiff() {
        return maxdiff;
    }

    public void setMaxdiff(int maxdiff) {
        this.maxdiff = maxdiff;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isRupture() {
        return rupture;
    }

    public void setRupture(boolean rupture) {
        this.rupture = rupture;
    }

    public boolean isNonreconnue() {
        return nonreconnue;
    }

    public void setNonreconnue(boolean nonreconnue) {
        this.nonreconnue = nonreconnue;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_cloturer() {
        return date_cloturer;
    }

    public void setDate_cloturer(Date date_cloturer) {
        this.date_cloturer = date_cloturer;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<sites> getSite() {
        return site;
    }

    public void setSite(List<sites> site) {
        this.site = site;
    }

    public mission() {

    }
}
