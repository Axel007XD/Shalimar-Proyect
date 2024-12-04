package com.axel.Views;
import com.axel.Controllers.ControllerCliente;
import com.axel.Controllers.ControllerWorker;
import com.axel.Models.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAddPedido extends JFrame implements ActionListener {

    private JComboBox<String> clienteComboBox;
    private JComboBox<String> trabajadorComboBox;
    private JDateChooser fechaPedidoChooser;
    private JTable detallesTable;
    private DefaultTableModel detallesModel;
    private JButton agregarFilaButton;
    private JButton eliminarFilaButton;
    private JButton guardarPedidoButton;
    private JButton cancelarButton;
    private ViewAddDetallePedido viewAddDetallePedido;
    private List<DetallePedido> detallePedidoList;
    private ControllerCliente controllerCliente;
    private List<Cliente> clienteList;
    private ControllerWorker controllerWorker;
    private  List<Trabajador> trabajadorList;

    public ViewAddPedido() {
        setTitle("Registrar Pedido");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel superior con información del pedido
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel clienteLabel = new JLabel("Cliente:");
        clienteComboBox = new JComboBox<>();
        cargarClientes();

        JLabel trabajadorLabel = new JLabel("Trabajador:");
        trabajadorComboBox = new JComboBox<>();
        cargarTrabajador();

        JLabel fechaPedidoLabel = new JLabel("Fecha de Pedido:");
        fechaPedidoChooser = new JDateChooser();

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(clienteLabel, gbc);

        gbc.gridx = 1;
        topPanel.add(clienteComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        topPanel.add(trabajadorLabel, gbc);

        gbc.gridx = 1;
        topPanel.add(trabajadorComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        topPanel.add(fechaPedidoLabel, gbc);

        gbc.gridx = 1;
        topPanel.add(fechaPedidoChooser, gbc);

        add(topPanel, BorderLayout.NORTH);

        // Tabla de detalles del pedido
        String[] columnas = {"Producto", "Tipo", "Cantidad", "Descripción"};
        detallesModel = new DefaultTableModel(columnas, 0);
        detallesTable = new JTable(detallesModel);
        detallesTable.setPreferredScrollableViewportSize(new Dimension(500, 150));
        detallesTable.setFillsViewportHeight(true);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(detallesTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agregarFilaButton = new JButton("Agregar Fila");
        eliminarFilaButton = new JButton("Eliminar Fila");
        buttonPanel.add(agregarFilaButton);
        buttonPanel.add(eliminarFilaButton);

        tablePanel.add(buttonPanel, BorderLayout.SOUTH);
        add(tablePanel, BorderLayout.CENTER);

        // Botones para guardar o cancelar
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guardarPedidoButton = new JButton("Guardar Pedido");
        cancelarButton = new JButton("Cancelar");

        bottomPanel.add(guardarPedidoButton);
        bottomPanel.add(cancelarButton);

        add(bottomPanel, BorderLayout.SOUTH);
        agregarFilaButton.addActionListener(this);

        setVisible(true);
    }

    public void agregarFilaDetalle(String producto, String tipo, int cantidad, String descripcion) {
        detallesModel.addRow(new Object[]{producto, tipo, cantidad, descripcion});

    }

    public void eliminarFilaDetalle(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < detallesModel.getRowCount()) {
            detallesModel.removeRow(rowIndex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==agregarFilaButton){
            iniciarlizarDetallePedido();

        }

    }
    private ViewAddDetallePedido iniciarlizarDetallePedido(){
        viewAddDetallePedido = new ViewAddDetallePedido();

        viewAddDetallePedido.setDetalleGuardadoListener(new ViewAddDetallePedido.OnDetalleGuardadoListener() {
            @Override
            public void onDetalleGuardado(Producto producto, MetodoPersonalizacion metodo, int cantidad,int precio, String descripcion) {
                String nombreProducto= (String) producto.getNombre();
                String nombreMetodo= (String) metodo.getNombre();

                agregarFilaDetalle(nombreProducto, nombreMetodo, cantidad, descripcion);
            }
        });
        viewAddDetallePedido.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                viewAddDetallePedido = null;
            }
        });
        return viewAddDetallePedido;
    }

    private void cargarClientes(){
        controllerCliente = new ControllerCliente();
        clienteList = controllerCliente.getClientes();
        for (Cliente cliente : clienteList){
            clienteComboBox.addItem(cliente.getNombreCompleto());
        }
    }
    private void cargarTrabajador(){
        controllerWorker = new ControllerWorker();
        trabajadorList = controllerWorker.getTrabajador();
        for (Trabajador trabajador : trabajadorList){
            trabajadorComboBox.addItem(trabajador.getNombreCompleto());
        }
    }


}
