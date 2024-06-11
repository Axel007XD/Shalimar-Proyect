package com.axel.Views;

import com.axel.Controllers.ControllerWorker;
import com.axel.util.GlobalUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewWorker extends JPanel {

    private JTextField txtBarraBusqueda;
    private Button btnBuscar;

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

        setVisible(true);
    }







}
