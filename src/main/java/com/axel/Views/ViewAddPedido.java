package com.axel.Views;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewAddPedido extends JFrame {

    private JComboBox<String> clienteComboBox;
    private JComboBox<String> trabajadorComboBox;
    private JDateChooser fechaPedidoChooser;
    private JTable detallesTable;
    private DefaultTableModel detallesModel;
    private JButton agregarFilaButton;
    private JButton eliminarFilaButton;
    private JButton guardarPedidoButton;
    private JButton cancelarButton;

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
        clienteComboBox = new JComboBox<>(new String[]{"Cliente 1", "Cliente 2"});
        JLabel trabajadorLabel = new JLabel("Trabajador:");
        trabajadorComboBox = new JComboBox<>(new String[]{"Trabajador 1", "Trabajador 2"});
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

        setVisible(true);
    }

    // Métodos para obtener los datos de la interfaz gráfica

    public String getClienteSeleccionado() {
        return (String) clienteComboBox.getSelectedItem();
    }

    public String getTrabajadorSeleccionado() {
        return (String) trabajadorComboBox.getSelectedItem();
    }

    public java.util.Date getFechaPedido() {
        return fechaPedidoChooser.getDate();
    }

    public List<Object[]> getDetallesPedido() {
        List<Object[]> detalles = new ArrayList<>();
        for (int i = 0; i < detallesModel.getRowCount(); i++) {
            Object[] fila = new Object[detallesModel.getColumnCount()];
            for (int j = 0; j < detallesModel.getColumnCount(); j++) {
                fila[j] = detallesModel.getValueAt(i, j);
            }
            detalles.add(fila);
        }
        return detalles;
    }

    // Métodos para agregar y eliminar filas en la tabla
    public void agregarFilaDetalle(String producto, String tipo, int cantidad, String descripcion) {
        detallesModel.addRow(new Object[]{producto, tipo, cantidad, descripcion});
    }

    public void eliminarFilaDetalle(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < detallesModel.getRowCount()) {
            detallesModel.removeRow(rowIndex);
        }
    }

    // Métodos para acceder a los botones
    public JButton getGuardarPedidoButton() {
        return guardarPedidoButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getAgregarFilaButton() {
        return agregarFilaButton;
    }

    public JButton getEliminarFilaButton() {
        return eliminarFilaButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewAddPedido::new);
    }
}
