/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class Posta extends EstablecimientoSalud implements Serializable{
    private int nroCuartos, nroenfr;
    private String duracion, tratamiento,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Posta()
    {
        super();
        nroCuartos=0;
        nroenfr=0;
        duracion="";
    }
    
    public Posta(String n, String u, String t, String ni, String h, int nrc,int nre, String d, String tr)
    {
        super(n,u,t,ni,h);
        nroCuartos=nrc;
        nroenfr=nre;
        duracion=d;
        tratamiento=tr;
    }
    
    public void mostrar()
    {
        System.out.println("/////////////POSTA//////////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("N# Cuartos: "+nroCuartos);
        System.out.println("N# Enfermeros: "+nroenfr);
        System.out.println("Duracion de la Estadia: "+duracion);
        System.out.println("Tipo de Tratamiento: "+tratamiento);
        
    }
    
    public void leer()
    {
        super.leer();
        System.out.println("ID: ");
        id=Leer.dato();
        System.out.println("N# Cuartos: ");
        nroCuartos=Leer.datoInt();
        System.out.println("N# Enfermeros: ");
        nroenfr=Leer.datoInt();
        System.out.println("Duracion de la Estadia: ");
        duracion=Leer.dato();
        System.out.println("Tipo de Tratamiento: ");
        tratamiento=Leer.dato();
    }
}
