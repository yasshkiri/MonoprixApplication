package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Table(name="roles")
public class roles implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String design_r ;
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
	private User userUpdate ;


	public roles(Long id, String design_r, Date datecreation, User usercreation, Date dateUpdate, User userUpdate  ) {
		this.id = id;
		this.design_r = design_r;
		this.datecreation = datecreation;
		this.usercreation = usercreation;
		this.dateUpdate = dateUpdate;
		this.userUpdate = userUpdate;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}




	public String getDesign_r() {
		return design_r;
	}

	public void setDesign_r(String design_r) {
		this.design_r = design_r;
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

	public roles() {
		// Default constructor required by Hibernate
	}

}
