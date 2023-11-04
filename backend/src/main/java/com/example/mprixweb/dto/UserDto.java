package com.example.mprixweb.dto;


import java.util.Date;
import java.util.List;

public class UserDto {



        private static Long id;
        private Long roleId;
        private String nomuser;

        private String password ;
        private String email;
        private boolean actif;
        private Date datecreation;
        private int usercreation;
        private Date dateUpdate;
        private int userUpdate;



        public UserDto(Long id, String nomuser , String email) {
            this.id = id;
            this.nomuser = nomuser;
            this.email = email;
        }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public String getNomuser() {
            return nomuser;
        }

        public void setNomuser(String nomuser) {
            this.nomuser = nomuser;
        }

        public String getEmail() {
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


    }



