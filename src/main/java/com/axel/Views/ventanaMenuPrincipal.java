package com.axel.Views;

import com.axel.Component.MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaMenuPrincipal extends JFrame implements MouseListener, ActionListener {

    private panelOpciones panel_opciones;
    private MenuPrincipal menuPrincipal;
    private JPanel panelCentro;
    private JPanel panelMenuBar;
    private JPanel centro;

    public ventanaMenuPrincipal() {
        setTitle("Shalimar Company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setSize(1000, 600);
        setLayout(new BorderLayout());

        // Agregando panel de opciones
        panel_opciones = new panelOpciones();
        add(panel_opciones, BorderLayout.WEST);

        panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());
        add(panelCentro, BorderLayout.CENTER);

        panelMenuBar = new JPanel();
        panelMenuBar.setLayout(new BorderLayout());
        menuPrincipal = new MenuPrincipal();
        panelMenuBar.add(menuPrincipal, BorderLayout.NORTH);
        panelCentro.add(panelMenuBar, BorderLayout.NORTH);

        centro = new JPanel();
        centro.setLayout(new BorderLayout());
        panelCentro.add(centro, BorderLayout.CENTER);

        panel_opciones.getPanelOPcion1().addMouseListener(this);
        menuPrincipal.getMenuAddProducto().addActionListener(this);
        menuPrincipal.getMenuAddCliente().addActionListener(this);
        menuPrincipal.getMenuAddMetodoPersonalizacion().addActionListener(this);
        menuPrincipal.getMenuAddTrabajador().addActionListener(this);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == panel_opciones.getPanelOPcion1()) {
            System.out.println("hola desde mouseListener");
            mostrarAgendaVista();
        }
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuPrincipal.getMenuAddProducto()) {
            new ViewAddProducto();

        }
        if (actionEvent.getSource()==menuPrincipal.getMenuAddCliente()){
            new ViewAddCliente();
        }
        if (actionEvent.getSource()==menuPrincipal.getMenuAddMetodoPersonalizacion()){
            new ViewMetodoPersonalizacion();
        }
        if (actionEvent.getSource()==menuPrincipal.getMenuAddTrabajador()){
            new viewAddWorker();
        }


    }

    private void mostrarAgendaVista() {
        centro.removeAll();
        AgendaVista agendaVista = new AgendaVista();
        centro.add(agendaVista, BorderLayout.CENTER);
        centro.revalidate();
        centro.repaint();
    }
}
