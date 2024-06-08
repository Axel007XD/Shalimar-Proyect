package com.axel.Controllers;

import com.axel.Component.MenuPrincipal;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.Views.viewAddWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener;

import static java.awt.Component.CENTER_ALIGNMENT;

public class ControllerVentanaPrincipal implements ActionListener {
    private ventanaMenuPrincipal ventanaPrincipal;
    viewAddWorker vistaAgregarWorker;

    public ControllerVentanaPrincipal(ventanaMenuPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaPrincipal.getMenuPrincipal().getMenuAddTrabajador().addActionListener(this);
//        this.ventanaPrincipal.getDesktopMenu().getMenuBar().getMenuAddAgenda().addActionListener(this);
//        this.ventanaPrincipal.getDesktopMenu().getMenuBar().getMenuAddPedido().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MenuPrincipal ventanaPrincipalSources= ventanaPrincipal.getMenuPrincipal();
        if(e.getSource() == ventanaPrincipalSources.getMenuAddTrabajador()){

            boolean isWorkerVisible= esVisibleJinternal(viewAddWorker.class);
            if (!isWorkerVisible){
                vistaAgregarWorker = new viewAddWorker();
                ventanaPrincipal.getDesktopPane().add(vistaAgregarWorker);
                vistaAgregarWorker.setVisible(true);
                try {
                    vistaAgregarWorker.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if(e.getSource() == ventanaPrincipalSources.getMenuAddAgenda()){
            System.out.println("hello agenda");
        }
        if(e.getSource() == ventanaPrincipalSources.getMenuAddPedido()){

        }


    }

    private <T> boolean esVisibleJinternal(Class<T> internalClass) {
        JInternalFrame[] allFrames = ventanaPrincipal.getDesktopPane().getAllFrames();
        for (JInternalFrame frame : allFrames) {
            if (frame.isVisible()) {
                return true;
            }
        }
        return false;
    }


}
