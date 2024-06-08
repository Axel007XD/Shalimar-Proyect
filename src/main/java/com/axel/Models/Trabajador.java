package com.axel.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "numeroTelefono")
    private String numeroTelefono;

    @Column(name = "direccion")
    private String direccion;

    public Trabajador () {

    }

    public Trabajador(String cedula, String direccion, String nombreCompleto, String numeroTelefono) {
        this.cedula = cedula;
        this.direccion = direccion;

        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "cedula='" + cedula + '\'' +
                ", id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}