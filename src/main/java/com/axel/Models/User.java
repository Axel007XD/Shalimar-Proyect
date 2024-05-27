package com.axel.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id")
    private int id;

    @Column(name = "username")
    private String usuario;

    @Column (name = "password")
    private String password;

    public User() {

    }

    public User(String usuario, String password ) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassworld() {
        return password;
    }

    public void setPassworld(String passworld) {
        this.password = passworld;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", passworld='" + password + '\'' +
                '}';
    }
}



