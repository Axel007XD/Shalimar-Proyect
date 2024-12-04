package com.axel.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreCompleto;


    private String numeroTelefono;

    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor sin lista de pedidos
    public Cliente(String nombreCompleto, String numeroTelefono, String direccion) {
        this.nombreCompleto = nombreCompleto;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
