package com.axel.Views;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class panelOpciones extends JPanel {
    JLabel lblOpciones;
    JPanel panelOPcion1;
    JPanel opcion2;
    JPanel opcion3;
    JPanel opcion4;
    JPanel opcion5;
    JLabel imagenCalendario;
    JLabel imagenTrabajador;
    JLabel imagenTrabajador3;
    JLabel imagenTrabajador4;
    JLabel imagenTrabajador5;


    public panelOpciones() {

        setSize(new Dimension(200,500));
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        lblOpciones = new JLabel("SHALIMAR");
        lblOpciones.setBackground(Color.BLACK);
        lblOpciones.setForeground(Color.white);
        lblOpciones.setFont(new Font("Poppins", Font.BOLD,17));
        lblOpciones.setPreferredSize(new Dimension(130,40));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor=GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy =0 ;
        gbc.ipady=1;
        gbc.gridheight=1;
        gbc.weighty=0;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,10,0,10);


        add(lblOpciones,gbc);

        //panel Agenda
        panelOPcion1 = new JPanel();

        panelOPcion1.setBackground(new Color(59,207,255));
        panelOPcion1.setPreferredSize(new Dimension(130,35));

        GridBagConstraints gbc_panelOPcion1 = new GridBagConstraints();

        gbc_panelOPcion1.anchor=GridBagConstraints.NORTH;
        gbc_panelOPcion1.gridx = 0;
        gbc_panelOPcion1.gridy =1 ;
        gbc_panelOPcion1.gridwidth=0;
        gbc_panelOPcion1.weighty=0;
        gbc_panelOPcion1.fill = GridBagConstraints.BOTH;
        gbc_panelOPcion1.insets = new Insets(0,0,10,0);

        add(panelOPcion1, gbc_panelOPcion1);

        JLabel labelOPcion1= new JLabel("Agenda");
        labelOPcion1.setFont(new Font("Poppins", Font.BOLD,14));
        labelOPcion1.setForeground(Color.WHITE);

        URL urlIconCalendario= panelOpciones.class.getResource("/Calendario.png");
        ImageIcon iconCalendario = new ImageIcon(urlIconCalendario);


        panelOPcion1.setLayout(new BorderLayout());

        imagenCalendario=new JLabel(iconCalendario);

        imagenCalendario.setPreferredSize(new Dimension(35,25));

        panelOPcion1.add(imagenCalendario,BorderLayout.WEST);
        panelOPcion1.add(labelOPcion1,BorderLayout.CENTER);

        //Segundo panel

        opcion2 = new JPanel(new BorderLayout());
        opcion2.setBackground(new Color(59,207,255));
        opcion2.setPreferredSize(new Dimension(130,35));

        GridBagConstraints gbc_panelOpcion2 = new GridBagConstraints();

        gbc_panelOpcion2.anchor=GridBagConstraints.NORTH;
        gbc_panelOpcion2.gridx = 0;
        gbc_panelOpcion2.gridy =2 ;
        gbc_panelOpcion2.gridwidth=0;
        gbc_panelOpcion2.weighty=0;
        gbc_panelOpcion2.fill = GridBagConstraints.BOTH;
        gbc_panelOpcion2.insets = new Insets(0,0,10,0);
        add(opcion2, gbc_panelOpcion2);

        JLabel labelOPcion2= new JLabel("Trabajador");
        labelOPcion2.setFont(new Font("Poppins", Font.BOLD,14));
        labelOPcion2.setForeground(Color.WHITE);

        URL urlTrabajador= panelOpciones.class.getResource("/Trabajadores.png");
        ImageIcon iconTrabajador = new ImageIcon(urlTrabajador);

        imagenTrabajador =new JLabel(iconTrabajador);
        imagenTrabajador.setPreferredSize(new Dimension(35,25));
        opcion2.add(imagenTrabajador,BorderLayout.WEST);
        opcion2.add(labelOPcion2,BorderLayout.CENTER);

        //Pedidos panel.

        opcion3 = new JPanel(new BorderLayout());
        opcion3.setBackground(new Color(59,207,255));
        opcion3.setPreferredSize(new Dimension(130,35));

        GridBagConstraints gbc_panelOpcion3 = new GridBagConstraints();

        gbc_panelOpcion3.anchor=GridBagConstraints.NORTH;
        gbc_panelOpcion3.gridx = 0;
        gbc_panelOpcion3.gridy =3 ;
        gbc_panelOpcion3.gridwidth=0;
        gbc_panelOpcion3.weighty=0;
        gbc_panelOpcion3.fill = GridBagConstraints.BOTH;
        gbc_panelOpcion3.insets = new Insets(0,0,10,0);
        add(opcion3, gbc_panelOpcion3);

        JLabel labelOPcion3= new JLabel("Pedidos");
        labelOPcion3.setFont(new Font("Poppins", Font.BOLD,14));
        labelOPcion3.setForeground(Color.WHITE);

        URL urlTrabajador3= panelOpciones.class.getResource("/Pedidos.png");
        ImageIcon iconTrabajador3 = new ImageIcon(urlTrabajador3);

        imagenTrabajador3 =new JLabel(iconTrabajador3);
        imagenTrabajador3.setPreferredSize(new Dimension(35,25));
        opcion3.add(imagenTrabajador3,BorderLayout.WEST);
        opcion3.add(labelOPcion3,BorderLayout.CENTER);

        //Inventario

        opcion4 = new JPanel(new BorderLayout());
        opcion4.setBackground(new Color(59,207,255));
        opcion4.setPreferredSize(new Dimension(130,35));

        GridBagConstraints gbc_panelOpcion4 = new GridBagConstraints();

        gbc_panelOpcion4.anchor=GridBagConstraints.NORTH;
        gbc_panelOpcion4.gridx = 0;
        gbc_panelOpcion4.gridy =4 ;
        gbc_panelOpcion4.gridwidth=0;
        gbc_panelOpcion4.weighty=0;
        gbc_panelOpcion4.fill = GridBagConstraints.BOTH;
        gbc_panelOpcion4.insets = new Insets(0,0,10,0);
        add(opcion4, gbc_panelOpcion4);

        JLabel labelOPcion4= new JLabel("Inventario");
        labelOPcion4.setFont(new Font("Poppins", Font.BOLD,14));
        labelOPcion4.setForeground(Color.WHITE);

        URL urlTrabajador4= panelOpciones.class.getResource("/Almacen.png");
        ImageIcon iconTrabajador4 = new ImageIcon(urlTrabajador4);

        imagenTrabajador4 =new JLabel(iconTrabajador4);
        imagenTrabajador4.setPreferredSize(new Dimension(35,25));
        opcion4.add(imagenTrabajador4,BorderLayout.WEST);
        opcion4.add(labelOPcion4,BorderLayout.CENTER);

        //Historial pedidos

        opcion5 = new JPanel(new BorderLayout());
        opcion5.setBackground(new Color(59,207,255));
        opcion5.setPreferredSize(new Dimension(130,35));

        GridBagConstraints gbc_panelOpcion5 = new GridBagConstraints();

        gbc_panelOpcion5.anchor=GridBagConstraints.NORTH;
        gbc_panelOpcion5.gridx = 0;
        gbc_panelOpcion5.gridy =5 ;
        gbc_panelOpcion5.gridwidth=0;
        gbc_panelOpcion5.weighty=0;
        gbc_panelOpcion5.fill = GridBagConstraints.BOTH;
        gbc_panelOpcion5.insets = new Insets(0,0,10,0);
        add(opcion5, gbc_panelOpcion5);

        JLabel labelOPcion5= new JLabel("Historial");
        labelOPcion5.setFont(new Font("Poppins", Font.BOLD,14));
        labelOPcion5.setForeground(Color.WHITE);

        URL urlTrabajador5= panelOpciones.class.getResource("/HistorialPedidos.png");
        ImageIcon iconTrabajador5 = new ImageIcon(urlTrabajador5);

        imagenTrabajador5 =new JLabel(iconTrabajador5);
        imagenTrabajador5.setPreferredSize(new Dimension(35,25));
        opcion5.add(imagenTrabajador5,BorderLayout.WEST);
        opcion5.add(labelOPcion5,BorderLayout.CENTER);



    }

    public JLabel getImagenCalendario() {
        return imagenCalendario;
    }

    public void setImagenCalendario(JLabel imagenCalendario) {
        this.imagenCalendario = imagenCalendario;
    }

    public JLabel getImagenTrabajador3() {
        return imagenTrabajador3;
    }

    public void setImagenTrabajador3(JLabel imagenTrabajador3) {
        this.imagenTrabajador3 = imagenTrabajador3;
    }

    public JLabel getImagenTrabajador4() {
        return imagenTrabajador4;
    }

    public void setImagenTrabajador4(JLabel imagenTrabajador4) {
        this.imagenTrabajador4 = imagenTrabajador4;
    }

    public JLabel getImagenTrabajador5() {
        return imagenTrabajador5;
    }

    public void setImagenTrabajador5(JLabel imagenTrabajador5) {
        this.imagenTrabajador5 = imagenTrabajador5;
    }

    public JLabel getImagenTrabajador() {
        return imagenTrabajador;
    }

    public void setImagenTrabajador(JLabel imagenTrabajador) {
        this.imagenTrabajador = imagenTrabajador;
    }

    public JLabel getLblOpciones() {
        return lblOpciones;
    }

    public void setLblOpciones(JLabel lblOpciones) {
        this.lblOpciones = lblOpciones;
    }

    public JPanel getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(JPanel opcion2) {
        this.opcion2 = opcion2;
    }

    public JPanel getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(JPanel opcion3) {
        this.opcion3 = opcion3;
    }

    public JPanel getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(JPanel opcion4) {
        this.opcion4 = opcion4;
    }

    public JPanel getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(JPanel opcion5) {
        this.opcion5 = opcion5;
    }

    public JPanel getPanelOPcion1() {
        return panelOPcion1;
    }

    public void setPanelOPcion1(JPanel panelOPcion1) {
        this.panelOPcion1 = panelOPcion1;
    }
}
