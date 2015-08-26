//package tpv_ex_v05;

import java.util.Date;


public class Cliente {
    private String NIF;
    private String apellidos;
    private String domicilio;
    private Date fechaAlta;
    private int id;
    private String nombre;
    private String razonSocial;

    /**
     *   Se debe implementar un constructor sin parámetros
     */
    public Cliente() {

    }

    /**
     * @param NIF
     * @param apellidos
     * @param domicilio
     * @param fechaAlta
     * @param id
     * @param nombre
     * @param razonSocial
     */
    public Cliente(String NIF, String apellidos, String domicilio, Date fechaAlta, int id, String nombre,
                   String razonSocial) {
        this.NIF = NIF;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;

    }

    public int getCod() {
        return id;
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
