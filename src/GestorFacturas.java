//package tpv_ex_v05;

import java.util.HashSet;
import java.util.ArrayList;

public class GestorFacturas {
	private HashSet<Factura> facturas;
	
	public GestorFacturas(){
		facturas = new HashSet<>();
	}

    /*********************************************************************************************
     * 
     * @param c
     * @param ventas
     * @param fecha
     * @return
     */
    public Factura generarFactura(Cliente c, ArrayList<Venta> ventas, String anoFiscal){
        ArrayList<Venta> ventasFact = null;
        boolean sw = false;
        
        for (Venta v : ventas) {
           // if (v.getId().substring(0, 4).contains(anoFiscal)) {
            System.out.println(v.getId().substring(0, 4));
            
            //String subcadena = v.getId().substring(0, 4);
              if (v.getId().substring(0, 4).equals(anoFiscal)) {
                if (sw == false) {
                    ventasFact = new ArrayList<Venta>();
                    sw = true;
                }
                ventasFact.add(v);
            }
        }
        
        if (sw == true) {
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


