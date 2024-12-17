/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class Piso implements Serializable{
    private int nroCuartos,nroCamas;
    
    public Piso()
    {
        nroCuartos=1;
        nroCamas=0;
    }
    
    public void leer()
    {
        System.out.println("Numero de Cuartos: ");
        nroCuartos=Leer.datoInt();
        System.out.println("Numero de Camas: ");
        nroCamas=Leer.datoInt();
    }
    
    public void mostrar()
    {
        System.out.println("Numero de Cuartos: "+nroCuartos);
        System.out.println("Numero de Camas: "+nroCamas);
    }
}
