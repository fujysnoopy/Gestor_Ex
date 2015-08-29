//package tpv_ex_v05;

import java.util.HashSet;



public class Gestor<E> implements java.io.Serializable{
	
	protected HashSet<E> gest;
    private static final long serialVersionUID = 1L;
	
	public Gestor(){
		gest = new HashSet<>();
	}
	
	public boolean alta(E element){
		return gest.add(element);
	}
	
	public E busqueda(int cod){
		if(gest.size()!=0) {
            for (E element : gest) {
                if (element instanceof ProductoStock) {
                    if (cod == ((ProductoStock) element).getCod()) {
                        //if(cod==(new ProductoStock()).getCod()){
                        //System.out.println("cod producto encontrado");
                        return element;
                    }
                } else if (cod == ((Cliente) element).getCod()) {
                    //System.out.println("cod cliente encontrado");
                    return element;
                }
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

	public boolean baja(int cod) {
        E e = busqueda(cod);
        if (e != null) {
            if (e instanceof ProductoStock) {
                return ((ProductoStock) e).setBaja();
            } else {
                return ((Cliente) e).setBaja();
            }
        }

	return false;
	}

	public void importar(String fichero){
		
	}
	
	public void exportar(String fichero){
		
	}
		
	
}
