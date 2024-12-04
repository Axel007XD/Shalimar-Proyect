package com.axel.Views;

import com.axel.Controllers.ControllerProducto;
import com.axel.Models.MetodoPersonalizacion;
import com.axel.Models.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAddDetallePedido extends JFrame {

    private JTextField cantidadField;
    private JTextField precioField;
    private JTextArea descripcionArea;
    private JComboBox<String> productoComboBox;
    private JComboBox<String> metodoComboBox;
    private JButton guardarButton;
    private JButton cancelarButton;
    private List<Producto> productoList;
    private ControllerProducto controllerProducto;
    private OnDetalleGuardadoListener detalleGuardadoListener;
    private List<MetodoPersonalizacion> metodoPersonalizacionList;

    public ViewAddDetallePedido() {
        setTitle("Agregar Detalle de Pedido");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel productoLabel = new JLabel("Producto:");
        productoComboBox = new JComboBox<>(); 
        cargarProductos();
        JLabel metodoLabel = new JLabel("Método de Personalización:");
        metodoComboBox = new JComboBox<>(new String[]{"Sublimado", ""});

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadField = new JTextField();

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField();

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionArea = new JTextArea(4, 20);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        JScrollPane descripcionScrollPane = new JScrollPane(descripcionArea);

        // Agregar componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(productoLabel, gbc);

        gbc.gridx = 1;
        panel.add(productoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(metodoLabel, gbc);

        gbc.gridx = 1;
        panel.add(metodoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cantidadLabel, gbc);

        gbc.gridx = 1;
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(precioLabel, gbc);

        gbc.gridx = 1;
        panel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(descripcionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(descripcionScrollPane, gbc);

        JPanel buttonPanel = new JPanel();
        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (detalleGuardadoListener != null) {
                    String producto = (String) productoComboBox.getSelectedItem();
                    String metodo = (String) metodoComboBox.getSelectedItem();
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    String descripcion = descripcionArea.getText();

                    detalleGuardadoListener.onDetalleGuardado(producto, metodo, cantidad, descripcion);
                }
                dispose();
            }
        });

        buttonPanel.add(guardarButton);
        buttonPanel.add(cancelarButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        panel.add(buttonPanel, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void cargarProductos() {
        controllerProducto = new ControllerProducto();
        productoList = controllerProducto.getProductos();
        for (Producto producto: productoList){
            productoComboBox.addItem(producto.getNombre());
        }

    }

    public void setDetalleGuardadoListener(OnDetalleGuardadoListener listener) {
        this.detalleGuardadoListener = listener;
    }

    public interface OnDetalleGuardadoListener {
        void onDetalleGuardado(String producto, String metodo, int cantidad, String descripcion);
    }
}
