package com.axel.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "MetodoPersonalizacion")
public class MetodoPersonalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    public MetodoPersonalizacion() {
    }

    public MetodoPersonalizacion(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "MetodoPersonalizacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
