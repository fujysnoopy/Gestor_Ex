//package tpv_ex_v05;


public class ProductoStock extends Producto {

    private int stock;
    static int serie = 0;
    private int cod;

    public ProductoStock() {
        this.stock = 0;
    }

    public ProductoStock(String desc, int psi, int iva, int stock) {
        super(desc, psi, iva);
        this.stock = stock;
        cod = ++serie;

        //System.out.println(cod);
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getCod() {
        return cod;
    }

    public String toString() {
        //	       ("COD DE PRODUCTO         DESCRIPCION          PRECIO SIN IVA            IVA            PRECIO CON IVA             STOCK           ")
        //	return String.format(" " + this.cod + "     " + this.desc + "     " + this.psi + "     " + this.iva + "     " + this.pci + "     " + this.stock);
        return String.format("%10d %15s %10d %8d %10.2f %10d", cod, this.getDesc(), this.getPsi(), this.getIva(),
                             this.getPci(), this.stock);
    }


}