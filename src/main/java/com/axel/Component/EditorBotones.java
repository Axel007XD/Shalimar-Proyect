package com.axel.Component;

import com.axel.Controllers.ControllerWorker;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorBotones extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel = new JPanel();
    private final JButton btnEditar = new JButton("UPD");
    private final JButton btnEliminar = new JButton("DEL");
    private JTable table;
    private ControllerWorker controller;

    public EditorBotones(JTable table, ControllerWorker controller){
        this.table = table;
        this.controller = controller;

        panel.setLayout(new FlowLayout());
        panel.add(btnEditar);
        panel.add(btnEliminar);

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int row = table.getSelectedRow();


            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                getSelectedRow();
                int row = table.getSelectedRow();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public ControllerWorker getController() {
        return controller;
    }

    public void setController(ControllerWorker controller) {
        this.controller = controller;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    public int getSelectColum(){
        return table.getSelectedColumn();
    }
}
