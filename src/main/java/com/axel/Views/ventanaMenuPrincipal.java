package com.axel.Views;


import com.axel.Component.MenuPrincipal;

import javax.swing.*;
import java.awt.*;


public class ventanaMenuPrincipal extends JFrame{

    private panelOpciones panelOpciones;
    private MenuPrincipal menuPrincipal;
    private JPanel panelCentro;
    private JPanel panelMenuBar;
    private JDesktopPane desktopPane;

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

        //Agregando panel para contener el menubar y desktopPanel
        panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());
        add(panelCentro, BorderLayout.CENTER);

        panelMenuBar = new JPanel();
        panelMenuBar.setLayout(new BorderLayout());
        menuPrincipal= new MenuPrincipal();
        panelMenuBar.add(menuPrincipal,BorderLayout.NORTH);
        panelCentro.add(panelMenuBar, BorderLayout.NORTH);

        //agregando JDestosktopPanel

        desktopPane = new JDesktopPane();
        desktopPane.setLayout(new BorderLayout());
        panelCentro.add(desktopPane, BorderLayout.CENTER);
        setVisible(true);


    }


    public MenuPrincipal getMenuPrincipal() {
        return menuPrincipal;
    }

    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public void setPanelCentro(JPanel panelCentro) {
        this.panelCentro = panelCentro;
    }

    public JPanel getPanelMenuBar() {
        return panelMenuBar;
    }

    public void setPanelMenuBar(JPanel panelMenuBar) {
        this.panelMenuBar = panelMenuBar;
    }

    public com.axel.Views.panelOpciones getPanelOpciones() {
        return panelOpciones;
    }

    public void setPanelOpciones(com.axel.Views.panelOpciones panelOpciones) {
        this.panelOpciones = panelOpciones;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }
}
