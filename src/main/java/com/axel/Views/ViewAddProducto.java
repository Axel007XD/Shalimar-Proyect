package com.axel.Views;

import javax.swing.*;
import java.awt.*;

public class ViewAddProducto extends JFrame {

    public ViewAddProducto() {
        setTitle("Registrar Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel titleLabel = new JLabel("Agregar Producto");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0);
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel nameLabel = new JLabel("Nombre:");
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JTextField nombreProductoField = new JTextField();
        nombreProductoField.setPreferredSize(new Dimension(200, 40)); // Aumentar la altura
        gbc.weightx = 1.0;
        mainPanel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel categoriaLabel = new JLabel("Tipo:");
        mainPanel.add(categoriaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        String[] tipos = {"Sublimado", "Bordado"};
        JComboBox<String> categoriaComboBox = new JComboBox<>(tipos);
        categoriaComboBox.setPreferredSize(new Dimension(200, 40)); // Ajustar tamaño
        gbc.weightx = 1.0;
        mainPanel.add(categoriaComboBox, gbc);

        // Campo: Tamaño
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel tamañoLb = new JLabel("Tamaño:");
        mainPanel.add(tamañoLb, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JTextField tamaño = new JTextField();
        tamaño.setPreferredSize(new Dimension(200, 40)); // Aumentar la altura
        gbc.weightx = 1.0;
        mainPanel.add(tamaño, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel marcaLabel = new JLabel("Marca:");
        mainPanel.add(marcaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        JTextField marcaField = new JTextField();
        marcaField.setPreferredSize(new Dimension(200, 40)); // Aumentar la altura
        gbc.weightx = 1.0;
        mainPanel.add(marcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel colorLable = new JLabel("Color:");
        mainPanel.add(colorLable, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        JTextField colorField = new JTextField();
        colorField.setPreferredSize(new Dimension(200, 40)); // Aumentar la altura
        gbc.weightx = 1.0;
        mainPanel.add(colorField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBackground(Color.BLACK);
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.addActionListener(e -> dispose());

        JButton enviarButton = new JButton("Enviar");
        enviarButton.setBackground(Color.BLACK);
        enviarButton.setForeground(Color.WHITE);
        enviarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Producto registrado."));

        buttonPanel.add(cancelarButton);
        buttonPanel.add(enviarButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
