//package tpv_ex_v05;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Cliente cliente;
    private String fechaEmision;
    private float importeTotal;
    private int numFactura;
    private ArrayList<Venta> ventas; // lo devuelve el gestorventas
    
    private static  SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /*
 * número de la factura (identificador único), CIF del vendedor, razón social del vendedor,
 * fecha de emisión de la factura, datos del cliente (los indicados con anterioridad, excepto la fecha de alta en el sistema),
 * listado de los diferentes productos vendidos (especificando para cada producto, el ticket en el que se encuentra,
 * su cantidad vendida e importe total) así como suma del total de la venta (valor total de la factura)
 */

/**
 * Constructor vacio
 * @param fechaEmision
 */
    public Factura() {

    }
/**
 * Constructor Factura
 * @param c
 * @param fechaEmision
 * @param lvf
 */
    public Factura(Cliente c, ArrayList<Venta> lvf) {
        cliente = c;
        ventas = lvf;
        fechaEmision = DATE_FORMAT.format(new Date());
        numFactura = 123;
        importeTotal = calcularImporte(lvf);
    }


    public int getFacturaID() {
        return numFactura;
    }

    /**
     * ID: AAAAMMDDHHMM
      * @return
     */
    public String toString(){
        return String.format("ID Factura: %10d Fecha Emisión: %s", numFactura, fechaEmision);
    }

    private float calcularImporte(ArrayList<Venta> listaVentas){
        float importe = 0;
        for(Venta vent : listaVentas){
            importe = importe + vent.getImporteVenta();
        }

        return importe;
    }


}
    /*


       
    public String toString(){
	// toString puede tener un for para que imprima todo
      //  return String.format(format, args)
	/*
        return String.format("%10d %15s %10d %8d %10.2f %10d", cod, this.getDesc(), this.getPsi(), this.getIva(),
	                     this.getPci(), this.stock);
    */