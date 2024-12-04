package com.axel.Component;

import javax.swing.*;

public class MenuPrincipal extends JMenuBar {


    JMenu menuAcciones;
    JMenuItem menuAddMetodoPersonalizacion;
    JMenuItem menuAddTrabajador;
    JMenuItem menuAddPedido;
    JMenuItem menuAddCliente;
    JMenuItem menuAddProducto;


    public MenuPrincipal(){
        //setLayout(new BorderLayout());

        menuAcciones = new JMenu("Acciones");
        menuAddMetodoPersonalizacion = new JMenuItem("Agregar a MetodoPersonalizacion");
        menuAddTrabajador = new JMenuItem("Agregar a Trabajador");
        menuAddPedido = new JMenuItem("Agregar a Pedido");
        menuAddCliente = new JMenuItem("Agregar a Cliente");
        menuAddProducto = new JMenuItem("Agregar Producto");

        menuAcciones.add(menuAddMetodoPersonalizacion);
        menuAcciones.add(menuAddTrabajador);
        menuAcciones.add(menuAddPedido);
        menuAcciones.add(menuAddCliente);
        menuAcciones.add(menuAddProducto);
        add(menuAcciones);

    }

    public JMenuItem getMenuAddProducto() {
        return menuAddProducto;
    }

    public void setMenuAddProducto(JMenuItem menuAddProducto) {
        this.menuAddProducto = menuAddProducto;
    }

    public JMenu getMenuAcciones() {
        return menuAcciones;
    }

    public void setMenuAcciones(JMenu menuAcciones) {
        this.menuAcciones = menuAcciones;
    }

    public JMenuItem getMenuAddCliente() {
        return menuAddCliente;
    }

    public void setMenuAddCliente(JMenuItem menuAddCliente) {
        this.menuAddCliente = menuAddCliente;
    }

    public JMenuItem getMenuAddMetodoPersonalizacion() {
        return menuAddMetodoPersonalizacion;
    }

    public void setMenuAddMetodoPersonalizacion(JMenuItem menuAddMetodoPersonalizacion) {
        this.menuAddMetodoPersonalizacion = menuAddMetodoPersonalizacion;
    }

    public JMenuItem getMenuAddPedido() {
        return menuAddPedido;
    }

    public void setMenuAddPedido(JMenuItem menuAddPedido) {
        this.menuAddPedido = menuAddPedido;
    }

    public JMenuItem getMenuAddTrabajador() {
        return menuAddTrabajador;
    }

    public void setMenuAddTrabajador(JMenuItem menuAddTrabajador) {
        this.menuAddTrabajador = menuAddTrabajador;
    }
}
