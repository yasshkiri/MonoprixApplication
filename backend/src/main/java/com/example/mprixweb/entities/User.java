package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	@ManyToOne
	@JoinColumn(name = "id_role")
	private roles id_role;
	private  String nomuser ;
	private String password  ;
	private  String email ;
    private boolean actif ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datecreation", nullable = false, updatable = false ,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datecreation ;

	private int usercreation  ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_update", nullable = false ,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date_update ;
	private int userUpdate ;
	@OneToMany(mappedBy="userUpdate")
		private List<EnseigneConcurrent> enseigne ;
	@ManyToMany(mappedBy ="users" )
	@JsonIgnoreProperties("users")
	private List<zones> zone ;

	public User(Long id, roles id_role, String nomuser, String password, String email, boolean actif, Date datecreation, int usercreation, Date date_update, int userUpdate, List<EnseigneConcurrent> enseigne, List<zones> zone) {
		this.id = id;
		this.id_role = id_role;
		this.nomuser = nomuser;
		this.password = password;
		this.email = email;
		this.actif = actif;
		this.datecreation = datecreation;
		this.usercreation = usercreation;
		this.date_update = date_update;
		this.userUpdate = userUpdate;
		this.enseigne = enseigne;
		this.zone = zone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public roles getId_role() {
		return id_role;
	}

	public void setId_role(roles id_role) {
		this.id_role = id_role;
	}

	public List<EnseigneConcurrent> getEnseigne() {
		return enseigne;
	}

	public void setEnseigne(List<EnseigneConcurrent> enseigne) {
		this.enseigne = enseigne;
	}

	public  String getNomuser() {
		return nomuser;
	}

	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
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

	public Date getDate_update() {
		return date_update;
	}

	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}

	public int getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(int userUpdate) {
		this.userUpdate = userUpdate;
	}

	public List<zones> getZone() {
		return zone;
	}

	public void setZone(List<zones> zone) {
		this.zone = zone;
	}

	public User() {
		// Default constructor required by Hibernate
	}
}
