package com.axel.Models;

import jakarta.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPersonalizacion metodo;

    private int cantidad;

    private double precio;

    private String descripcion;

    public DetallePedido() {
    }

    public DetallePedido(Pedido pedido, Producto producto, MetodoPersonalizacion metodo, int cantidad, double precio, String descripcion) {
        this.pedido = pedido;
        this.producto = producto;
        this.metodo = metodo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public MetodoPersonalizacion getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPersonalizacion metodo) {
        this.metodo = metodo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", producto=" + producto +
                ", metodo=" + metodo +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
