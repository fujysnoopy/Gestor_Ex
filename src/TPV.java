/**
 * Created by ras on 30/8/15.
 */
public class TPV {

    private static TPV tpv=new TPV();
    private GestionProductos gp;
    private GestionVenta gv;
    private GestionCliente gc;
    private GestorFacturas gf;


    private TPV(){
        gp = new GestionProductos();
        gv = new GestionVenta();
        gc = new GestionCliente();
        gf = new GestorFacturas();
    }

    public static TPV getTPV(){
        return tpv;
    }

    public boolean altaProducto(ProductoStock producto){
        return gp.alta(producto);
    }

    public boolean bajaProcuto(int codigo){
        return gp.baja(codigo);
    }

    public ProductoStock busquedaProducto(int codigo){
        return gp.busqueda(codigo);
    }

    public ProductoStock busquedaProducto(String descripcion){
        return gp.busqueda(descripcion);
    }

    public boolean modificarProducto(int codigo, ProductoStock producto){
        return gp.modificar(codigo, producto);
    }

    public void importarProductos(String fichero){
        gp.importar(fichero);
    }

    public void exportarProductos(String fichero){
        gp.exportar(fichero);
    }

}
