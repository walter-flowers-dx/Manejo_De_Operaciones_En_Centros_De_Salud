/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ArchHospital implements Serializable{
    private String nombre;
    private Hospital hospital;
    
    public ArchHospital(String nom)
    {
        nombre=nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aH = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aH.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aH = null;
        try{
            if(!(new File(nombre).exists())){
               aH = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aH = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                hospital = new Hospital();
                hospital.leer();
                aH.writeObject(hospital);
                
                System.out.println("*\n Desea adicionar mas Hospitales S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aH.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aH = null;
        try{
            aH = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                hospital = new Hospital();
                hospital = (Hospital) aH.readObject();
                hospital.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aH.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aH = null;
        ObjectOutputStream copia = null;
        try{
            aH = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                hospital = new Hospital();
                hospital = (Hospital) aH.readObject();
                
                if(!hospital.getId().equals(id)){
                    copia.writeObject(hospital);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aH.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
    
    
}
