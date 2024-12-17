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

public class ArchCentroSalud implements Serializable {
    private String nombre;
    private CentroSalud centrosalud;
    
    public ArchCentroSalud(String nom){
        nombre= nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aC = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aC.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aC = null;
        try{
            if(!(new File(nombre).exists())){
               aC = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aC = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                centrosalud = new CentroSalud();
                centrosalud.leer();
                aC.writeObject(centrosalud);
                
                System.out.println("*\n Desea adicionar mas Centros de Salud S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aC.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aC = null;
        try{
            aC = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                centrosalud = new CentroSalud();
                centrosalud = (CentroSalud) aC.readObject();
                centrosalud.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aC.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aC = null;
        ObjectOutputStream copia = null;
        try{
            aC = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                centrosalud = new CentroSalud();
                centrosalud = (CentroSalud) aC.readObject();
                
                if(!centrosalud.getId().equals(id)){
                    copia.writeObject(centrosalud);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aC.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
}
