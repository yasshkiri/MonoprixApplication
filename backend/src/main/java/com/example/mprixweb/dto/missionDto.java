package com.example.mprixweb.dto;

import com.example.mprixweb.entities.sites;

import java.util.Date;
import java.util.List;

public class missionDto {
    private int id ;
    private String nom_miss ;
    private String descrip_miss ;
    private int maxdiff ;
    private String tags ;
    private int usercreation  ;
    private int userupdate ;
    private List<String> users ;
    private List<sites> site ;
    private Date date_miss ;


}
