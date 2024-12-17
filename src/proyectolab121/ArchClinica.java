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

public class ArchClinica {
    private String nombre;
    private Clinica clinica;
    
    public ArchClinica(String nom)
    {
        nombre= nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aCl = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aCl.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aCl = null;
        try{
            if(!(new File(nombre).exists())){
               aCl = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aCl = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                clinica = new Clinica();
                clinica.leer();
                aCl.writeObject(clinica);
                
                System.out.println("*\n Desea adicionar mas Clinicas S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aCl.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aCl = null;
        try{
            aCl = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                clinica = new Clinica();
                clinica = (Clinica) aCl.readObject();
                clinica.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aCl.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aCl = null;
        ObjectOutputStream copia = null;
        try{
            aCl = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                clinica = new Clinica();
                clinica = (Clinica) aCl.readObject();
                
                if(!clinica.getId().equals(id)){
                    copia.writeObject(clinica);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aCl.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
}
