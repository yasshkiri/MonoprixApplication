package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;


@Entity
@Table(name="articles")
public class Articles implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   private String code_art ;
   private int reference_art ;
   private String design_art ; 
   private double prix_art ; 
   private int gamme_art  ; 
   private String marque_art ; 
   private Long id_structmarch ;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dateCreation", nullable = false, updatable = false ,
           columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
   private Date datecreation ;


   private int usercreation  ;
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dateUpdate", nullable = false,
           columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
   private Date dateUpdate ;

   private int userUpdate ;

   public Articles() {
   }


   public Articles(Long id, String code_art, int reference_art, String design_art, double prix_art, int gamme_art, String marque_art, Long id_structmarch, Date datecreation, int usercreation, Date dateUpdate, int userUpdate) {
      this.id = id;
      this.code_art = code_art;
      this.reference_art = reference_art;
      this.design_art = design_art;
      this.prix_art = prix_art;
      this.gamme_art = gamme_art;
      this.marque_art = marque_art;
      this.id_structmarch = id_structmarch;
      this.datecreation = datecreation;
      this.usercreation = usercreation;
      this.dateUpdate = dateUpdate;
      this.userUpdate = userUpdate;
   }

   public int getReference_art() {
      return reference_art;
   }

   public void setReference_art(int reference_art) {
      this.reference_art = reference_art;
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

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCode_art() {
      return code_art;
   }

   public void setCode_art(String code_art) {
      this.code_art = code_art;
   }

   public String getDesign_art() {
      return design_art;
   }

   public void setDesign_art(String design_art) {
      this.design_art = design_art;
   }

   public double getPrix_art() {
      return prix_art;
   }

   public void setPrix_art(double prix_art) {
      this.prix_art = prix_art;
   }

   public int getGamme_art() {
      return gamme_art;
   }

   public void setGamme_art(int gamme_art) {
      this.gamme_art = gamme_art;
   }

   public String getMarque_art() {
      return marque_art;
   }

   public void setMarque_art(String marque_art) {
      this.marque_art = marque_art;
   }

   public Long getId_structmarch() {
      return id_structmarch;
   }

   public void setId_structmarch(Long id_structmarch) {
      this.id_structmarch = id_structmarch;
   }


}
