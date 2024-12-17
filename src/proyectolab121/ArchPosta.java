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

public class ArchPosta {
    private String nombre;
    private Posta posta;
    
    public ArchPosta(String nom)
    {
        nombre=nom;
    }
    
    public void crear() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aP = new ObjectOutputStream(new FileOutputStream(nombre,true));
        System.out.println("ARCHIVO CREADO");
        aP.close();
    }
    public void adicionar() throws ClassNotFoundException, IOException
    {
        ObjectOutputStream aP = null;
        try{
            if(!(new File(nombre).exists())){
               aP = new ObjectOutputStream(new FileOutputStream(nombre,true));
            }else{
               aP = new AddObjectOutputStream(new FileOutputStream(nombre,true));
            }
            String op;
            do {
                posta = new Posta();
                posta.leer();
                aP.writeObject(posta);
                
                System.out.println("*\n Desea adicionar mas Postas S/N?");
                op = Leer.dato();
            }while(op.equals("S") || op.equals("s"));
        }catch(Exception e){
            System.out.println("!!!ERROR EN LA ADICION¡¡¡");
        } finally {
            aP.close();
        }
    }
    public void listar() throws ClassNotFoundException, IOException
    {
        ObjectInputStream aP = null;
        try{
            aP = new ObjectInputStream(new FileInputStream(nombre));
            while(true){
                posta = new Posta();
                posta = (Posta) aP.readObject();
                posta.mostrar();
                System.out.println("-----------------------------");
            }
        } catch (Exception e){
            System.out.println("FIN DEL LISTADO");
        } finally {
            aP.close();
        }
        
    }
    public void eliminar(String id) throws ClassNotFoundException, IOException
    {
        ObjectInputStream aP = null;
        ObjectOutputStream copia = null;
        try{
            aP = new ObjectInputStream(new FileInputStream(nombre));
            copia = new ObjectOutputStream(new FileOutputStream("Copia.dat",true));
            
            while(true){
                posta = new Posta();
                posta = (Posta) aP.readObject();
                
                if(!posta.getId().equals(id)){
                    copia.writeObject(posta);
                }
            }
        }catch(Exception e){
            System.out.println("ELIMINADO");
        }finally{
            copia.close();
            aP.close();
            File f1 = new File(nombre);
            File f2 = new File("Copia.dat");
            f1.delete();
            f2.renameTo(f1);
        }
    }
}
