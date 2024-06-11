package com.axel.Controllers;

import com.axel.Component.BotonRender;
import com.axel.Component.EditorBotones;
import com.axel.Models.Trabajador;
import com.axel.Views.ViewWorker;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.Views.viewAddWorker;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.GlobalUtil;
import com.axel.util.HibernateUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;

public class ControllerWorker implements ActionListener {
    private Trabajador trabajador;
    private List <Trabajador> trabajadores;
    private ViewWorker viewWorker;
    private ventanaMenuPrincipal ventanaPrincipal;
    private ControllerVentanaPrincipal controllerVentanaPrincipal;
    private viewAddWorker viewAddWorker;
    private JTable tablaTrabajadores;
    private DefaultTableModel tablaTrabajadoresModel;
    private JScrollPane scrollPane;
    private BotonRender botonRender;
    private EditorBotones editorBotones;


    public ControllerWorker(viewAddWorker viewAddWorker,ventanaMenuPrincipal ventanaPrincipal, ControllerVentanaPrincipal controlventanaPrincipal) {
        this.viewAddWorker = viewAddWorker;
        this.ventanaPrincipal = ventanaPrincipal;
        this.controllerVentanaPrincipal = controlventanaPrincipal;
        this.viewAddWorker.getBtnAdd().addActionListener(this);
        this.editorBotones=new EditorBotones(tablaTrabajadores,this);
        this.editorBotones.getBtnEditar().addActionListener(this);
        createJtable();
    }
    public ControllerWorker(ViewWorker viewWorker){
        this.viewWorker = viewWorker;
        createJtable();
    }

