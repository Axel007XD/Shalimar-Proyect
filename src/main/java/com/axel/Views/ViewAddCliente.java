package com.axel.Views;

import javax.swing.*;
import java.awt.*;

public class ViewAddCliente extends JInternalFrame {
    JLabel jblName,jlbCedula,jlbDireccion,jlbTelefono, jlbOPciones;
    JTextField txtName,txtCedula,txtDireccion,txtTelefono;
    JButton btnAdd;

    public ViewAddCliente(){
        super("Agregar CLiente",true,true,true,true);
        setSize(new Dimension(500,500));
        setLayout(new GridBagLayout());

        jlbOPciones=new JLabel("Agregar CLiente");
        jlbOPciones.setFont(new Font("Tahoma", Font.BOLD, 19));

        jblName=new JLabel("Nombre completo:");
        txtName=new JTextField();

        jlbCedula=new JLabel("Cedula:");
        txtCedula=new JTextField();

        jlbDireccion=new JLabel("Direccion:");
        txtDireccion=new JTextField();

        jlbTelefono=new JLabel("Telefono:");
        txtTelefono=new JTextField();

        btnAdd=new JButton("Agregar");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth =4;
        gbc.gridheight =1;
        gbc.ipadx=0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);


        add(jlbOPciones, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 3;
        gbc.gridx=0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jblName, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbCedula, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbDireccion, gbc);

        gbc.gridx=1;
        gbc.weightx=0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtDireccion, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth =1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 5, 5, 5);
        add(btnAdd, gbc);

        setVisible(true);

    }
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JLabel getJblName() {
        return jblName;
    }

    public void setJblName(JLabel jblName) {
        this.jblName = jblName;
    }

    public JLabel getJlbCedula() {
        return jlbCedula;
    }

    public void setJlbCedula(JLabel jlbCedula) {
        this.jlbCedula = jlbCedula;
    }

    public JLabel getJlbDireccion() {
        return jlbDireccion;
    }

    public void setJlbDireccion(JLabel jlbDireccion) {
        this.jlbDireccion = jlbDireccion;
    }

    public JLabel getJlbOPciones() {
        return jlbOPciones;
    }

    public void setJlbOPciones(JLabel jlbOPciones) {
        this.jlbOPciones = jlbOPciones;
    }

    public JLabel getJlbTelefono() {
        return jlbTelefono;
    }

    public void setJlbTelefono(JLabel jlbTelefono) {
        this.jlbTelefono = jlbTelefono;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public void limpiarCampos(){
        txtName.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }


}
