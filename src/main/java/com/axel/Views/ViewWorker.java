package com.axel.Views;

import com.axel.Controllers.ControllerWorker;
import com.axel.util.GlobalUtil;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;


import static com.axel.util.GlobalUtil.obtenerTrabajador;

public class ViewWorker extends JPanel {
    private JTextField txtBarraBusqueda;
    private Button btnBuscar;
    private ControllerWorker controllerWorker;

    private JTable tabla;
    private DefaultTableModel tableModel;

    public ViewWorker() {
        setLayout(new BorderLayout());

        //barra de buscar para future
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtBarraBusqueda = new JTextField();
        txtBarraBusqueda.setPreferredSize(new Dimension(300, 25));
        panelNorte.add(txtBarraBusqueda);

        btnBuscar = new Button("Buscar");
        panelNorte.add(btnBuscar);
        panelNorte.setPreferredSize(new Dimension(200, 150));
        add(panelNorte, BorderLayout.NORTH);

        //Creacion de la tabla

        tableModel= new DefaultTableModel();
        tableModel.addColumn("id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cedula");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Direccion");
        tableModel.addColumn("Operacion");
        tabla = new JTable(tableModel);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(tabla);

        add(tabla, BorderLayout.CENTER);
        System.out.println("desde el metodo tabla");

    }
    public void crearTable() {


    }

    public void refressTable(){
        Object[][] datos = GlobalUtil.obtenerTrabajador();
        tableModel.setRowCount(0);
        for( Object[] row : datos ){
            tableModel.addRow(row);
        }
    }




}
