package com.axel;

import com.axel.Controllers.ControllerAgenda;
import com.axel.Controllers.ControllerProducto;
import com.axel.Models.Producto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


import java.util.HashMap;
import java.util.List;


public class ReporteService {


    public void generarReporte() throws JRException {
        ControllerProducto controllerProducto = new ControllerProducto();
        // Obtener los productos desde la base de datos
        List<Producto> productos = controllerProducto.getProductos();

        // Crear una fuente de datos JRBeanCollectionDataSource a partir de la lista de productos
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);

        // Cargar el archivo JRXML
        JasperReport jasperReport = JasperCompileManager.compileReport("/home/axel/informes/PruebaInformeProducto.jrxml");

        // Parámetros, si es necesario
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("ds", dataSource); // Pasar el datasource al reporte

        // Llenar el reporte con los datos
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Visualizar el reporte en un visor
        JasperViewer.viewReport(jasperPrint, false);
    }
}
