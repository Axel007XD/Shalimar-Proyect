package com.axel.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;

public class AgendaVista extends JPanel implements ActionListener {
    private JPanel calendarioPanel;
    private JLabel mesLabel;
    private LocalDate fechaActual;
    private LocalDate fechaVisible;
    private JButton crearPedidoButton;
    private ViewAddPedido viewAddPedido;


    public AgendaVista() {
        setLayout(new BorderLayout());

        fechaActual = LocalDate.now();
        fechaVisible = fechaActual.withDayOfMonth(1);

        JPanel topPanel = new JPanel(new BorderLayout());
        mesLabel = new JLabel("", SwingConstants.CENTER);
        actualizarMesLabel();

        crearPedidoButton = new JButton("Crear pedido");
        topPanel.add(mesLabel, BorderLayout.CENTER);
        topPanel.add(crearPedidoButton, BorderLayout.EAST);

        JPanel navigationPanel = new JPanel(new FlowLayout());
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ags", "Sep", "Oct", "Nov", "Dic"};
        for (int i = 0; i < meses.length; i++) {
            int mes = i + 1;
            JButton mesButton = new JButton(meses[i]);
            mesButton.addActionListener(e -> cambiarMes(mes));
            navigationPanel.add(mesButton);
        }

        calendarioPanel = new JPanel(new GridLayout(0, 7));
        actualizarCalendario();

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(topPanel,BorderLayout.NORTH);
        panelSuperior.add(navigationPanel, BorderLayout.SOUTH);
        add(panelSuperior, BorderLayout.NORTH);
        add(calendarioPanel, BorderLayout.CENTER);

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
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String dia : diasSemana) {
            JLabel diaLabel = new JLabel(dia, SwingConstants.CENTER);
            diaLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            calendarioPanel.add(diaLabel);
        }

        YearMonth yearMonth = YearMonth.of(fechaVisible.getYear(), fechaVisible.getMonthValue());
        int diasEnMes = yearMonth.lengthOfMonth();
        int primerDiaSemana = fechaVisible.getDayOfWeek().getValue();

        for (int i = 1; i < primerDiaSemana; i++) {
            calendarioPanel.add(new JLabel(""));
        }

        for (int dia = 1; dia <= diasEnMes; dia++) {
            LocalDate fechaDia = fechaVisible.withDayOfMonth(dia);
            JButton diaButton = new JButton(String.valueOf(dia));
            diaButton.setOpaque(true);

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
        crearPedidoButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==crearPedidoButton){
            inicializarPedido();


        }

    }

    private ViewAddPedido inicializarPedido(){
        if (viewAddPedido==null){
            viewAddPedido = new ViewAddPedido();
            viewAddPedido.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    viewAddPedido = null;
                }
            });
        }
        return viewAddPedido;
    }



}