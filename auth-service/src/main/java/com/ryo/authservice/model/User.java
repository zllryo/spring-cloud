package com.ryo.authservice.model;

public class User {
    private Long id;

    public User(Long id) {
        this.id = id;
    }
    public User() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
