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

public class ArchUnidadMovil {
    private String nombre;
    private UnidadMovil unidadmovil;
    
    public ArchUnidadMovil(String nom)
    {
        nombre=nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aU = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aU.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aU = null;
        try{
            if(!(new File(nombre).exists())){
               aU = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aU = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                unidadmovil = new UnidadMovil();
                unidadmovil.leer();
                aU.writeObject(unidadmovil);
                
                System.out.println("*\n Desea adicionar mas Unidades Moviles S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aU.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aU = null;
        try{
            aU = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                unidadmovil = new UnidadMovil();
                unidadmovil = (UnidadMovil) aU.readObject();
                unidadmovil.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aU.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aU = null;
        ObjectOutputStream copia = null;
        try{
            aU = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                unidadmovil = new UnidadMovil();
                unidadmovil = (UnidadMovil) aU.readObject();
                
                if(!unidadmovil.getId().equals(id)){
                    copia.writeObject(unidadmovil);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aU.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
}
