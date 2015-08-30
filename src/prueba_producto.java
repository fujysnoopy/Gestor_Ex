//package tpv_ex_v05;

import gestorClientes.Cliente;
import gestorClientes.GestionCliente;
import gestorFacturacion.Factura;
import gestorFacturacion.GestorFacturas;
import gestorProductos.GestionProductos;
import gestorProductos.ProductoStock;
import gestorVentas.GestionVenta;
import gestorVentas.Venta;
import org.junit.Test;

import java.util.ArrayList;

public class prueba_producto {

    private ProductoStock p1, p2, p3, p4, pb1, pb2;
    private GestionProductos gp;
    private GestionCliente gc;
    private Cliente c,c2,c3, clienteBuscado;
    private Venta v,v2,v3,v4;
    private Factura f;
    private GestionVenta gv;
    private GestorFacturas gf;

    public prueba_producto() {

    }


    @Test
    public void inicializaTPV(){

        gc = new GestionCliente();
        gp = new GestionProductos();
        gv = new GestionVenta();
        gf = new GestorFacturas();

        System.out.println("---> tpv.TPV Inicializado");


        this.crearGestProd();
        //this.buscarProducto();
        this.clienteVenta();
        //this.gestorClientes();
        // this.gestorVenta();
        // this.gestorFacturas();
        this.listados();
    }

    public void crearGestProd() {

        System.out.println("..... Iniciando Creación de Productos");
        // (desc,psi,iva,stock)

        p1 = new ProductoStock("Producto_1", 100, 21, 10);
        p2 = new ProductoStock("Producto_2", 200, 21, 9);
        p3 = new ProductoStock("Producto_3", 300, 16, 8);
        p4 = new ProductoStock("Producto_4", 3400, 16, 7);

        System.out.println("      COD.         DESC.         PSI       IVA       PCI        STOCK   ");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        gp.alta(p1);
        gp.alta(p2);
        gp.alta(p3);
        gp.alta(p4);

    }


    public void buscarProducto() {
        System.out.println("      COD.         DESC.         PSI       IVA       PCI        STOCK   ");
        pb1 = gp.busqueda(1);
        System.out.println(pb1);

        pb2 = gp.busqueda(2);
        System.out.println(pb2);
    }

    /**
     * 1- Crear cliente
     * 2- Añadir venta.
     */
    public void clienteVenta()  {

  //  try {


        System.out.println("- Crea Clientes");
        c = new Cliente("71515029w", "Jimenez Rey", "Golfo Salonica", "Igor", "razon");
       // Thread.sleep(5000);
        c2 = new Cliente("71515030w", "HSH1", "Golfo Salonica", "Igor", "razon");
       // Thread.sleep(5000);
        c3 = new Cliente("71515031w", "HSH2", "Golfo Salonica", "Igor", "razon");
/*
    } catch (InterruptedException e) {
            e.printStackTrace();
    }

*/



        System.out.println("- Alta Clientes en GC");
        gc.alta(c);
        gc.alta(c2);
        gc.alta(c3);

        System.out.println("- Crea objetos Ventas de cliente");
        v = new Venta(c);
        v2 = new Venta(c2);
        v3 = new Venta(c2);
        v4 = new Venta(c2);

        System.out.println("- Añadir productos a ventas de clientes");
        //cliente c
        v.altaProductoVenta(1, gp.busqueda(p1.getCod()));
        v.altaProductoVenta(2, gp.busqueda(p2.getCod()));
        //gestorClientes.Cliente c2
        v2.altaProductoVenta(1, gp.busqueda(p3.getCod()));
        v3.altaProductoVenta(1, gp.busqueda(p3.getCod()));
        v3.altaProductoVenta(1, gp.busqueda(p4.getCod()));
        v4.altaProductoVenta(1, gp.busqueda(p4.getCod()));

        System.out.println("- Alta Ventas en GV");
        gv.anadirVenta(c, v);
        gv.anadirVenta(c2, v2);
        gv.anadirVenta(c2, v3);
        gv.anadirVenta(c2,v4);


    }


    /**
 * 1- Inicializa gestor.Gestor de Clientes
 * 2- Añade gestorClientes.Cliente a la lista de clients
 * 3- Busca el gestorClientes.Cliente creado en la lista
 */
    public void gestorClientes() {

        System.out.println(".....Creando gestor.Gestor de Clientes");
        gc = new GestionCliente();
        System.out.println("Añadiendo cliente al gestor de clientes");
        gc.alta(c);
        System.out.println("Cod. gestorClientes.Cliente: " + c.getCod());
        if (gc.busqueda(123) != null) {
            System.out.println("gestorClientes.Cliente encontrado");
            clienteBuscado = gc.busqueda(123);
            System.out.println(clienteBuscado);
        }
    }

    /**
     * 1- Inicializa gestor de ventas
     * 2- Añade el gestorClientes.Cliente y su gestorVentas.Venta al gestor.Gestor de ventas
     */
    public void gestorVenta() {
        System.out.println("---> Creando gestor.Gestor de Ventas");
        gv = new GestionVenta();
        System.out.println("Añadiend	o cliente y venta al gestor");
        gv.anadirVenta(c, v);

    }
 /**
 * 1-Busca Ventas del gestorClientes.Cliente en el GestorVentas
 * 2-Crea factura con gestorClientes.Cliente y sus Ventas
 */
    public void gestorFacturas() {
        System.out.println("---> Iniciando gestor.Gestor de Facturas");
        if (gv.buscarVentas(clienteBuscado))
            System.out.println("Obteniendo Ventas de cliente");

        ArrayList<Venta> hh= gv.ventasCliente(clienteBuscado);
        f = new Factura(clienteBuscado, hh);
        gf = new GestorFacturas();
        Factura fact = gf.generarFactura(clienteBuscado, hh, "2015");
        if(fact!=null){
            System.out.println("Creada factura cliente");

            System.out.println(c);
            System.out.println(f);
            
        }
            
        
    }

    public void listados(){
        System.out.println("- Entrando en listados de ventas");
        ArrayList<Venta> listadoVenta =    gv.listadoVentasTiempo(20150101, 20151212);
       // System.out.println("Tam. litadoVentasTiempo: ", listadoVenta.size());
        ArrayList<Venta> listadoVentaCliente = gv.listadoVentasTiempoCliente(c2,20150101, 20151212);
       // System.out.println("Tam. litadoVentasTiempoCliente: ", listadoVentaCliente.size());
    }
}
