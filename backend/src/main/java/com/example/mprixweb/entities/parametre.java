package com.example.mprixweb.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name="parametre")
public class parametre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private boolean pushnotification ; 
	private boolean soundnotification ;

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


	public parametre(Long id, boolean pushnotification, boolean soundnotification, Date datecreation, User usercreation, Date dateUpdate, User userUpdate) {
		this.id = id;
		this.pushnotification = pushnotification;
		this.soundnotification = soundnotification;
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

	public boolean isPushnotification() {
		return pushnotification;
	}

	public void setPushnotification(boolean pushnotification) {
		this.pushnotification = pushnotification;
	}

	public boolean isSoundnotification() {
		return soundnotification;
	}

	public void setSoundnotification(boolean soundnotification) {
		this.soundnotification = soundnotification;
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

	public parametre() {
	}
}
