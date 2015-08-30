package gestorProductos;


public class ProductoStock extends Producto {

    private int stock;
    private boolean baja;


    public ProductoStock(String desc, int psi, int iva, int stock) {
        super(desc, psi, iva);
        this.stock = stock;
        baja = false;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean setBaja(){ return baja=true; }

    public int getStock() {
        return stock;
    }

    public boolean esBaja(){
        return baja;
    }

    public String toString() {
        //	       ("COD DE PRODUCTO         DESCRIPCION          PRECIO SIN IVA            IVA            PRECIO CON IVA             STOCK           ")
        //	return String.format(" " + this.cod + "     " + this.desc + "     " + this.psi + "     " + this.iva + "     " + this.pci + "     " + this.stock);
        return String.format("%10d %15s %10d %8d %10.2f %10d", this.getCod(), this.getDesc(), this.getPsi(), this.getIva(),
                             this.getPci(), this.stock);
    }


}
