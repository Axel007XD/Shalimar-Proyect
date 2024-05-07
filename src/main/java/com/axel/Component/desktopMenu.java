package com.axel.Component;

import com.axel.Views.viewAddAgenda;
import com.axel.Views.viewAddWorker;
import com.axel.Views.viewAddPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class desktopMenu extends JDesktopPane implements ActionListener{
    private MenuPrincipal menuBar;
    private JDesktopPane desktop;

    public desktopMenu() {
        setLayout(new BorderLayout());
        menuBar = new MenuPrincipal();

        add(menuBar, BorderLayout.NORTH);

        menuBar.menuAddAgenda.addActionListener(this);
        menuBar.menuAddTrabajador.addActionListener(this);
        menuBar.menuAddPedido.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuBar.menuAddAgenda) {
            viewAddAgenda vistaAgenda=new viewAddAgenda();

            setLayout(null);
            vistaAgenda.setSize(550,500);

            vistaAgenda.setLocation(50,20);

            setAlignmentX(CENTER_ALIGNMENT);

            add(vistaAgenda);

        }
        if (e.getSource() == menuBar.menuAddTrabajador) {
            viewAddWorker vistaWorker=new viewAddWorker();

            setLayout(null);
            vistaWorker.setSize(550,500);

            vistaWorker.setLocation(50,20);

            setAlignmentX(CENTER_ALIGNMENT);

            add(vistaWorker);
        }
        if (e.getSource() == menuBar.menuAddPedido) {
            viewAddPedido vistaPedido=new viewAddPedido();

            setLayout(null);
            vistaPedido.setSize(550,500);

            vistaPedido.setLocation(50,20);

            setAlignmentX(CENTER_ALIGNMENT);

            add(vistaPedido);
        }


    }
}
