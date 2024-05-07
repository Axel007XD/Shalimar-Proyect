package com.axel.Controllers;

import com.axel.Views.Login;
import com.axel.Views.ventanaMenuPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLogin implements ActionListener {
    private Login login;
    private boolean validacion=false;


    public ControllerLogin(Login login) {
        this.login = login;
        this.login.getBtnLogin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String user= login.getTxtName().getText();
        char[] passwordCaracters= login.getTxtPassword().getPassword();
        String password= new String(passwordCaracters);
        if(user.equals("") && password.equals("")){
            validacion=true;
            login.dispose();
            abrirVentaMenuPrincipal();
        }else{
            JOptionPane.showInputDialog(null,"Usuario o Correo incorrecto","Error",JOptionPane.ERROR_MESSAGE);

        }

    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

    private void abrirVentaMenuPrincipal(){
        if(isValidacion()){
            new ventanaMenuPrincipal();
        }
    }
}
