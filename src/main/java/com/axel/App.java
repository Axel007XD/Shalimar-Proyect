package com.axel;

import com.axel.Controllers.ControllerLogin;
import com.axel.Views.Login;
import com.axel.Views.ventanaMenuPrincipal;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        Login login = new Login();
        ControllerLogin con= new ControllerLogin(login);


    }
}
