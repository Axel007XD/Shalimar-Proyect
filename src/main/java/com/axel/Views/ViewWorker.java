package com.axel.Views;

import com.axel.Controllers.ControllerWorker;
import com.axel.util.GlobalUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import static com.axel.util.GlobalUtil.obtenerTrabajador;

public class ViewWorker extends JPanel implements ActionListener {

    private JTextField txtBarraBusqueda;
    private Button btnBuscar;
    private ControllerWorker controllerWorker;
    private viewAddWorker viewAddWorker;
    private String[][] datos;

    private JTable tabla;
    private DefaultTableModel tableModel;

    public ViewWorker(viewAddWorker viewAddWorker) {
        this.viewAddWorker=viewAddWorker;
        viewAddWorker.getBtnAdd().addActionListener(this);
    }
    public ViewWorker(){
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

        datos= GlobalUtil.obtenerTrabajador();
        //tableModel.addColumn(tablaname);
        tabla = new JTable(tableModel);

        for( int i=0; i<datos.length; i++ ) {
            tableModel.addRow(datos);
        }
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(400, 300));


        add(scrollPane, BorderLayout.CENTER);

        System.out.println("desde el metodo tabla");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==viewAddWorker.getBtnAdd()) {
            tableModel.addRow(obtenerTrabajador());
        }

    }






}
