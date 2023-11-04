package com.example.mprixweb.dto;

public class loginDto {
        private Long id;
        private String email;
        private String name;
        private String token;

        public loginDto(Long id, String email, String name) {
            this.id = id;
            this.email = email;
            this.name = name;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

}
