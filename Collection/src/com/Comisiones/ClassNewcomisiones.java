/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Comisiones;

import com.Modelos.ClassMdVendedor;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIOTC
 */
public class ClassNewcomisiones {
    private DecimalFormat rn = new DecimalFormat("###.##");
    private Scanner sn = new Scanner(System.in);
    private List <ClassMdVendedor> n_Vendedor = new ArrayList<ClassMdVendedor>();
    

    
    private ClassMdVendedor ingresoInformacion (){
        ClassMdVendedor vendedor = new ClassMdVendedor();
        System.out.print("Ingrese nombre: ");
        vendedor.nombre=sn.nextLine();
        System.out.print("Ingrese cantidad de enero: ");
        vendedor.enero=sn.nextDouble();
        System.out.print("Ingrese cantidad de febrero: ");
        vendedor.febrero=sn.nextDouble();
        System.out.print("Ingrese cantidad de marzo: ");
        vendedor.marzo=sn.nextDouble();
        vendedor.gran_Total=vendedor.enero+vendedor.febrero+vendedor.marzo;
        vendedor.promedio=(vendedor.enero+vendedor.febrero+vendedor.marzo)/3;
        sn.nextLine();
        
        n_Vendedor.add(vendedor);
        return vendedor;
        
    }
    
    private void desplegarDatos(){
        for (ClassMdVendedor usuario: n_Vendedor){
            System.out.println("\n_____ -- Datos del vendedor --_____");
            System.out.println("\tNombre: "+usuario.nombre);
            System.out.println("\tEnero: Q"+rn.format(usuario.enero));
            System.out.println("\tFebrero: Q"+rn.format(usuario.febrero));
            System.out.println("\tMarzo: Q"+rn.format(usuario.marzo));
            System.out.println("\tPromedio: Q"+rn.format(usuario.promedio));
            System.out.println("\tGran total: Q"+rn.format(usuario.gran_Total));
            System.out.println("__________--Final--__________");
        }
    }
    
    public void menu(){
        String op="";
        
        do {
            System.out.println("\n\n__________-- Menu --__________");
            System.out.print("---- Teclea 0 para salir ----"
                    + "\n1- Ingreso de informacion"
                    + "\n2- Ver que vendedor vendio mas por mes"
                    + "\n3- Ver que vendedor vendio menos por mes"
                    + "\n4- Quien vendio mas de los meses"
                    + "\n5- Editar datos "
                    + "\n6- Busqueda por cantidad"
                    + "\n7- Desplegar datos"
                    + "\n Ingresa tu opcion:  ");
            op=sn.nextLine();
            switch (op) {
                case "0":
                    System.out.println("\n\nGracias por tu preferencia.... ");
                    break;
                case "1":
                    System.out.println("\n\nLlenado de informacion ");
                    ingresoInformacion();
                    break;
                case "2":
                    //max vendedor
                    System.out.println("\n\nVendedor qe vendio mas ");
                    String max="";
                    System.out.print("\n\nEscribe el mes en minuscula: ");
                    max=sn.nextLine();
                    System.out.println(max_Mes(max));
                    break;
                case "3":
                    //min vendedor
                    System.out.println("\n\nVendedor que vendio menos ");
                    String min="";
                    System.out.print("Escribe el mes en minuscula: ");
                    min=sn.nextLine();
                    System.out.println(max_Mes(min));
                    break;
                case "4":
                    //quien vendio mas
                    System.out.println("\n\nEl maximo vendedor");
                    System.out.println(max_Total());
                    break;
                 case "5":
                     //editar datos
                     String nombre="";
                     System.out.println("\n\nIngresa el nombre para hacer la busqueda y modifcar los datos:");
                     System.out.print("Ingresa nombre: ");
                     nombre=sn.nextLine();
                     modificar_Datos(nombre);
                    break; 
                case "6":
                    //busqueda por cantidad
                    String _mes="";
                    double cantidad=0.0f;
                    System.out.println("\n\nBusqueda de vendedor por mes y cantidad de ventas");
                    System.out.print("Ingresa el mes: ");
                    _mes=sn.nextLine();
                    System.out.print("\nIngresa la cantidad: ");
                    cantidad=sn.nextDouble();
                    sn.nextLine();
                    System.out.println(busqueda_Cantidad(_mes, cantidad));
                    break;
                case "7":
                    //desplegar datos
                    System.out.println("\n\n");
                    desplegarDatos();
                    System.out.println("");
                    System.out.println(totales("enero"));
                    System.out.println(totales("febrero"));
                    System.out.println(totales("marzo"));
                    System.out.println("\n"+gran_Total());
                    break;  
                default:
                    System.out.println("\n\nError de digitacion");
            }
            
            
        } while (!op.equals("0"));
        
    }
    
    private String totales(String mes){
        mes=mes.toLowerCase();
        double suma=0.0f;
        String resultado="";
        for(ClassMdVendedor datos: n_Vendedor ){
            if ("enero".equals(mes)){
                suma+=datos.enero;
            }
            else if("febrero".equals(mes)){
                suma+=datos.febrero;
            }
            else if ("marzo".equals(mes)){
                suma+=datos.marzo;
            }  
        }
        resultado="El total de ventas del "+mes+" es "+rn.format(suma);
        return resultado;
    }
    
    private String gran_Total(){
        double suma=0.0f;
        String respuesta="";
        for (ClassMdVendedor datos: n_Vendedor){
            suma+=(datos.enero+datos.febrero+datos.marzo);
        }
        respuesta="El gran total de ventas es "+rn.format(suma);
        return respuesta;
        
    }
    
