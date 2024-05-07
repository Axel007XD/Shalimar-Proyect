package com.axel.Views;

import javax.swing.*;
import java.awt.*;

public class viewAddWorker extends JInternalFrame {
    JLabel jblName,jlbCedula,jlbDireccion,jlbTelefono, jlbOPciones;
    JTextField txtName,txtCedula,txtDireccion,txtTelefono;
    JButton btnAdd;

    public viewAddWorker(){
        super("Agregar Trabajador",true,true,true,true);
        setLayout(new GridBagLayout());

        jlbOPciones=new JLabel("Agregar Trabajador");
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



}
