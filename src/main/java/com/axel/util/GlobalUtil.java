package com.axel.util;

import com.axel.Controllers.ControllerWorker;
import com.axel.Models.Trabajador;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import java.util.List;



public class GlobalUtil {
    public static String[][] obtenerTrabajador() {
        IGenericService<Trabajador> trabajadores = new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        List<Trabajador> listaTrabajador = trabajadores.getAll();
        String[][] trabajador = new String[listaTrabajador.size()][5]; // Assuming 5 columns for worker details

        for (int i = 0; i < listaTrabajador.size(); i++) {
            Trabajador trabajadorActual = listaTrabajador.get(i);
            trabajador[i][0] = String.valueOf(trabajadorActual.getId());
            trabajador[i][1] = trabajadorActual.getNombreCompleto();
            trabajador[i][2] = trabajadorActual.getCedula();
            trabajador[i][3] = trabajadorActual.getDireccion();
            trabajador[i][4] = trabajadorActual.getNumeroTelefono();
        }

        return trabajador;
    }
}
