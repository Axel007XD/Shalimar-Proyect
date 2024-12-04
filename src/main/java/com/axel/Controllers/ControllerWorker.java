package com.axel.Controllers;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;
import com.axel.Models.Trabajador;
import java.util.List;

public class ControllerWorker {
    public ControllerWorker(){

    }
    public void guardarCliente(Trabajador trabajador){
        IGenericService<Trabajador> trabajadorIGenericService = new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        trabajadorIGenericService.save(trabajador);
    }
        public void eliminarTrabajador(Trabajador trabajador){
        IGenericService<Trabajador> trabajadorIGenericService = new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        trabajadorIGenericService.delete(trabajador);
    }
    public void editarTrabajador(Trabajador trabajador){
        IGenericService<Trabajador> trabajadorIGenericService = new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        trabajadorIGenericService.update(trabajador);
    }
    public List<Trabajador> getTrabajador() {
        IGenericService<Trabajador> trabajadorIGenericService= new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        return trabajadorIGenericService.getAll();
    }


}
