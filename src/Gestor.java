//package tpv_ex_v05;

import java.util.HashSet;



public class Gestor<E> {
	
	protected HashSet<E> gest;
	
	public Gestor(){
		gest = new HashSet<E>();	
	}
	
	public void alta(E element){
		gest.add(element);
	}
	
	public E busqueda(int cod){
		
		for(E element:gest){	
			if (element instanceof ProductoStock){
				if(cod==((ProductoStock) element).getCod()){
				//if(cod==(new ProductoStock()).getCod()){
					//System.out.println("cod producto encontrado");
					return element;
				}
			}else if(cod==((Cliente) element).getCod()){
				//System.out.println("cod cliente encontrado");
					return element;	
		}
	}
		return null;
	}
	
	public boolean modificar (int cod, E element){
		E e = busqueda(cod);
		if(e!=null){
			gest.remove(e);
			return gest.add(element);
		}
	 return false;		
	}
	
	public void importar(String fichero){
		
	}
	
	public void exportar(String fichero){
		
	}
		
	
}
