/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class Clinica extends EstablecimientoSalud implements Serializable{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private int nroAmbulancias, nroPisos;
    private Piso [] pisos = new Piso[20];

    public int getNroAmbulancias() {
        return nroAmbulancias;
    }

    public void setNroAmbulancias(int nroAmbulancias) {
        this.nroAmbulancias = nroAmbulancias;
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
    
    public Clinica()
    {
        super();
        nroAmbulancias=0;
        nroPisos=0;
        for(int i=1;i<=nroPisos;i++)
        {
            pisos[i]= new Piso();
        }
    }
    
    public Clinica(String n, String u, String t, String ni, String h, int nra, int nrp)
    {
        super(n,u,t,ni,h);
        nroAmbulancias=nra;
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
        System.out.println("N# Ambulancias: ");
        nroAmbulancias=Leer.datoInt();
        System.out.println("N# Pisos: ");
        nroPisos=Leer.datoInt();
        for (int i=1;i<=nroPisos;i++)
        {
            pisos[i]=new Piso();
            pisos[i].leer();
        }
    }
    
    public void mostrar()
    {
        System.out.println("///////////CLINICA/////////////");
        super.mostrar();
        System.out.println("ID: "+id);
        System.out.println("N# de Ambulancias: "+nroAmbulancias);
        System.out.println("N# de Pisos: "+nroPisos);
        System.out.println("----------PISOS-------------");
        for (int i=1;i<=nroPisos;i++)
        {
            System.out.println("Piso "+i);
            pisos[i].mostrar();
        }
        System.out.println("-----------------------------");
    }
}
