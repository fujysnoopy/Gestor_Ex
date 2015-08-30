package gestorFacturacion;//package tpv_ex_v05;

import gestorClientes.Cliente;
import gestorVentas.Venta;

import java.util.ArrayList;
import java.util.HashSet;

public class GestorFacturas {
	private HashSet<Factura> facturas;
	
	public GestorFacturas(){
		facturas = new HashSet<>();
	}

    public Factura generarFactura(Cliente c, ArrayList<Venta> ventas, String anoFiscal){
        ArrayList<Venta> ventasFact = null;
        boolean sw = false;
        
        for (Venta v : ventas) {
           // if (v.getId().substring(0, 4).contains(anoFiscal)) {
            System.out.println(v.getId().substring(0, 4));
            
            //String subcadena = v.getId().substring(0, 4);
              if (v.getId().substring(0, 4).equals(anoFiscal)) {
                if (!sw) {
                    ventasFact = new ArrayList<>();
                    sw = true;
                }
                ventasFact.add(v);
            }
        }
        
        if (sw) {
            Factura fact=new Factura(c, ventasFact);
            facturas.add(fact);
            return fact;
        }
    return null;
    }
    
    public Factura buscarFactura(int facturaID){
        if (facturas.size()!=0){
         for(Factura f:facturas){
           if(f.getFacturaID()==facturaID)
            return f;
            }
        }
        return null;
    }
}


	
	/*
         
        
    public void importar(String fichero){
		
	}
	
    public void exportar(String fichero){
		
	}
	*/


