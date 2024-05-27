package com.axel.Views;

import com.axel.Component.MenuPrincipal;
import com.axel.Component.desktopMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ventanaMenuPrincipal extends JFrame implements MouseListener, ActionListener {
    ViewWorker viewWorker;
    panelOpciones panelOpciones;
    desktopMenu desktopMenu;


    public ventanaMenuPrincipal() {
        setTitle("Shalimar Company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setSize(750,600);
        setLayout(new BorderLayout());

        //agregando panel de opciones
        panelOpciones = new panelOpciones();
        add(panelOpciones, BorderLayout.WEST);



        //agregando JDestosktopPanel
        desktopMenu = new desktopMenu();
        add(desktopMenu);

        desktopMenu.setVisible(true);

        //Accciones

        panelOpciones.imagenTrabajador.addMouseListener(this);
        panelOpciones.opcion2.addMouseListener(this);

        setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if(viewWorker == null){
//
//
//        }
        if (e.getSource() == panelOpciones.imagenTrabajador|| e.getSource() == panelOpciones.opcion2) {
            viewWorker= new ViewWorker();
            desktopMenu.add(viewWorker);
            viewWorker.setVisible(true);
            System.out.println("hola desde mousclick");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
