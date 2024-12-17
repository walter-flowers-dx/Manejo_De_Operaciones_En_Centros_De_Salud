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

public class ArchFarmacia {
    private String nombre;
    private Farmacia farmacia;
    
    public ArchFarmacia(String nom)
    {
        nombre=nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aF = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aF.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aF = null;
        try{
            if(!(new File(nombre).exists())){
               aF = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aF = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                farmacia = new Farmacia();
                farmacia.leer();
                aF.writeObject(farmacia);
                
                System.out.println("*\n Desea adicionar mas Farmacias S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aF.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aF = null;
        try{
            aF = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                farmacia = new Farmacia();
                farmacia = (Farmacia) aF.readObject();
                farmacia.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aF.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aF = null;
        ObjectOutputStream copia = null;
        try{
            aF = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                farmacia = new Farmacia();
                farmacia = (Farmacia) aF.readObject();
                
                if(!farmacia.getId().equals(id)){
                    copia.writeObject(farmacia);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aF.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
}
