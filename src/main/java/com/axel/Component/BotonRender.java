package com.axel.Component;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BotonRender extends JPanel implements TableCellRenderer {
    private JButton botonEditar=new JButton("Upd");
    private JButton botonEliminar=new JButton("De");
    public BotonRender() {
        setLayout(new FlowLayout());
        add(botonEditar);
        add(botonEliminar);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);

        }
//        if (isSelected){
//            setBackground(table.getSelectionBackground());
//        }else{
//            setBackground(table.getBackground());
//        }
        return this;
    }
}
