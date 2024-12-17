/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;


public class Farmacia extends EstablecimientoSalud implements Serializable{
    private String cadena, delivery,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private int nroSucursales;
    
    public Farmacia()
    {
        super();
        cadena="";
        delivery="";
        nroSucursales=0;
    }
    
    public Farmacia(String n, String u, String t, String ni, String h, String c, String d, int nrs)
    {
        super(n,u,t,ni,h);
        cadena=c;
        delivery=d;
        nroSucursales=nrs;
    }
    
    public void leer()
    {
        super.leer();
        System.out.println("ID: ");
        id=Leer.dato();
        System.out.println("Cadena: ");
        cadena=Leer.dato();
        System.out.println("Delivery?: ");
        delivery=Leer.dato();
        System.out.println("N# Sucursales: ");
        nroSucursales=Leer.datoInt();
    }
    
    public void mostrar()
    {
        System.out.println("///////////FARMACIA/////////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("Cadena: "+cadena); 
        System.out.println(delivery+" tiene Delivery");
        System.out.println("N# Sucursales: "+nroSucursales);
    }
}
