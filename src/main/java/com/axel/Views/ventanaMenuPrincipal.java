package com.axel.Views;


import com.axel.Component.MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ventanaMenuPrincipal extends JFrame implements MouseListener {

    private panelOpciones panel_opciones;
    private MenuPrincipal menuPrincipal;
    private JPanel panelCentro;
    private JPanel panelMenuBar;
    private JDesktopPane desktopPane;
    private JPanel panelMostrarItem;

    public ventanaMenuPrincipal() {
        setTitle("Shalimar Company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setSize(1000,600);
        setLayout(new BorderLayout());

        //agregando panel de opciones
        panel_opciones = new panelOpciones();
        add(panel_opciones, BorderLayout.WEST);

        //Agregando panel para contener el menubar y desktopPanel
        panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());
        add(panelCentro, BorderLayout.CENTER);

        panelMenuBar = new JPanel();
        panelMenuBar.setLayout(new BorderLayout());
        menuPrincipal= new MenuPrincipal();
        panelMenuBar.add(menuPrincipal,BorderLayout.NORTH);
        panelCentro.add(panelMenuBar, BorderLayout.NORTH);

        //agregando JDestosktopPanel a dentro de un Jpanel

        //panelMostrarItem = new JPanel();

//        panelMostrarItem.setLayout(new BorderLayout());
//        panelCentro.add(panelMostrarItem, BorderLayout.CENTER);

        desktopPane = new JDesktopPane();
        desktopPane.setOpaque(false);
        panelCentro.add(desktopPane, BorderLayout.CENTER);
        panel_opciones.getPanelOPcion1().addMouseListener(this);




        setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==panel_opciones.getPanelOPcion1() ){

        }
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

    public panelOpciones getPanel_opciones() {
        return panel_opciones;
    }

    public void setPanel_opciones(panelOpciones panel_opciones) {
        this.panel_opciones = panel_opciones;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public JPanel getPanelMostrarItem() {
        return panelMostrarItem;
    }

    public void setPanelMostrarItem(JPanel panelMostrarItem) {
        this.panelMostrarItem = panelMostrarItem;
    }




    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
