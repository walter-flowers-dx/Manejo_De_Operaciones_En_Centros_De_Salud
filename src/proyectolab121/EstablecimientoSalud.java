/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.Serializable;

public class EstablecimientoSalud implements Serializable{
    private String nombre, ubicacion, telefono, nivel, horario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNivel() {
        return nivel;
    }

    public void setZona(String nivel) {
        this.nivel = nivel;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public EstablecimientoSalud()
    {
        nombre="";
        ubicacion="";
        telefono="";
        nivel="";
        horario="7 a 12";
    }
    public EstablecimientoSalud(String n, String u, String t, String ni, String h)
    {
        nombre=n;
        ubicacion=u;
        telefono=t;
        nivel=ni;
        horario=h;
    }
    
    public void leer()
    {
        System.out.println("Nombre: ");
        nombre=Leer.dato();
        System.out.println("Ubicacion: ");
        ubicacion=Leer.dato();
        System.out.println("Telefono: ");
        telefono=Leer.dato();
        System.out.println("Nivel: ");
        nivel=Leer.dato();
        System.out.println("Horarios: ");
        horario=Leer.dato();
    }
    
    public void mostrar()
    {
        System.out.println("###########################");
        System.out.println("Nombre: "+nombre);
        System.out.println("Ubicacion: "+ubicacion);
        System.out.println("Telefono: "+telefono);
        System.out.println("Nivel: "+nivel);
        System.out.println("Horarios: "+horario);
        System.out.println("###########################");
    }
    
    
    
    
}
