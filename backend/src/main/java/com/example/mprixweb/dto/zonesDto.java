package com.example.mprixweb.dto;

import java.util.List;

public class zonesDto {

    private Long  id_zone ;

    private String designZ ;

    private List<UserDto> id_user ;

    private List<String> nomuser ;



    public List<String> getNomuser() {
        return nomuser;
    }

    public void setNomuser(List<String> nomuser) {
        this.nomuser = nomuser;
    }

    public zonesDto(Long id_zone, String designZ, List<UserDto> id_user , List<String> nomuser ) {
        this.id_zone = id_zone;
        this.designZ = designZ;
        this.id_user = id_user;
        this.nomuser=nomuser ;
    }

    public zonesDto() {}

    public Long getId_zone() {
        return id_zone;
    }

    public void setId_zone(Long id_zone) {
        this.id_zone = id_zone;
    }

    public String getDesignZ() {
        return designZ;
    }

    public void setDesignZ(String designZ) {
        this.designZ = designZ;
    }

    public List<UserDto> getId_user() {
        return id_user;
    }

    public void setId_user(List<UserDto> id_user) {
        this.id_user = id_user;
    }
}
