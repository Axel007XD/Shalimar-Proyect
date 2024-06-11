package com.axel.Views;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class viewAddAgenda extends JInternalFrame{

    JLabel jlbOperacion,nameClient, NameWorker,Description,fechaEntrega,telefono,jlbAmount;
    JRadioButton fullPayment, halfPayment;
    JRadioButton shirt,tshirts, thermos;
    JTextField txtClient,txtWorker,txtTelefono,txtFechaEntrega,txtAmount;
    JTextArea txtDescription;
    JButton btnEnviar;
    LocalDate fechaEncargo;


    public viewAddAgenda(){
        super("Agregar a Agenda",true,true,true,true);
        setSize(new Dimension(500,500));
        setLayout(new GridBagLayout());

        fechaEncargo=LocalDate.now();


        jlbOperacion = new JLabel("Crear Encargo ");
        jlbOperacion.setFont(new Font("Tahoma", Font.BOLD, 20));

        nameClient = new JLabel("Nombre del Cliente:");
        txtClient = new JTextField(20);

        NameWorker = new JLabel("Nombre del Trabajador:");
        txtWorker = new JTextField(20);

        Description = new JLabel("Descripción:");
        txtDescription = new JTextArea(5, 20);
        txtDescription.setLineWrap(true);

        fechaEntrega = new JLabel("Fecha de Entrega:");
        txtFechaEntrega = new JTextField(10);

        telefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField(10);

        jlbAmount= new JLabel("Cantidad:");
        txtAmount = new JTextField(5);

        fullPayment = new JRadioButton("Pago Completo");
        halfPayment = new JRadioButton("Pago 50%");

        tshirts= new JRadioButton("Camisetas");
        shirt= new JRadioButton("Camisas");
        thermos= new JRadioButton("Termos");

        btnEnviar = new JButton("Enviar");


        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(fullPayment);
        paymentGroup.add(halfPayment);

        ButtonGroup productos = new ButtonGroup();
        productos.add(tshirts);
        productos.add(shirt);
        productos.add(thermos);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth =4;
        gbc.gridheight =1;
        gbc.ipadx=0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);


        add(jlbOperacion, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 3;
        gbc.gridx=0;
        gbc.gridy++;
        add(nameClient, gbc);

        gbc.gridx = 1;
        add(txtClient, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(NameWorker, gbc);

        gbc.gridx = 1;
        add(txtWorker, gbc);

        gbc.gridx=0;
        gbc.gridy++;
        add(shirt,gbc);

        gbc.gridx =1;
        add(thermos, gbc);

        gbc.gridx=2;
        add(tshirts, gbc);


        gbc.gridx = 0;
        gbc.gridy++;
        add(Description, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 4;
        add(txtDescription, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(jlbAmount, gbc);

        gbc.gridx=1;
        gbc.weightx=0;
        gbc.gridwidth = -4;
        add(txtAmount, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = -4;
        gbc.gridy++;
        add(fechaEntrega, gbc);

        gbc.gridx = 1;
        add(txtFechaEntrega, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(telefono, gbc);

        gbc.gridx = 1;
        add(txtTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(fullPayment, gbc);

        gbc.gridx = 1;
        add(halfPayment, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth =1;
        gbc.insets = new Insets(20, 5, 5, 5);
        add(btnEnviar, gbc);

        setVisible(true);


    }
}
