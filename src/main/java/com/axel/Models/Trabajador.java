package com.axel.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import com.axel.Models.Pedido;
import java.util.List;

@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "cedula", nullable = false, unique = true)
    private String cedula;

    @Column(name = "numeroTelefono", nullable = false)
    private String numeroTelefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    // Constructor vacío (requerido por Hibernate)
    public Trabajador() {
    }

    // Constructor parametrizado
    public Trabajador(String nombreCompleto, String cedula, String numeroTelefono, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    // Getters y Setters
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;

    }
}