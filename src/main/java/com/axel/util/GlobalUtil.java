package com.axel.util;

import com.axel.Controllers.ControllerWorker;
import com.axel.Models.Trabajador;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import java.util.List;



public class GlobalUtil {
    public static Object[][] obtenerTrabajador(){
        IGenericService<Trabajador>trabajadores= new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        List <Trabajador> listaTrabajador = trabajadores.getAll();
        Object[][] datos = new Object[listaTrabajador.size()][new ControllerWorker().countFieldsInTable(Trabajador.class)];
        for (int i = 0; i < listaTrabajador.size(); i++) {
            Trabajador trabajador = listaTrabajador.get(i);

            datos[i][0] = trabajador.getId();
            datos[i][1] = trabajador.getNombreCompleto();
            datos[i][2] = trabajador.getCedula();
            datos[i][3] = trabajador. getNumeroTelefono();
            datos[i][4] = trabajador.getDireccion();
        }

        return datos;
    }
}
