/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;
import java.io.Serializable;

public class CentroSalud extends EstablecimientoSalud implements Serializable{
    private int nroCuartos;
    private String vacunacion,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public CentroSalud()
    {
        super();
        nroCuartos=0;
        vacunacion="";
    }
    public CentroSalud(String n, String u, String t, String ni,String h,int nrc, String v)
    {
        super(n,u,t,ni,h);
        nroCuartos=nrc;
        vacunacion=v;
    }
    
    public void leer()
    {
        super.leer();
        System.out.println("ID: ");
        id=Leer.dato();
        System.out.println("N# Cuartos: ");
        nroCuartos=Leer.datoInt();
        System.out.println("Vacunacion?: ");
        vacunacion=Leer.dato();
    }
    
    public void mostrar()
    {
        System.out.println("////////CENTRO DE SALUD/////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("N# Cuartos: "+nroCuartos);
        System.out.println(vacunacion+" tiene vacunacion");
    }
    
}
