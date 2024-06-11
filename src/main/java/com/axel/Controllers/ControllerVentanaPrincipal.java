package com.axel.Controllers;

import com.axel.Component.MenuPrincipal;
import com.axel.Views.ViewAddCliente;
import com.axel.Views.ViewWorker;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.Views.viewAddWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerVentanaPrincipal implements ActionListener, MouseListener  {
    private ventanaMenuPrincipal ventanaPrincipal;
    private viewAddWorker vistaAgregarWorker;
    private ViewWorker vistaTrabajador;
    private ControllerWorker controllerWorker;
    private ViewAddCliente vistaAgregarCliente;
    private ControllerCliente controllerCliente;
    private static final Logger LOGGER = Logger.getLogger(ControllerVentanaPrincipal.class.getName());

    public ControllerVentanaPrincipal(ventanaMenuPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaPrincipal.getMenuPrincipal().getMenuAddTrabajador().addActionListener(this);
        this.ventanaPrincipal.getMenuPrincipal().getMenuAddCliente().addActionListener(this);
        this.ventanaPrincipal.getPanelOpciones().getOpcion2().addMouseListener(this);

        //this.ventanaPrincipal.getPanelOpciones().getOpcion2().addMouseListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ventanaPrincipal.getMenuPrincipal().getMenuAddTrabajador()){
            //boolean isWorkerVisible= esVisibleJinternal(viewAddWorker.class);
            if (vistaAgregarWorker == null||!esVisibleJinternal(ViewWorker.class)){
                if (vistaAgregarWorker == null) {
                    vistaAgregarWorker = new viewAddWorker();
                    ventanaPrincipal.getDesktopPane().add(vistaAgregarWorker);
                    vistaAgregarWorker.setVisible(true);
                }else{
                    ventanaPrincipal.getDesktopPane().add(vistaAgregarWorker);
                    vistaAgregarWorker.setVisible(true);
                }
                try {
                    vistaAgregarWorker.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    LOGGER.log(Level.SEVERE,"ERROR en la configuracion agregando trabajador",ex) ;
                }
                if(controllerWorker== null){
                    controllerWorker= new ControllerWorker(vistaAgregarWorker,ventanaPrincipal,this);

                }

            }
        }if (e.getSource()==ventanaPrincipal.getMenuPrincipal().getMenuAddCliente()){
            if (vistaAgregarCliente== null||!esVisibleJinternal(ViewAddCliente.class)){
                if (vistaAgregarCliente == null) {
                    vistaAgregarCliente = new ViewAddCliente();
                    ventanaPrincipal.getDesktopPane().add(vistaAgregarCliente);
                    vistaAgregarCliente.setVisible(true);
                }else{
                    ventanaPrincipal.getDesktopPane().add(vistaAgregarCliente);
                    vistaAgregarCliente.setVisible(true);
                }
                try {
                    vistaAgregarCliente.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    LOGGER.log(Level.SEVERE,"ERROR en la configuracion agregando trabajador",ex) ;
                }
                if(controllerCliente== null){
                    controllerCliente= new ControllerCliente(vistaAgregarCliente,ventanaPrincipal);

                }

            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==ventanaPrincipal.getPanelOpciones().getOpcion2()){
            if (!esVisibleJPanel(ViewWorker.class)){
    //
                 vistaTrabajador = new ViewWorker();
                 ventanaPrincipal.getPanelCentro().add(vistaTrabajador,BorderLayout.CENTER);
                 vistaTrabajador.setVisible(true);

                ControllerWorker controllerWorkerTables= new ControllerWorker(vistaTrabajador);
                //controllerWorkerTables.createJtable();
                System.out.println("desde worker");

            }
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

    public ControllerWorker getControllerWorker() {
        return controllerWorker;
    }

    public void setControllerWorker(ControllerWorker controllerWorker) {
        this.controllerWorker = controllerWorker;
    }

    public ventanaMenuPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(ventanaMenuPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public viewAddWorker getVistaAgregarWorker() {
        return vistaAgregarWorker;
    }

    public void setVistaAgregarWorker(viewAddWorker vistaAgregarWorker) {
        this.vistaAgregarWorker = vistaAgregarWorker;
    }

    public ViewWorker getVistaTrabajador() {
        return vistaTrabajador;
    }

    public void setVistaTrabajador(ViewWorker vistaTrabajador) {
        this.vistaTrabajador = vistaTrabajador;
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

    private <T> boolean esVisibleJPanel(Class<T> panelClass) {
        for (Component component : ventanaPrincipal.getPanelCentro().getComponents()) {
            if (panelClass.isInstance(component) && component.isVisible()) {
                return true;
            }
        }
        return false;
    }


}
