//package tpv_ex_v05;

public class Producto {

    private int cod;
    private int psi, iva;
    private float pci;
    private String desc;


    public Producto() {

    }

    public Producto(String desc, int psi, int iva) {
        this.desc = desc;
        this.psi = psi;
        this.iva = iva;
        cod = getUID();
        pci = calculaPCI(psi, iva);

    }


    public String getDesc() {
        return desc;
    }

    public int getCod() {
        return cod;
    }

    public int getPsi() {
        return psi;
    }

    public int getIva() {
        return iva;
    }

    public float getPci() {
        return pci;
    }

    private static int getUID() {
        return (int) (Math.random() * 100000);
    }

    private static float calculaPCI(int psi, int iva) {
        return psi + ((psi * iva) / 100);
    }
}
