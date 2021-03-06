package gestorProductos;

import gestor.Gestor;

public class GestionProductos extends Gestor<ProductoStock> {
	
	public GestionProductos(){
		super();
	}
	
	public ProductoStock busqueda(String nombre){
		for (ProductoStock p: gest){
			if(p.getDesc().equals(nombre) && !p.esBaja())
				return p; 
			}
		return null;
		}
	}

