package com.axel.Models;

import java.time.LocalDate;

public class Inventario {
    private int idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private String descripcion;
    private String cantidad;
    private LocalDate fechaInventario;

    public Inventario() {
    }

    public Inventario(String cantidad, String descripcion, LocalDate fechaInventario, int idProducto, String nombreProducto, String tipoProducto) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechaInventario = fechaInventario;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(LocalDate fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
