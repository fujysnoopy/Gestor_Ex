//package tpv_ex_v05;

public class ProductoVenta {
	
	private int id;
	private float importeTotal;
	private ProductoStock ps;
	private int unidades;
	
	public ProductoVenta(int unidades, ProductoStock ps){
		
		this.ps=ps;
		this.unidades=unidades;
		importeTotal=unidades*ps.getPci();
		id=this.ps.getCod();  ////////////////// que pasa aqui
	}
	
	public String toString(){
		System.out.println("      COD.        DESC.        UND.     PUCI     IVA     IMP.TOTAL   ");
	    return String.format("%8d %15s %8d %10d %8d %8d" , this.ps.getCod(), this.ps.getDesc(), this.unidades, this.ps.getPci(), this.ps.getIva(), this.importeTotal);
	}
	
	
}
