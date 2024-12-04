package com.axel.Controllers;

import com.axel.Models.User;
import com.axel.Views.Login;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;
import java.util.List;

public class ControllerUser{
    private Login login;
    private ventanaMenuPrincipal ventanaPrincipal;
    private List <User> usuarios;

    public ControllerUser() {
        this.usuarios= getUser();
        subirUser();
    }

    public void subirUser(){

        if (usuarios==null || usuarios.isEmpty()){
            User usuario= new User("Admin","1234");
            guardarUser(usuario);
            usuarios=getUser();
        }
    }

    private List<User> getUser(){
        IGenericService<User> usuario= new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
        return usuario.getAll();
    }
    public void guardarUser(User user){
       IGenericService<User> usuario = new GenericServiceImpl<>(User.class,HibernateUtil.getSessionFactory());
       usuario.save(user);
    }

    public boolean validarUser(String nombre, String contrasena){
        for (User user : usuarios) {
            if (nombre.equals(user.getUsuario())&& contrasena.equals(user.getPassworld())) {
               return true;
            }
        }
        return false;
    }
}
