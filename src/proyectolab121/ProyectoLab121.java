/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolab121;

import java.io.IOException;
import java.util.Scanner;

public class ProyectoLab121 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
        Scanner sc = new Scanner(System.in);
       
        ArchHospital aH = new ArchHospital("Hospitales.dat");
        ArchCentroSalud aC = new ArchCentroSalud("CentrosSalud.dat");
        ArchClinica aCl= new ArchClinica("Clinicas.dat");
        ArchFarmacia aF= new ArchFarmacia("Farmacias.dat");
        ArchPosta aP=new ArchPosta("Postas.dat");
        ArchUnidadMovil aU=new ArchUnidadMovil("UnidadesMoviles.dat");
        String op;
        do{
            System.out.println("    MENU    ");
            System.out.println("*\n1. CREAR ARCHIVO DE HOSPITALES");
            System.out.println("*\n2. ADICIONAR ARCHIVO HOSPITAL ");
            System.out.println("*\n3. LISTAR HOSPITALES");
            System.out.println("*\n4. ELIMINAR HOSPITALES\n");
            System.out.println("*\n5. CREAR ARCHIVO DE CENTROS DE SALUD");
            System.out.println("*\n6. ADICIONAR ARCHIVO CENTROS DE SALUD ");
            System.out.println("*\n7. LISTAR CENTROS DE SALUD");
            System.out.println("*\n8. ELIMINAR CENTROS DE SALUD\n");
            System.out.println("*\n9. CREAR ARCHIVO DE CLINICAS");
            System.out.println("*\n10. ADICIONAR ARCHIVO CLINICAS ");
            System.out.println("*\n11. LISTAR CLINICAS");
            System.out.println("*\n12. ELIMINAR CLINICAS\n");
            System.out.println("*\n13. CREAR ARCHIVO DE FARMACIAS");
            System.out.println("*\n14. ADICIONAR ARCHIVO FARMACIAS ");
            System.out.println("*\n15. LISTAR FARMACIAS");
            System.out.println("*\n16. ELIMINAR FARMACIAS\n");
            System.out.println("*\n17. CREAR ARCHIVO DE POSTAS");
            System.out.println("*\n18. ADICIONAR ARCHIVO POSTAS ");
            System.out.println("*\n19. LISTAR POSTAS");
            System.out.println("*\n20. ELIMINAR POSTAS\n");
            System.out.println("*\n21. CREAR ARCHIVO DE UNIDADES MOVILES");
            System.out.println("*\n22. ADICIONAR ARCHIVO UNIDADES MOVILES ");
            System.out.println("*\n23. LISTAR UNIDADES MOVILES");
            System.out.println("*\n24. ELIMINAR UNIDADES MOVILES");
            System.out.println("*\n0. SALIR");
            op = sc.next();
            switch(op){
                case "1":
                    aH.crear();
                    break;
                case "2":
                    aH.adicionar();
                    break;
                case "3":
                    aH.listar();
                    break;
                case "4":
                    System.out.println("ID a Eliminar: ");
                    String elimID = sc.next();
                    aH.eliminar(elimID);
                    break;
                    
                case "5":
                    aC.crear();
                    break;
                case "6":
                    aC.adicionar();
                    break;
                case "7":
                    aC.listar();
                    break;
                case "8":
                    System.out.println("ID a Eliminar: ");
                    String elimIDC = sc.next();
                    aC.eliminar(elimIDC);
                    break;
                    
                case "9":
                    aCl.crear();
                    break;
                case "10":
                    aCl.adicionar();
                    break;
                case "11":
                    aCl.listar();
                    break;
                case "12":
                    System.out.println("ID a Eliminar: ");
                    String elimIDCl = sc.next();
                    aCl.eliminar(elimIDCl);
                    break;
                    
                case "13":
                    aF.crear();
                    break;
                case "14":
                    aF.adicionar();
                    break;
                case "15":
                    aF.listar();
                    break;
                case "16":
                    System.out.println("ID a Eliminar: ");
                    String elimIDF = sc.next();
                    aF.eliminar(elimIDF);
                    break;
                    
                case "17":
                    aP.crear();
                    break;
                case "18":
                    aP.adicionar();
                    break;
                case "19":
                    aP.listar();
                    break;
                case "20":
                    System.out.println("ID a Eliminar: ");
                    String elimIDP = sc.next();
                    aP.eliminar(elimIDP);
                    break;
                    
                case "21":
                    aU.crear();
                    break;
                case "22":
                    aU.adicionar();
                    break;
                case "23":
                    aU.listar();
                    break;
                case "24":
                    System.out.println("ID a Eliminar: ");
                    String elimIDU = sc.next();
                    aU.eliminar(elimIDU);
                    break;
                default:
                    break;
            }
        }while(!op.equals("0"));
    
    }
    
}
