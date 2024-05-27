package com.axel.Controllers;

import com.axel.Models.User;
import com.axel.Views.Login;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControllerLogin implements ActionListener {
    private Login login;
    private boolean validacion=false;
    List <User> usuarios;

    public void subirUser(){
        User usuario= new User("Admin","1234");
        guardarUser(usuario);
        usuarios=getUser();
    }
    public ControllerLogin(){

    }

    private List<User> getUser(){
        Transaction transaction = null;
        List<User> usuarios= new ArrayList<>();
        IGenericService<User> usuario= new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
        usuarios=usuario.getAll();
        usuarios.forEach(System.out::println);
        return usuarios;
    }
    public void guardarUser(User user){
       IGenericService<User> usuario = new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
       usuario.save(user);
    }


    public ControllerLogin(Login login) {
        subirUser();
        this.login = login;
        this.login.getBtnLogin().addActionListener(this);
        new ventanaMenuPrincipal();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public boolean isValidacion() {
        return validacion;
    }



    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

    private void abrirVentaMenuPrincipal(){
        if(isValidacion()){

        }
    }
}
