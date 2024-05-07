package com.axel.Models;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private String nombreProducto;
    private int cantidad;
    private String Descripcion;
    private LocalDate fechaARealizarPedido;
    private LocalDate fechaRegistroDelPedido;

    public Pedido() {
    }

    public Pedido(int cantidad, String descripcion, LocalDate fechaARealizarPedido, LocalDate fechaRegistroDelPedido, int id, String nombreProducto) {
        this.cantidad = cantidad;
        Descripcion = descripcion;
        this.fechaARealizarPedido = fechaARealizarPedido;
        this.fechaRegistroDelPedido = fechaRegistroDelPedido;
        this.id = id;
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDate getFechaARealizarPedido() {
        return fechaARealizarPedido;
    }

    public void setFechaARealizarPedido(LocalDate fechaARealizarPedido) {
        this.fechaARealizarPedido = fechaARealizarPedido;
    }

    public LocalDate getFechaRegistroDelPedido() {
        return fechaRegistroDelPedido;
    }

    public void setFechaRegistroDelPedido(LocalDate fechaRegistroDelPedido) {
        this.fechaRegistroDelPedido = fechaRegistroDelPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
