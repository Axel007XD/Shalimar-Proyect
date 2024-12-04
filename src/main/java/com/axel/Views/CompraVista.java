package com.axel.Views;

import javax.swing.*;
import java.awt.*;

public class CompraVista extends JInternalFrame {
    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTextArea txtDescripcion;
    private JTextField txtCostoTotal;
    private JButton btnCalcular;

    public CompraVista() {
        setTitle("Compra de Productos");
        setSize(400, 300);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblProducto = new JLabel("Producto:");
        comboProductos = new JComboBox<>(new String[]{"Gorra", "Camisa", "Termo"});

        JLabel lblCantidad = new JLabel("Cantidad:");
        txtCantidad = new JTextField();

        JLabel lblDescripcion = new JLabel("Descripción:");
        txtDescripcion = new JTextArea(3, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);

        JLabel lblCostoTotal = new JLabel("Costo Total:");
        txtCostoTotal = new JTextField();
        txtCostoTotal.setEditable(false);

        btnCalcular = new JButton("Calcular");

        add(lblProducto);
        add(comboProductos);
        add(lblCantidad);
        add(txtCantidad);
        add(lblDescripcion);
        add(scrollDescripcion);
        add(lblCostoTotal);
        add(txtCostoTotal);
        add(new JLabel());
        add(btnCalcular);


    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public void setBtnCalcular(JButton btnCalcular) {
        this.btnCalcular = btnCalcular;
    }

    public JComboBox<String> getComboProductos() {
        return comboProductos;
    }

    public void setComboProductos(JComboBox<String> comboProductos) {
        this.comboProductos = comboProductos;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public JTextField getTxtCostoTotal() {
        return txtCostoTotal;
    }

    public void setTxtCostoTotal(JTextField txtCostoTotal) {
        this.txtCostoTotal = txtCostoTotal;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }
}
