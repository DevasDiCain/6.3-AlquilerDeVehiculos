/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jriosaguilar
 */
public class Main {
    
    public static void main(String[] args) {
        
//        // la instancia easydrive de la clase Empresa
//        Empresa easydrive = new Empresa("A-28-187189", "easy drive", "www.easydrive.com");
//        
//        // registro de los clientes de la empresa
//        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
//        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));
//
//        // registro de los vehículos de la empresa
//        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang",
//
//        "Rojo", 150.0, true));
//
//        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));
//
//        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));
//        
//        // imprime la relación de clientes de easydrive
//        easydrive.imprimirClientes();
//        
//        // imprime el catálogo de vehículos de easydrive
//        easydrive.imprimirVehiculos();
//        
//        Cliente c1=new Cliente();
//        System.out.println(c1);
//        
//        Vehiculo v1=new Vehiculo();
//        System.out.println(v1);
//        
//        Empresa e1=new Empresa("292","Hola","hola.com");
//        e1.generarVehiculosAlea();
//        e1.imprimirVehiculos();
//        e1.ordenarVehiculos();

        
//        Cliente.clienteAleatorio();
//        Vehiculo.vehiculoAleatorio();

//En la clase que contenga el método main() se debe:
//Todos los resultados se deben mostrar por consola, comprobando que el comportamiento de los métodos es el correcto.
        Scanner sn = new Scanner(System.in);
        //Crear una empresa de alquiler con los datos que tú quieras.
        Empresa e = new Empresa("A79380465", "Mercedes-benz", "www.mercedes-benz.es");
        //Se llenarán los arraylist de clientes y vehículos de forma aleatoria usando los métodos pertinentes. 
        e.fillClientes();
        e.fillVehiculos();
        //Una vez cargados los 25 clientes y 25 vehículos aleatorios, se mostrarán usando la consola.
        e.mostrarClientesAleas();
        e.mostrarVehiculosAleas();
        //El programa solicitará por teclado el nif de un cliente, la matrícula de un vehículo y el número de días que se quiere alquilar.
        System.out.println("Introduzca el nif del cliente");
        String nifCliente=sn.nextLine();
        System.out.println("Introduce la matrícula del coche");
        String matriculaCliente=sn.nextLine();
        System.out.println("Introduce el número de días que se quiere alquilar");
        int numeroDias=sn.nextInt();
        //El sistema registrará, usando el método apropiado, el alquiler anterior.
        e.alquilarVehiculo(matriculaCliente, nifCliente, numeroDias);
        //Se debe mostrar por consola el alquiler registrado.
        System.out.println(e.getAlquileres());
        //Posteriormente, se ordenarán los clientes y los vehículos usando los métodos apropiados. 
        e.ordenarCarteraClientes();
        e.ordenarCatalogoVehiculos();
        //Se volverá a buscar otro cliente y otro vehículo, solicitando los datos al usuario, usando búsqueda binaria.
        sn.nextInt();
        System.out.println("¿Qué cliente desea buscar?");
        String cliente=sn.nextLine();
        e.busquedaNifArrayList(cliente);
        System.out.println("¿Vehículo?");
        String vehículo= sn.nextLine();
        e.busquedaMatriculaArrayList(vehículo);
        
       
            
       

       
       
        
        
        
        
        
    }
    
}
        
    
    

