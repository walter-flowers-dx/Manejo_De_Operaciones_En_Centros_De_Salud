/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class UnidadMovil extends EstablecimientoSalud implements Serializable{
    private String modelo, duracion, vacunacion, color,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private int nroenfr;
    
    public UnidadMovil()
    {
        super();
        modelo="";
        duracion="";
        vacunacion="";
        color="";
        nroenfr=0;
    }
    
    public UnidadMovil(String n, String u, String t, String ni, String h,String m, String d, String v, String c,int nre)
    {
        super(n,u,t,ni,h);
        modelo=m;
        duracion=d;
        vacunacion=v;
        color=c;
        nroenfr=nre;
    }
    
    public void leer()
    {
        super.leer();
        System.out.println("ID: ");
        id=Leer.dato();
        System.out.println("Modelo del Vehiculo: ");
        modelo=Leer.dato();
        System.out.println("Duracion de la estadia: ");
        duracion=Leer.dato();
        System.out.println("Vacunacion: ");
        vacunacion=Leer.dato();
        System.out.println("Color: ");
        color=Leer.dato();
        System.out.println("N# Enfermeros: ");
        nroenfr=Leer.datoInt();
    }
    
    public void mostrar()
    {
        System.out.println("/////////////UNIDAD MOVIL/////////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("Modelo del Vehiculo: "+modelo);
        System.out.println("Duracion de la estadia: "+duracion);
        System.out.println(vacunacion+" tiene Vacunacion");
        System.out.println("Color: "+color);
        System.out.println("N# Enfermeros: "+nroenfr);
    }
    
}
