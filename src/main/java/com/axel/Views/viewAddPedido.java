package com.axel.Views;

import javax.swing.*;
import java.awt.*;

public class viewAddPedido extends JInternalFrame{

    JLabel jlbProductoName,jlbCantidad,jlbOPcion,jlbDescripcion, jlbFechaPedido;
    JTextField jtfProductoName,jtfCantida,jtfFechapedido;
    JTextArea jtADescripcion;
    JButton btnAdd;
    public viewAddPedido() {
        super("Agregar Pedido",true,true,true,true);

        setLayout(new GridBagLayout());

        jlbOPcion= new JLabel("Ingregar pedido:");
        jlbOPcion.setFont(new Font("Tahoma",Font.PLAIN,19));

        jlbProductoName = new JLabel("Nombre del Producto:");
        jtfProductoName = new JTextField();

        jlbCantidad=new JLabel("Cantidad:");
        jtfCantida = new JTextField();

        jlbDescripcion=new JLabel("Descripcion:");
        jtADescripcion = new JTextArea(4,5);
        jtADescripcion.setLineWrap(true);

        jlbFechaPedido=new JLabel("Fecha a realizar Pedido:");
        jtfFechapedido=new JTextField();

        btnAdd = new JButton("Agregar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth =4;
        gbc.gridheight =1;
        gbc.ipadx=0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(jlbOPcion, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 3;
        gbc.gridx=0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbProductoName, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(jtfProductoName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbCantidad, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(jtfCantida, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbDescripcion, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(jtADescripcion, gbc);

        gbc.gridx=0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(jlbFechaPedido, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(jtfFechapedido, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth =1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 5, 5, 5);
        add(btnAdd, gbc);

        setVisible(true);
    }



}
