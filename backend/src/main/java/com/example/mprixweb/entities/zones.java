package com.example.mprixweb.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

@Entity
@Table(name="zones")
public class zones implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;

	private String designZ ;
	@ManyToMany
	@JoinTable (
			name="user_zone" ,
			joinColumns = @JoinColumn(name="id_zones") ,
			inverseJoinColumns = @JoinColumn(name ="id_user")
	)
	@JsonIgnoreProperties("zone")
	private List<User> users;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateCreation", nullable = false, updatable = false ,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datecreation ;
	@ManyToOne
	@JoinColumn(name="usercreation")
	private User usercreation  ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false,
			columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateUpdate ;

	@ManyToOne
	@JoinColumn(name="userUpdate")
	private User userUpdate  ;

	@OneToMany(mappedBy="zone")
	@JsonIgnoreProperties(value="zone",allowSetters = true)
	private List<sites> site ;



	public zones(Long id, String designZ, List<User> users, Date datecreation, User usercreation, Date dateUpdate, User userUpdate, List<sites> sitesList) {
		this.id = id;
		this.designZ = designZ;
		this.users = users;
		this.datecreation = datecreation;
		this.usercreation = usercreation;
		this.dateUpdate = dateUpdate;
		this.userUpdate = userUpdate;
		this.site = sitesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignZ() {
		return designZ;
	}

	public void setDesignZ(String designZ) {
		this.designZ = designZ;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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


	public zones() {}
}
