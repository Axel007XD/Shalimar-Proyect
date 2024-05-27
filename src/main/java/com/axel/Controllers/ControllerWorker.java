package com.axel.Controllers;

import com.axel.Models.Trabajador;
import com.axel.Views.ViewWorker;
import com.axel.Views.viewAddWorker;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.GlobalUtil;
import com.axel.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.PersistentClass;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControllerWorker implements ActionListener {
    private viewAddWorker viewWorker;
    private Trabajador trabajador;
    private List <Trabajador> trabajadores;
    private ViewWorker vista;




    public ControllerWorker(viewAddWorker viewWorker,ViewWorker vista) {
        this.viewWorker = viewWorker;
        this.viewWorker.getBtnAdd().addActionListener(this);
        this.vista= vista;

    }

    public ControllerWorker() {
    }

    private static List<Trabajador> getWorker(){
        Transaction transaction = null;
        List<Trabajador> trabadores= new ArrayList<>();
        IGenericService<Trabajador> trabador= new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        trabadores= trabador.getAll();
        return trabadores;
    }
    private static void guardarWorker(Trabajador trabajador){
        IGenericService<Trabajador> trabajadores = new GenericServiceImpl<>(Trabajador.class,HibernateUtil.getSessionFactory());
        trabajadores.save(trabajador);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        String name=viewWorker.getTxtName().getText();
        String cedula=viewWorker.getTxtCedula().getText();
        String direccion=viewWorker.getTxtDireccion().getText();
        String telefono=viewWorker.getTxtTelefono().getText();
        if (name.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
            System.out.println("Datos vacios");
        }else {
            trabajador = new Trabajador(name, cedula, telefono, direccion);

            guardarWorker(trabajador);
            //vista.refressTable();
            viewWorker.limpiarCampos();

        }

    }

    public int countFieldsInTable(Class<Trabajador> entityClass) {
        int count =0;
        // Configurar la sesión de Hibernate
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        //esto es cómo para acceder a las tablas de la base de datos
        MetadataSources sources = new MetadataSources(registry);
        //Este se usa para poder contruir los metadatos de la base de datos más o menos para extraer la caract
        sources.addAnnotatedClass(entityClass);
        //se le indica a hibernate que escanee la clase de la entiadad para generar los metadatos(saber q es esa wea)
        Metadata metadata = sources.buildMetadata();
        //se construllen metadatos de los metadatos proporcionados y de nuevo vuelve a scannear hibernate la clase
        //para generar los metadatos con la informacion de la tabla

        // Obtener la información sobre la entidad
        PersistentClass persistentClass = metadata.getEntityBinding(entityClass.getName());
        //Obtiene info sobre la entidad especificada, devuelve un objeto PersistentClass que contiene metadatos de la entidad
        if (persistentClass != null) {
            // Contar el número de propiedades de la entidad (columnas de la tabla)
            count=persistentClass.getPropertyClosureSpan();
            return count+1;
        } else {
            return 0; // La entidad no está mapeada en Hibernate
        }
    }


}
