package com.axel.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HistorialPedido {
    private int id;
    private LocalDateTime fechaDelPedido;
    private int idTrabajador;
    private int idPedido;

    public HistorialPedido() {
    }

    public HistorialPedido(LocalDateTime fechaDelPedido, int id, int idPedido, int idTrabajador) {
        this.fechaDelPedido = fechaDelPedido;
        this.id = id;
        this.idPedido = idPedido;
        this.idTrabajador = idTrabajador;
    }

    public LocalDateTime getFechaDelPedido() {
        return fechaDelPedido;
    }

    public void setFechaDelPedido(LocalDateTime fechaDelPedido) {
        this.fechaDelPedido = fechaDelPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
}
