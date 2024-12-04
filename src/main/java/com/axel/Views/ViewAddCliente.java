package com.axel.Views;

import com.axel.Controllers.ControllerCliente;
import com.axel.Models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAddCliente extends JFrame {

    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JButton guardarButton;
    private JButton cancelarButton;
    private ControllerCliente controllerCliente;

    public ViewAddCliente() {
        setTitle("Registrar Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Agregar Cliente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 2; // Título ocupará dos columnas
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(nombreLabel, gbc);

        nombreField = new JTextField();
        nombreField.setPreferredSize(new Dimension(300, 40));
        gbc.gridx = 1;
        mainPanel.add(nombreField, gbc);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(direccionLabel, gbc);

        direccionField = new JTextField();
        direccionField.setPreferredSize(new Dimension(300, 40));
        gbc.gridx = 1;
        mainPanel.add(direccionField, gbc);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(telefonoLabel, gbc);

        telefonoField = new JTextField();
        telefonoField.setPreferredSize(new Dimension(300, 40));
        gbc.gridx = 1;
        mainPanel.add(telefonoField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        guardarButton = new JButton("Guardar");
        guardarButton.setBackground(Color.BLACK);
        guardarButton.setForeground(Color.WHITE);
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBackground(Color.BLACK);
        cancelarButton.setForeground(Color.WHITE);

        guardarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                guardaCliente();
                dispose();
            }
        }
        );
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        buttonPanel.add(guardarButton);
        buttonPanel.add(cancelarButton);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    private void guardaCliente(){
        String nombre=nombreField.getText();
        String telefono= telefonoField.getText();
        String direccion = direccionField.getText();

        if (nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            controllerCliente = new ControllerCliente();
            Cliente cliente = new Cliente();
            controllerCliente.guardarCliente(cliente);


        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
