package gestorVentas;

import gestorClientes.Cliente;

import java.util.ArrayList;
import java.util.HashMap;

public class GestionVenta implements java.io.Serializable {

    private HashMap<Cliente, ArrayList<Venta>> gv;
    private static final long serialVersionUID = 1L;

    public GestionVenta() {
        gv = new HashMap<>();
    }


    public void anadirVenta(Cliente c, Venta v) {
        ArrayList<Venta> cVentas = null;

        if (this.buscarVentas(c)) {

            cVentas = gv.get(c);
            cVentas.add(v);
            gv.put(c,cVentas);


        } else {
            cVentas = new ArrayList<>();
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
                        if (!sw){
                            informeVentas = new ArrayList<>();
                            sw = true;
                        }
                        informeVentas.add(venta);
                        System.out.println(venta);
                        System.out.println("Pertenece!");
                    }
                }
            }
            if (sw) return informeVentas;

        }
        return null;
    }

    public ArrayList<Venta> listadoVentasTiempoCliente(Cliente cliente, int desde, int hasta) {
        if (gv.size() != 0) {
            boolean sw = false;
            ArrayList<Venta> informeVentas = null;
            if(gv.containsKey(cliente)){
                    for(Venta venta:gv.get(cliente)){
                        int fechVenta;
                        fechVenta = Integer.parseInt(venta.getId().substring(0, 8));
                        if (fechVenta >= desde && fechVenta <= hasta) {
                            if(!sw){
                                informeVentas = new ArrayList<Venta>();
                                sw=true;
                            }
                            informeVentas.add(venta);
                        }
                    }
                if (sw) return informeVentas;
            }
        }
        return null;
    }

    public void importar(String fichero) {

    }

    public void exportar(String fichero) {

    }
}
