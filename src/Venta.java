//package tpv_ex_v05;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


public class Venta {

    private Cliente cliente;
    private String id;
    private ArrayList<ProductoVenta> lp;
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    private float importeVenta;

    /**
     * @param c
     */
    public Venta(Cliente c) {
        id = DATE_TIME_FORMAT.format(new Date()); //Aquí hay q crear id venta
        cliente = c;
        lp = new ArrayList<ProductoVenta>();
        importeVenta = 0;
    }

    /**
     * Añade producto a la venta del cliente
     *
     * @param unidades
     * @param producto
     * @return
     */
    public boolean altaProductoVenta(int unidades, ProductoStock producto) {
        if (unidades <= producto.getStock()) { // Compruebo realmente hay stock
            lp.add(new ProductoVenta(unidades, producto));
            producto.setStock(producto.getStock() - unidades); //Establezco nuevo stock
            importeVenta = importeVenta + (unidades * producto.getPci());
            //System.out.println(this.getId());
            return true;
        }
        return false;
    }

    public ArrayList<ProductoVenta> listaProductosVenta() {
        return this.lp;
    }

    public String getId() {
        return id;
    }

    public String toString(){
        return String.format("ID Venta: %12s Cod.Cliente: %d Tam.Lista: %d", this.id, cliente.getCod(), lp.size());
    }
}