    private static void guardarWorker(Trabajador trabajador){
        IGenericService<Trabajador> trabajadores = new GenericServiceImpl<>(Trabajador.class,HibernateUtil.getSessionFactory());
        trabajadores.save(trabajador);
    }
    private static Trabajador obtenerTrabajadoresById(int id){
        IGenericService<Trabajador>trabajadores = new GenericServiceImpl<>(Trabajador.class,HibernateUtil.getSessionFactory());
        Trabajador trabajador1 =trabajadores.getById(id);
        return trabajador1;
    }
    private static void eliminarWorker(Trabajador trabajador){
        IGenericService<Trabajador>trabajadores = new GenericServiceImpl<>(Trabajador.class,HibernateUtil.getSessionFactory());
        trabajadores.delete(trabajador);
    }
    private List<Trabajador> getWorkers(){
        trabajadores=new ArrayList<>();
        IGenericService<Trabajador>trabajador=new GenericServiceImpl<>(Trabajador.class,HibernateUtil.getSessionFactory());
        trabajadores = trabajador.getAll();
        return trabajadores;
    }
    private static void updateTrabajador (Trabajador trabajador){
        IGenericService<Trabajador> studentService = new GenericServiceImpl<>(Trabajador.class, HibernateUtil.getSessionFactory());
        studentService.update(trabajador);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==viewAddWorker.getBtnAdd()){
            String name=viewAddWorker.getTxtName().getText();
            String cedula=viewAddWorker.getTxtCedula().getText();
            String direccion=viewAddWorker.getTxtDireccion().getText();
            String telefono=viewAddWorker.getTxtTelefono().getText();

            if (name.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
                System.out.println("Datos vacios");
            }else {
                trabajador = new Trabajador(name, cedula, telefono, direccion);
                guardarWorker(trabajador);
                viewAddWorker.limpiarCampos();
                Object[] datos = {trabajador.getId(), trabajador.getNombreCompleto(), trabajador.getCedula(), trabajador.getDireccion(), trabajador.getNumeroTelefono()};
                tablaTrabajadoresModel.addRow(datos);
                tablaTrabajadores.repaint();
                //llenarCamposTabla();
                System.out.println("Registro agregado");

            }
        }
        if (e.getSource()==editorBotones.getBtnEditar()){
            System.out.println(editorBotones.getBtnEditar());
        }


    }

    public void createJtable() {

        String[] columnas = {"id", "Nombre", "Cedula", "Direccion", "Telefono", "Operación"};
        String[][] datos = GlobalUtil.obtenerTrabajador();

        tablaTrabajadoresModel = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };

        tablaTrabajadores = new JTable(tablaTrabajadoresModel);
        scrollPane = new JScrollPane(tablaTrabajadores);

        botonRender= new BotonRender();
        editorBotones=new EditorBotones(tablaTrabajadores,this);
        tablaTrabajadores.getColumn("Operación").setCellRenderer(botonRender);
        tablaTrabajadores.getColumn("Operación").setCellEditor(editorBotones);

        editorBotones.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int indiceTablaX=editorBotones.getSelectedRow();
                    if (indiceTablaX>=0 && indiceTablaX<tablaTrabajadores.getRowCount()){
                        Object idTabla=tablaTrabajadores.getValueAt(indiceTablaX,0);
                        System.out.println("ID: "+idTabla);
                        if (idTabla!=null){
                            int idTrabajador=Integer.parseInt(idTabla.toString());
                            eliminarWorker(obtenerTrabajadoresById(idTrabajador));
                            tablaTrabajadoresModel.removeRow(indiceTablaX);
                            llenarCamposTabla();
                        }else{
                            System.out.println("El id es null");
                        }
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        editorBotones.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int indiceTablaX=editorBotones.getSelectedRow();
                    if (indiceTablaX>=0 && indiceTablaX<tablaTrabajadores.getRowCount()){
                        Object idTabla=tablaTrabajadores.getValueAt(indiceTablaX,0);
                        System.out.println("ID: "+idTabla);
                        if (idTabla!=null){

                            int idTrabajador=Integer.parseInt(idTabla.toString());
                            Trabajador trabajador1=obtenerTrabajadoresById(idTrabajador);

                            String nombre=null;
                            String cedula=null;
                            String direccion=null;
                            String telefono=null;

                            while (nombre == null || nombre.isEmpty()) {
                                nombre = JOptionPane.showInputDialog("Ingresa nombre (deja vacío para mantener el actual)");
                                if (nombre == null) {
                                    nombre = trabajador1.getNombreCompleto();
                                }
                            }
                            while (cedula == null || cedula.isEmpty()) {
                                cedula = JOptionPane.showInputDialog("Ingresa cédula (vacío para mantener el actual)");
                                if (cedula == null) {
                                    cedula = trabajador1.getCedula();
                                }
                            }

                            while (direccion == null || direccion.isEmpty()) {
                                direccion = JOptionPane.showInputDialog("Ingresa dirección (vacío para mantener el actual)");
                                if (direccion == null) {
                                    direccion = trabajador1.getDireccion();
                                }
                            }

                            while (telefono == null || telefono.isEmpty()) {
                                telefono = JOptionPane.showInputDialog("Ingresa teléfono (vacío para mantener el actual)");
                                if (telefono == null) {
                                    telefono = trabajador1.getNumeroTelefono();
                                }
                            }
                            trabajador1.getId();
                            trabajador1.setNombreCompleto(nombre);
                            trabajador1.setCedula(cedula);
                            trabajador1.setDireccion(direccion);
                            trabajador1.setNumeroTelefono(telefono);
                            updateTrabajador(trabajador1);


                            llenarCamposTabla();
                        }else{
                            System.out.println("El id es null");
                        }
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        viewWorker.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(tablaTrabajadores);
        scrollPane.setVisible(true);
        llenarCamposTabla();

    }

    public void vaciarModelo(){
        tablaTrabajadoresModel.setRowCount(0);
    }
    public void llenarCamposTabla(){
        SwingUtilities.invokeLater(() -> {
            vaciarModelo();
            List<Trabajador> nuevosTrabajador = getWorkers();
            for (Trabajador trabajador : nuevosTrabajador) {
                Object[] datos = {
                        trabajador.getId(),
                        trabajador.getNombreCompleto(),
                        trabajador.getCedula(),
                        trabajador.getDireccion(),
                        trabajador.getNumeroTelefono()
                };
                tablaTrabajadoresModel.addRow(datos);

            }
        });
    }
}
