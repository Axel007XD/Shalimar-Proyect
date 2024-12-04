package com.axel.Views;


import com.axel.Controllers.ControllerAgenda;
import com.axel.Models.MetodoPersonalizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMetodoPersonalizacion extends JFrame {

    private JTextField nombreField;
    private ControllerAgenda controllerAgenda;

    public ViewMetodoPersonalizacion() {
        setTitle("Agregar Método de Personalización");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nombreLabel = new JLabel("Nombre del Método:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        mainPanel.add(nombreLabel, gbc);

        nombreField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        mainPanel.add(nombreField, gbc);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controllerAgenda = new ControllerAgenda();
                String nombre= nombreField.getText();
                MetodoPersonalizacion metodoPersonalizacion = new MetodoPersonalizacion(nombre);
                controllerAgenda.guardarMetodoPersonalizado(metodoPersonalizacion);
                dispose();

            }
        });

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());

        buttonPanel.add(enviarButton);
        buttonPanel.add(cancelarButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
