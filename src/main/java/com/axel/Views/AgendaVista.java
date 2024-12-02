package com.axel.Views;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class AgendaVista extends JPanel {
    private JPanel calendarioPanel; // Panel dinámico del calendario
    private JLabel mesLabel; // Etiqueta para el mes actual
    private LocalDate fechaActual; // Fecha actual
    private LocalDate fechaVisible; // Fecha del mes visible

    public AgendaVista() {
        setLayout(new BorderLayout());

        fechaActual = LocalDate.now();
        fechaVisible = fechaActual.withDayOfMonth(1); // Primer día del mes actual

        // Panel superior (Mes y botones de navegación)
        JPanel topPanel = new JPanel(new BorderLayout());
        mesLabel = new JLabel("", SwingConstants.CENTER);
        actualizarMesLabel();

        JButton crearPedidoButton = new JButton("Crear pedido");
        topPanel.add(mesLabel, BorderLayout.CENTER);
        topPanel.add(crearPedidoButton, BorderLayout.EAST);

        // Panel de navegación (Meses)
        JPanel navigationPanel = new JPanel(new FlowLayout());
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ags", "Sep", "Oct", "Nov", "Dic"};
        for (int i = 0; i < meses.length; i++) {
            int mes = i + 1; // Los meses en LocalDate comienzan en 1
            JButton mesButton = new JButton(meses[i]);
            mesButton.addActionListener(e -> cambiarMes(mes));
            navigationPanel.add(mesButton);
        }

        // Panel del calendario
        calendarioPanel = new JPanel(new GridLayout(0, 7));
        actualizarCalendario();

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(topPanel,BorderLayout.NORTH);
        panelSuperior.add(navigationPanel, BorderLayout.SOUTH);
        add(panelSuperior, BorderLayout.NORTH);
        add(calendarioPanel, BorderLayout.CENTER); // El calendario ocupa el espacio central

        setVisible(true);
    }

    private void actualizarMesLabel() {
        mesLabel.setText(fechaVisible.getMonth().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.getDefault()) + " " + fechaVisible.getYear());
    }

    private void cambiarMes(int mes) {
        fechaVisible = fechaVisible.withMonth(mes).withDayOfMonth(1);
        actualizarMesLabel();
        actualizarCalendario();
    }

    private void actualizarCalendario() {
        calendarioPanel.removeAll();

        // Días de la semana
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String dia : diasSemana) {
            JLabel diaLabel = new JLabel(dia, SwingConstants.CENTER);
            diaLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            calendarioPanel.add(diaLabel);
        }

        // Días del mes
        YearMonth yearMonth = YearMonth.of(fechaVisible.getYear(), fechaVisible.getMonthValue());
        int diasEnMes = yearMonth.lengthOfMonth();
        int primerDiaSemana = fechaVisible.getDayOfWeek().getValue(); // 1 = lunes, 7 = domingo

        // Espacios vacíos antes del primer día
        for (int i = 1; i < primerDiaSemana; i++) {
            calendarioPanel.add(new JLabel(""));
        }

        // Días del mes con colores
        for (int dia = 1; dia <= diasEnMes; dia++) {
            LocalDate fechaDia = fechaVisible.withDayOfMonth(dia);
            JButton diaButton = new JButton(String.valueOf(dia));
            diaButton.setOpaque(true);

            // Colorear según la proximidad
            long diferenciaDias = fechaDia.toEpochDay() - fechaActual.toEpochDay();
            if (diferenciaDias == -2 || diferenciaDias == -1) {
                diaButton.setBackground(Color.RED);
            } else if (diferenciaDias == 1 || diferenciaDias == 2) {
                diaButton.setBackground(Color.YELLOW);
            } else if (diferenciaDias > 2) {
                diaButton.setBackground(Color.GREEN);
            } else {
                diaButton.setBackground(Color.WHITE);
            }

            diaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            calendarioPanel.add(diaButton);
        }

        calendarioPanel.revalidate();
        calendarioPanel.repaint();
    }

}