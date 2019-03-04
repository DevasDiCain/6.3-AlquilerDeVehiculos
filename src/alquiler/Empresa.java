/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Empresa {

    //Atributos
    private String cif;
    private String nombre;
    private String paginaWeb;

    /*Atributos para almacenar el total de clientes que tiene la empresa y array
    de almacenamiento para los objetos Cliente*/
    private int totalClientes;
    private Cliente[] clientes;

    //ArrayList que guardará la lista de clientes aleatorios
    private ArrayList<Cliente> clientesAlea;

    /*Atributos para controlar el total de vehiculos disponibles para alquilar en
    la empresa y array de almacenamiento para los objetos Vehiculo*/
    private int totalVehiculos;
    private Vehiculo[] vehiculos;

    //ArrayList que guardará la lista de vehículos aleatorios
    private ArrayList<Vehiculo> vehiculosAlea;

    /*Atributos para controJose", "Juan", "Hector", "Daniel", "Alejandro", "Victor", "Ana", "Maria", "Paula", "Roberta", "Lucia", "Lidia"};
        String[] apellido={"Ramirez", "Rios", "Glar el histórico de alquileres: total de alquileres
    realizados y array de almacenamiento para los objetos VehiculoAlquilado*/
    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;

    //Metodos
    /*Constructor parametrizado */
    public Empresa(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;

        //Inicialmente la empresa no tiene clientes
        this.totalClientes = 0;
        this.clientes = new Cliente[50];

        //Inicialmente la empresa no tiene vehiculos
        this.totalVehiculos = 0;
        this.vehiculos = new Vehiculo[50];

        //Inicialmente la empresa no tiene alquileres
        this.totalAlquileres = 0;
        this.alquileres = new VehiculoAlquilado[100];
        
        this.clientesAlea= new ArrayList();
        this.vehiculosAlea= new ArrayList();
    }

    //Método para registrar un cliente
    public void registrarCliente(Cliente nuevo) {
        this.clientes[this.totalClientes] = nuevo;
        this.totalClientes++;
    }

    //Método para registrar un vehiculo
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos[this.totalVehiculos] = nuevo;
        this.totalVehiculos++;
    }

    //Método para mostrar los datos de un cliente de la empresa
    public void imprimirClientes() {
        for (int x = 0; x < this.totalClientes; x++) {
            System.out.println("NIF: " + clientes[x].getNif() + "\tNombre: " + clientes[x].getNombre()
                    + "\tApellidos: " + clientes[x].getApellidos());
        }
    }

    //Método para mostrar los vehiculos de la empresa
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int x = 0; x < this.totalVehiculos; x++) {
            System.out.println("Matricula: " + vehiculos[x].getMatricula() + "\tModelo: " + vehiculos[x].getModelo()
                    + "\tColor: " + vehiculos[x].getColor() + "\tImporte: " + vehiculos[x].getTarifa() + "\tDisponible: " + vehiculos[x].isDisponible());
        }
    }

    //Metodo para obtener el cliente
    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.getTotalClientes(); i++) {
            if (this.clientes[i].getNif().equals(nif)) {
                return this.clientes[i];
            }
        }
        return null;
    }

    //Metodo para obtener el vehiculo
    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.getTotalVehiculos(); i++) {
            if (this.vehiculos[i].getMatricula().equals(matricula)) {
                return this.vehiculos[i];
            }
        }
        return null;
    }

    //Método para alquilar un vehiculo
    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres] = new VehiculoAlquilado(cliente, vehiculo, diaHoy(),
                    mesHoy(), anioHoy(), dias);
            this.totalAlquileres++;
        }
    }

    //Metodo para poner un vehiculo a estado disponible para alquilar
    public void recibirVehiculo(String matricula) {
        // busca el vehículo con la matrícula dada en el
        // array vehiculos y modifica su disponibilidad
        // para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }
    }

    public void generarVehiculosAlea() {
        for (int x = 0; x < 50; x++) {
            this.vehiculos[x] = new Vehiculo();
        }
        this.totalVehiculos = 50;
    }

    public void generarClientesAlea() {
        for (int x = 0; x < 50; x++) {
            this.clientes[x] = new Cliente();
        }
        this.totalClientes = 50;
    }

    //Getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public ArrayList<Cliente> getClientesAlea() {
        return clientesAlea;
    }

    public void setClientesAlea(ArrayList<Cliente> clientesAlea) {
        this.clientesAlea = clientesAlea;
    }

    public ArrayList<Vehiculo> getVehiculosAlea() {
        return vehiculosAlea;
    }

    public void setVehiculosAlea(ArrayList<Vehiculo> vehiculosAlea) {
        this.vehiculosAlea = vehiculosAlea;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
        this.alquileres = alquileres;
    }

    public LocalDate diaHoy() {
        LocalDate hoy = LocalDate.now();
        hoy.getDayOfMonth();
        return hoy;
    }

    public LocalDate mesHoy() {
        LocalDate mes = LocalDate.now();
        mes.getMonth();
        return mes;
    }

    public LocalDate anioHoy() {
        LocalDate anio = LocalDate.now();
        anio.getYear();
        return anio;
    }

    public void ordenarClientes() {
        int valor = 0;
        Cliente tmp = new Cliente("09082192K", "josé", "rodriguez");
        System.out.println("-----------------");
        System.out.println(clientes.length);
        System.out.println(totalClientes);
        for (int i = 0; i < totalClientes - 1; i++) {
            for (int j = i + 1; i < totalClientes; i++) {
                if (clientes[i].getNif().compareTo(clientes[j].getNif()) > 0) {
                    tmp = clientes[i];
                    clientes[j] = clientes[i];
                    clientes[j] = tmp;
                }

            }
        }

    }

    public void ordenarVehiculos() {
        int valor = 0;
        Vehiculo tmp = new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false);
        System.out.println("-----------------");
        System.out.println(vehiculos.length);
        System.out.println(totalVehiculos);
        for (int i = 0; i < totalVehiculos - 1; i++) {
            for (int j = i + 1; i < totalVehiculos; i++) {
                if (vehiculos[i].getMatricula().compareTo(vehiculos[j].getMatricula()) > 0) {
                    tmp = vehiculos[i];
                    vehiculos[j] = vehiculos[i];
                    vehiculos[j] = tmp;
                }

            }
        }

    }

    public int busquedaNif(String nif) {
        int posicion = 0, inicio = 0;
        int end = nif.length();
        while (inicio <= end) {
            posicion = (inicio + end) / 2;
            if (this.clientes[posicion].getNif().compareTo(nif) == 0) {
                return posicion;
            } else if (this.clientes[posicion].getNif().compareTo(nif) < 0) {
                inicio = posicion + 1;
            } else {
                end = posicion - 1;
            }
        }
        return -1;
    }

    public int busquedaMatrícula(String matricula) {
        int posicion = 0, inicio = 0;
        int end = matricula.length();
        while (inicio <= end) {
            posicion = (inicio + end) / 2;
            if (this.clientes[posicion].getNif().compareTo(matricula) == 0) {
                return posicion;
            } else if (this.clientes[posicion].getNif().compareTo(matricula) < 0) {
                inicio = posicion + 1;
            } else {
                end = posicion - 1;
            }
        }
        return -1;
    }

    //Método de clase, en Empresa, que llene un arraylist de 25 Clientes con objetos aleatorios.
    public void fillClientes() {
        for (int i = 0; i < 25; i++) {
            this.clientesAlea.add(Cliente.clienteAleatorio());
            //System.out.println(this.clientesAlea.get(i));
        }
        
    }
    //Método de clase, en Empresa, que llene un arraylist de 25 Vehículos con objetos aleatorios.
    public void fillVehiculos(){
        for  (int i = 0 ; i<25;i++){
            this.vehiculosAlea.add( Vehiculo.vehiculoAleatorio());
           // System.out.println(this.vehiculosAlea.get(i));
              }
    }
