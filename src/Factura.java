//package tpv_ex_v05;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class Factura implements java.io.Serializable {
    private static final long serialVersionUID=1L;
    private Cliente cliente;
    private String fechaEmision;
    private float importeTotal;
    private int numFactura;
    private ArrayList<Venta> ventas;
    
    private static  SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");


    public Factura(Cliente c, ArrayList<Venta> lvf) {
        cliente = c;
        ventas = lvf;
        fechaEmision = DATE_FORMAT.format(new Date());
        numFactura = getUID();
        importeTotal = calcularImporte(lvf);
    }

    private int getUID(){
        return (int) Math.random()*100000;
    }
    public int getFacturaID() {
        return numFactura;
    }

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
