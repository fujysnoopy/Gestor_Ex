

import java.util.ArrayList;
import java.util.HashMap;

public class GestionVenta {

    private HashMap<Cliente, ArrayList<Venta>> gv;


    public GestionVenta() {
        gv = new HashMap<Cliente, ArrayList<Venta>>();
    }


    public void anadirVenta(Cliente c, Venta v) {
        ArrayList<Venta> cVentas = null;

        if (this.buscarVentas(c)) {

            cVentas = gv.get(c);
            cVentas.add(v);
            gv.put(c,cVentas);


        } else {
            cVentas = new ArrayList<Venta>();
            cVentas.add(v);
            gv.put(c, cVentas);
            //System.out.println(gv.size());
        }
    }

    public boolean buscarVentas(Cliente c) {
        if (gv.containsKey(c))
            return true;
        return false;
    }

    public ArrayList<Venta> ventasCliente(Cliente c) {
        if (buscarVentas(c)) {

            return gv.get(c);
        }

        return null;
    }


    /**
     * Devuelve un listado con las ventas de cualquier cliente comprendidas
     * entre dos fechas (yyyyMMdd)
     *
     * @param desde
     * @param hh
     * @return
     */
    public ArrayList<Venta> listadoVentasTiempo(int desde, int hasta) {
        if (gv.size() != 0) {
            boolean sw = false;
            ArrayList<Venta> informeVentas = null;
            for (ArrayList<Venta> listaVentas : gv.values()) {
                //System.out.println(listaVentas.size());
                for (Venta venta : listaVentas) {
                    int fechVenta;
                    fechVenta = Integer.parseInt(venta.getId().substring(0, 8));
                    if (fechVenta >= desde && fechVenta <= hasta) {
                        if (sw==false){
                            informeVentas = new ArrayList<>();
                            sw = true;
                        }
                        informeVentas.add(venta);
                        System.out.println(venta);
                        System.out.println("Pertenece!");
                    }
                }
            }
            if (sw == true)
                return informeVentas;
        }
        return null;
    }

    public ArrayList<Venta> listadoVentasTiempoCliente(Cliente cliente, int desde, int hasta) {
        if (gv.size() != 0) {
            boolean sw = false;
            ArrayList<Venta> informeVentas = null;
            if(gv.containsKey(cliente)){
      //          for (ArrayList<Venta> listaVentas : gv.get(cliente)){
 //                   for(Venta ventas:listaVentas){
                        //int fechVenta;
                        //fechVenta = Integer.parseInt(venta.getId().substring(0, 8));
                       // if (fechVenta >= desde && fechVenta <= hasta) {


                        //}
   //                 }
           // }


        }

    }
        return null;
    }
/*


    private ArrayList<Venta> buscarVentasTiempo(ArrayList<Venta> listaVentas, int desde, int hasta){

            for (ArrayList<Venta> listaVentas : get(cliente)){
                for(Venta ventas:listaVentas){
                    int fechVenta;
                    fechVenta = Integer.parseInt(venta.getId().substring(0, 8));
                    if (fechVenta >= desde && fechVenta <= hasta) {


                    }
                }
            }
    }

*/
    public void importar(String fichero) {

    }

    public void exportar(String fichero) {

    }
}
