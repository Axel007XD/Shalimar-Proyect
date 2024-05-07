package com.axel.Views;

import com.axel.Component.MenuPrincipal;
import com.axel.Component.desktopMenu;

import javax.swing.*;
import java.awt.*;

public class ventanaMenuPrincipal extends JFrame {

    public ventanaMenuPrincipal() {
        setTitle("Shalimar Company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setSize(750,600);
        setLayout(new BorderLayout());



        //agregando panel de opciones
        panelOpciones panelOpciones = new panelOpciones();
        add(panelOpciones, BorderLayout.WEST);

        //agregando JDestosktopPanel
       desktopMenu desktopMenu = new desktopMenu();

        add(desktopMenu);

        desktopMenu.setVisible(true);






        setVisible(true);
    }

}
