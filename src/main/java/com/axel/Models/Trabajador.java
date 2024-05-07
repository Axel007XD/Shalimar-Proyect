package com.axel.Models;

public class Trabajador {
    private int id;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;

    public Trabajador() {
    }

    public Trabajador(String cedula, String direccion, String nombre, int id, String telefono) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
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
        direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
