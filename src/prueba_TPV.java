import gestorProductos.ProductoStock;
import org.junit.Test;
import tpv.TPV;

/**
 * Created by ras on 30/8/15.
 */


public class prueba_TPV {

    private ProductoStock p1, p2, p3, p4, pb1, pb2;

    @Test
    public void TPV(){
        TPV tpv = TPV.getTPV();

        p1 = new ProductoStock("Producto_1", 100, 21, 10);
        p2 = new ProductoStock("Producto_2", 200, 21, 9);
        p3 = new ProductoStock("Producto_3", 300, 16, 8);
        p4 = new ProductoStock("Producto_4", 3400, 16, 7);


        tpv.altaProducto(p1);
        pb1=tpv.busquedaProducto(p1.getCod());
        System.out.println(pb1);

    }
}