//    Métodos de ordenación mediante la burbuja de los arraylist de clientes por nif y de vehículos por matrícula.
//    Estos métodos se encontrarán en la clase Empresa y se llamarán ordenarCatalogoVehiculos() y ordenarCarteraClientes().

       public void ordenarCarteraClientes(){
       int valor = 0;
        Cliente tmp = new Cliente();
        System.out.println("-----------------");
        System.out.println(clientesAlea.size());
        for (int i = 0; i < clientesAlea.size() - 1; i++) {
            for (int j = i + 1; i < clientesAlea.size(); i++) {
                if (clientesAlea.get(i).getNif().compareTo(clientesAlea.get(j).getNif()) > 0) {
                    tmp = clientesAlea.get(i);
                    clientesAlea.set(i, clientesAlea.get(j));
                    clientes[j] = tmp;
                    
                }

            }
        }
       }
       
       public void ordenarCatalogoVehiculos(){
           int valor = 0;
        Vehiculo tmp = new Vehiculo();
        System.out.println("-----------------");
        System.out.println(vehiculosAlea.size());
        for (int i = 0; i < vehiculosAlea.size() - 1; i++) {
            for (int j = i + 1; i < vehiculosAlea.size(); i++) {
                if (vehiculosAlea.get(i).getMatricula().compareTo(vehiculosAlea.get(j).getMatricula()) > 0) {
                    tmp = vehiculosAlea.get(i);
                    vehiculosAlea.set(i, vehiculosAlea.get(j));
                    vehiculos[j] = tmp;
                    
        }
            }
        }
       }
       
       public void mostrarClientesAleas(){
           System.out.println(clientesAlea.size());
           //this.clientesAlea.forEach(System.out::println);
           for(Cliente x : clientesAlea){System.out.println(x);}
       }
       public void mostrarVehiculosAleas(){
           this.vehiculosAlea.forEach(System.out::println);
       }
       
       //Método de búsqueda binaria por nif en el arraylist de clientes. Este método estará en la clase Empresa 
       //Y tendrá como parámetro el nif del cliente a buscar.
       //Devolverá la posición en el array que ocupa el cliente si se encuentra o -1 si no está.
       
       public int busquedaNifArrayList(String nif){
           int posicion = 0, inicio = 0;
        int end = nif.length();
        while (inicio <= end) {
            posicion = (inicio + end) / 2;
            if (this.clientesAlea.get(posicion).getNif().compareTo(nif) == 0) {
                return posicion;
            } else if (this.clientesAlea.get(posicion).getNif().compareTo(nif) < 0) {
                inicio = posicion + 1;
            } else {
                end = posicion - 1;
            }
        }
        return -1;
       }
       //Método de búsqueda binaria por matrícula en el arraylist de vehículos. Este método estará en la clase Empresa
       //y tendrá como parámetro la matrícula del Vehículo a buscar. 
       //Devolverá la posición en el array que ocupa el vehículo si se encuentra o -1 si no está.

       public int busquedaMatriculaArrayList(String matricula){
       int posicion = 0, inicio = 0;
        int end = matricula.length();
        while (inicio <= end) {
            posicion = (inicio + end) / 2;
            if (this.vehiculosAlea.get(posicion).getMatricula().compareTo(matricula) == 0) {
                return posicion;
            } else if (this.vehiculosAlea.get(posicion).getMatricula().compareTo(matricula) < 0) {
                inicio = posicion + 1;
            } else {
                end = posicion - 1;
            }
        }
        return -1;
       }
       

}
