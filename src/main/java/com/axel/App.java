package com.axel;

import com.axel.Controllers.ControllerLogin;
import com.axel.Models.Trabajador;
import com.axel.Views.Login;

public class App {


    public static void main(String[] args) {



        Login login = new Login();

        ControllerLogin con= new ControllerLogin(login);


    }

}

