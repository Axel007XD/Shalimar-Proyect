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
    private JPanel centro;

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

        panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());
        add(panelCentro, BorderLayout.CENTER);

        panelMenuBar = new JPanel();
        panelMenuBar.setLayout(new BorderLayout());
        menuPrincipal= new MenuPrincipal();
        panelMenuBar.add(menuPrincipal,BorderLayout.NORTH);
        panelCentro.add(panelMenuBar, BorderLayout.NORTH);


        centro = new JPanel();
        centro.setLayout(new BorderLayout());
        desktopPane = new JDesktopPane();
        desktopPane.setOpaque(false);
        centro.add(desktopPane, BorderLayout.CENTER);
        panelCentro.add(centro, BorderLayout.CENTER);

        panel_opciones.getPanelOPcion1().addMouseListener(this);


        desktopPane.repaint();
        setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==panel_opciones.getPanelOPcion1() ){
            System.out.println("hola desde mauselistener");
            centro.removeAll();
            centro.add(new AgendaVista(), BorderLayout.CENTER);
            centro.revalidate();
            centro.repaint();

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
