package com.axel.Controllers;

import com.axel.Models.User;
import com.axel.Views.Login;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControllerLogin implements ActionListener {
    private Login login;
    private ventanaMenuPrincipal ventanaPrincipal;
    private List <User> usuarios;

    public ControllerLogin(Login login) {
        this.login = login;
        this.login.getBtnLogin().addActionListener(this);
        subirUser();
    }

    public ControllerLogin(){

    }

    public void subirUser(){

        User usuario= new User("Admin","1234");
        guardarUser(usuario);
        usuarios=getUser();
    }

    private List<User> getUser(){
        IGenericService<User> usuario= new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
        return usuario.getAll();
    }
    public void guardarUser(User user){
       IGenericService<User> usuario = new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
       usuario.save(user);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==login.getBtnLogin()) {
            String nombreUser = login.getTxtName().getText();
            String contraseñaUser = new String(login.getTxtPassword().getPassword());

            boolean validacion=false;

            if (nombreUser.isEmpty() || contraseñaUser.isEmpty()){

                JOptionPane.showMessageDialog(login, "Usuario o contraseña incorrectos");

            } else{

                boolean validar=validarUser(nombreUser,contraseñaUser);
                if (validar){
                    inicializarVenta();
                    login.dispose();
                }else{
                    JOptionPane.showMessageDialog(login, "Usuario o contraseña incorrectos");
                }


            }

        }
    }

    private ventanaMenuPrincipal inicializarVenta(){
        if(ventanaPrincipal==null){

            ventanaPrincipal=new ventanaMenuPrincipal();
            new ControllerVentanaPrincipal(ventanaPrincipal);
            //System.out.println("hola");
        }
        return ventanaPrincipal;
    }

    private boolean validarUser(String nombre, String contrasena){
        for (User user : usuarios) {
            if (nombre.equals(user.getUsuario())&& contrasena.equals(user.getPassworld())) {
                System.out.println("HOla");
               return true;

            }

        }
        return false;
    }
}
