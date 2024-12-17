/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class Hospital extends EstablecimientoSalud implements Serializable{
    private String financiamiento,id;
    private int nroambulancias,nroPisos;
    private Piso [] pisos = new Piso[20];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public int getNroambulancias() {
        return nroambulancias;
    }

    public void setNroambulancias(int nroambulancias) {
        this.nroambulancias = nroambulancias;
    }

    public int getNroPisos() {
        return nroPisos;
    }

    public void setNroPisos(int nroPisos) {
        this.nroPisos = nroPisos;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }
    
    
    public Hospital()
    {
        super();
        financiamiento="";
        nroambulancias=0;
        nroPisos=1;
        for(int i=1;i<=nroPisos;i++)
        {
            pisos[i]= new Piso();
        }
    }
    
    public Hospital(String n, String u, String t, String ni, String h,String f, int nra, int nrp)
    {
        super(n,u,t,ni,h);
        financiamiento=f;
        nroambulancias=nra;
        nroPisos=nrp;
        for(int i=1;i<=nroPisos;i++)
        {
            pisos[i]= new Piso();
        }
    }
    
    public void leer()
    {
        super.leer();
        System.out.println("ID: ");
        id=Leer.dato();
        System.out.println("Financiamiento: ");
        financiamiento=Leer.dato();
        System.out.println("N# Ambulancias: ");
        nroambulancias=Leer.datoInt();
        System.out.println("N# Pisos: ");
        nroPisos=Leer.datoInt();
        for(int i=1;i<=nroPisos;i++)
        {
            pisos[i] = new Piso();
            System.out.println("Piso "+i);
            pisos[i].leer();
        }
    }
    
    public void mostrar()
    {
        System.out.println("///////////HOSPITAL/////////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("Financiamiento: "+financiamiento);
        System.out.println("Cuenta con :"+nroambulancias+" Ambulancias");
        System.out.println("cuenta con: "+nroPisos+" Pisos");
        System.out.println("----------PISOS-------------");
        for (int i=1;i<=nroPisos;i++)
        {
            System.out.println("Piso "+i);
            pisos[i].mostrar();
        }
        System.out.println("-----------------------------");
    }
    
}
