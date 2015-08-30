//package tpv_ex_v05;

import java.util.Date;


public class Cliente implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String NIF;
    private String apellidos;
    private String domicilio;
    private Date fechaAlta;
    private int id;
    private String nombre;
    private String razonSocial;
    private boolean baja;


    public Cliente(String NIF, String apellidos, String domicilio, Date fechaAlta, String nombre,
                   String razonSocial) {
        this.NIF = NIF;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.id = getUID();
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.baja= false;

    }

    public int getCod() {
        return id;
    }

    private static int getUID(){
        return (int) Math.random()*100000;
    }

    public boolean setBaja(){
        return baja=true;

    }
    public boolean esBaja(){
        return baja;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null) return false;
        if(this == obj) return true;
        if(! (obj instanceof Cliente)) return false;
        Cliente c = (Cliente) obj;
        return this.NIF==c.NIF;
    }


    @Override
    public int hashCode() {

        int result = 8;
        result = 15 * result + id;
        result = 15 * result + (NIF != null ? NIF.hashCode() : 0);
        result = 15 * result + (razonSocial != null ?razonSocial.hashCode() : 0 );

        return result;
    }

    public String toString(){
        return String.format("NIF: %s Apellidos: %s", NIF,apellidos );
    }
}
