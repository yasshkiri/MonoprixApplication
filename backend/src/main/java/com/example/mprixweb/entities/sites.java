package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

@Entity
@Table(name="sites")

public class sites implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nomsite ;
	@ManyToOne
	@JsonIgnoreProperties("site")
	@JoinColumn(name="idZone" )
	private zones zone;
	@ManyToOne
	@JsonIgnoreProperties(value = "site", allowSetters = true)
	@JoinColumn(name="idEnseigne")
	private EnseigneConcurrent enseigne ;

	@ManyToMany(mappedBy="site")
	@JsonIgnoreProperties("site")
	private List<mission> mission ;
	private String reference_erp_site ;
	private String adresse_site ;  
	private int codepostal_site ; 
	private String email_site ; 
	private int tel ; 
	private int numerofax ; 
	private String manager_site ; 
	private double Longitude_site ; 
	private double Latitude_site ; 
	private String modepaimentSite ;
	private String conditionPaimentSite ;
	private String canalDistribSite ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateCreation", nullable = false, updatable = false ,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datecreation ;
	//@ManyToOne
	//@JoinColumn(name="usercreation")
	private int usercreation  ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateUpdate", nullable = false,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateUpdate ;
	//@ManyToOne
	//@JoinColumn(name="userUpdate")
	private int userUpdate ;

	public sites(Long id, String nomsite, zones zone, EnseigneConcurrent enseigne, List<mission> mission, String reference_erp_site, String adresse_site, int codepostal_site, String email_site, int tel, int numerofax, String manager_site, double longitude_site, double latitude_site, String modepaimentSite, String conditionPaimentSite, String canalDistribSite, Date datecreation, int usercreation, Date dateUpdate, int userUpdate) {
		this.id = id;
		this.nomsite = nomsite;
		this.zone = zone;
		this.enseigne = enseigne;
		this.mission = mission;
		this.reference_erp_site = reference_erp_site;
		this.adresse_site = adresse_site;
		this.codepostal_site = codepostal_site;
		this.email_site = email_site;
		this.tel = tel;
		this.numerofax = numerofax;
		this.manager_site = manager_site;
		Longitude_site = longitude_site;
		Latitude_site = latitude_site;
		this.modepaimentSite = modepaimentSite;
		this.conditionPaimentSite = conditionPaimentSite;
		this.canalDistribSite = canalDistribSite;
		this.datecreation = datecreation;
		this.usercreation = usercreation;
		this.dateUpdate = dateUpdate;
		this.userUpdate = userUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomsite() {
		return nomsite;
	}

	public void setNomsite(String nomsite) {
		this.nomsite = nomsite;
	}

	public zones getZone() {
		return zone;
	}

	public void setZone(zones zone) {
		this.zone = zone;
	}

	public EnseigneConcurrent getEnseigne() {
		return enseigne;
	}

	public void setEnseigne(EnseigneConcurrent enseigne) {
		this.enseigne = enseigne;
	}

	public String getReference_erp_site() {
		return reference_erp_site;
	}

	public void setReference_erp_site(String reference_erp_site) {
		this.reference_erp_site = reference_erp_site;
	}

	public String getAdresse_site() {
		return adresse_site;
	}

	public void setAdresse_site(String adresse_site) {
		this.adresse_site = adresse_site;
	}

	public int getCodepostal_site() {
		return codepostal_site;
	}

	public void setCodepostal_site(int codepostal_site) {
		this.codepostal_site = codepostal_site;
	}

	public String getEmail_site() {
		return email_site;
	}

	public void setEmail_site(String email_site) {
		this.email_site = email_site;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getNumerofax() {
		return numerofax;
	}

	public void setNumerofax(int numerofax) {
		this.numerofax = numerofax;
	}

	public String getManager_site() {
		return manager_site;
	}

	public void setManager_site(String manager_site) {
		this.manager_site = manager_site;
	}

	public double getLongitude_site() {
		return Longitude_site;
	}

	public void setLongitude_site(double longitude_site) {
		Longitude_site = longitude_site;
	}

	public double getLatitude_site() {
		return Latitude_site;
	}

	public void setLatitude_site(double latitude_site) {
		Latitude_site = latitude_site;
	}

	public String getModepaimentSite() {
		return modepaimentSite;
	}

	public void setModepaimentSite(String modepaimentSite) {
		this.modepaimentSite = modepaimentSite;
	}

	public String getConditionPaimentSite() {
		return conditionPaimentSite;
	}

	public void setConditionPaimentSite(String conditionPaimentSite) {
		this.conditionPaimentSite = conditionPaimentSite;
	}

	public String getCanalDistribSite() {
		return canalDistribSite;
	}

	public void setCanalDistribSite(String canalDistribSite) {
		this.canalDistribSite = canalDistribSite;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public int getUsercreation() {
		return usercreation;
	}

	public void setUsercreation(int usercreation) {
		this.usercreation = usercreation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public int getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(int userUpdate) {
		this.userUpdate = userUpdate;
	}

	public List<com.example.mprixweb.entities.mission> getMission() {
		return mission;
	}

	public void setMission(List<com.example.mprixweb.entities.mission> mission) {
		this.mission = mission;
	}

	public sites () {
	}
}
