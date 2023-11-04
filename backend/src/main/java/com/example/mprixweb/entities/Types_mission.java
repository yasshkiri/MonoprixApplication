package com.example.mprixweb.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name="types_mission")
public class Types_mission implements Serializable {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id  ;
    private String  nom_type ; 
    private String desc_type ;

    public Types_mission(Long id, String nom_type, String desc_type) {
        this.id = id;
        this.nom_type = nom_type;
        this.desc_type = desc_type;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public String getDesc_type() {
        return desc_type;
    }

    public void setDesc_type(String desc_type) {
        this.desc_type = desc_type;
    }

    public Types_mission() {
    }


}