    private String max_Mes(String mes){
        mes=mes.toLowerCase();
        double maximo=0.00;
        String resultado="";
        for (ClassMdVendedor datos: n_Vendedor){
            if("enero".equals(mes)){
                if (datos.enero>maximo){
                maximo=datos.enero;
            }  
            }
            else if ("febrero".equals(mes)){
                if (datos.febrero>maximo){
                maximo=datos.febrero;
            }  
            }
            else if ("marzo".equals(mes)){
                if (datos.marzo>maximo){
                maximo=datos.marzo;
            }  
            }
            
        }
        for(ClassMdVendedor inf: n_Vendedor){
            if ("enero".equals(mes)){
                if(inf.enero==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.enero;
            }
            }
            else if ("febrero".equals(mes)){
                if(inf.febrero==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.febrero;
            }
            }
            else if ("marzo".equals(mes)){
                if(inf.marzo==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.marzo;
            }
            }         
        }
        
        return resultado;
    }
    
    private String min_Mes(String mes){
        mes=mes.toLowerCase();
        double maximo=0.00;
        String resultado="";
        for (ClassMdVendedor datos: n_Vendedor){
            if("enero".equals(mes)){
                if (datos.enero<maximo){
                maximo=datos.enero;
            }  
            }
            else if ("febrero".equals(mes)){
                if (datos.febrero<maximo){
                maximo=datos.febrero;
            }  
            }
            else if ("marzo".equals(mes)){
                if (datos.marzo<maximo){
                maximo=datos.marzo;
            }  
            }
            
        }
        for(ClassMdVendedor inf: n_Vendedor){
            if ("enero".equals(mes)){
                if(inf.enero==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.enero;
            }
            }
            else if ("febrero".equals(mes)){
                if(inf.febrero==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.febrero;
            }
            }
            else if ("marzo".equals(mes)){
                if(inf.marzo==maximo){
                resultado="El maximo vendedor es: "+inf.nombre+" con una venta de Q"+inf.marzo;
            }
            }
            
            
        }
        
        return resultado;
    }
    
    private String max_Total(){
        double max_total=0.0f;
        String resultado="";
        for(ClassMdVendedor datos: n_Vendedor){
            if(datos.gran_Total>max_total){
                max_total=datos.gran_Total;
            }
        }
        
        for (ClassMdVendedor inf: n_Vendedor){
            if(max_total==inf.gran_Total){
                resultado="El maximo vendedor es "+inf.nombre+" con Q"+rn.format(max_total);
            }
        }
        return resultado;
    }
    
    private String busqueda_Cantidad(String mes, double cantidad){
        mes=mes.toLowerCase();
        String resultado="";
        for (ClassMdVendedor datos: n_Vendedor){
            if("enero".equals(mes)){
                if (datos.enero==cantidad){
                    resultado="El vendedor encontrado es: "+datos.nombre+"  con cantidad Q"+datos.enero+" de ventas en "+mes;
            }  
            }
            else if ("febrero".equals(mes)){
                if (datos.febrero==cantidad){
                    resultado="El vendedor encontrado es: "+datos.nombre+"  con cantidad Q"+datos.febrero+" de ventas en "+mes;
            }  
            }
            else if ("marzo".equals(mes)){
                if (datos.marzo==cantidad){
                    resultado="El vendedor encontrado es: "+datos.nombre+"  con cantidad Q"+datos.marzo+" de ventas en "+mes;
            }
            }
            else {
                resultado="No se encontro a nadie con esa cantidad en el mes "+mes;
            }
        }
        return resultado;
    }
    
    private void modificar_Datos(String nombre){
        for (ClassMdVendedor inf: n_Vendedor){
            if(nombre.equals(inf.nombre)){
                int op=0;
                System.out.print("\n1. Modificar nombre"
                        + "\n2. Modificar cantidad enero"
                        + "\n3. Modificar cantidad febrero"
                        + "\n4. Modificar cantidad marzo"
                        + "\nIngresa tu opcion.");
                op=sn.nextInt();
                sn.nextLine();
                switch(op){
                    case 1:
                        String new_nombre="";
                        System.out.print("Ingresa nombre nuevo: ");
                        new_nombre=sn.nextLine();
                        inf.nombre=new_nombre;
                        System.out.println("Modificacion realizada, con exito.");
                      
                        
                        break;
                    case 2:
                        double new_enero;
                        System.out.print("Ingresa cantidad de ventas en enero nueva: ");
                        new_enero=sn.nextDouble();
                        inf.enero=new_enero;
                        inf.promedio=(inf.enero+inf.febrero+inf.marzo)/3;
                        inf.gran_Total=inf.enero+inf.febrero+inf.marzo;
                        sn.nextLine();
                        System.out.println("Modificacion realizada, con exito.");
                        break;
                    case 3:
                        double new_febrero;
                        System.out.print("Ingresa cantidad de ventas en febrero nueva: ");
                        new_febrero=sn.nextDouble();
                        inf.febrero=new_febrero;
                        inf.promedio=(inf.enero+inf.febrero+inf.marzo)/3;
                        inf.gran_Total=inf.enero+inf.febrero+inf.marzo;
                        sn.nextLine();
                        System.out.println("Modificacion realizada, con exito.");
                        break;
                    case 4:
                        double new_marzo;
                        System.out.print("Ingresa cantidad de ventas en marzo nueva: ");
                        new_marzo=sn.nextDouble();
                        inf.marzo=new_marzo;
                        inf.promedio=(inf.enero+inf.febrero+inf.marzo)/3;
                        inf.gran_Total=inf.enero+inf.febrero+inf.marzo;
                        sn.nextLine();
                        System.out.println("Modificacion realizada, con exito.");
                        break;
                        default:
                            System.out.println("Error de opcion, ingresa nuevamente...");
                            break;
                }
            }
        }
    }
}
