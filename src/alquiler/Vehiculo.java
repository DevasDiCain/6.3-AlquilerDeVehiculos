/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jriosaguilar
 */
public class Vehiculo {

    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    //Métodos
    //Constructor parametrizado
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    public Vehiculo() {
        Random aleatorio = new Random();

        char[] matricula = new char[7];
        String[] marca = {"Subaru", "Audi", "Chevrolet", "Peugeot", "Mitsubishi", "Seat", "Opel", "Nissan", "Lexus", "Citroen", "Ferrari", "Porsche", "BMW", "Volkswagen"};
        String[] modelo = {"1500", "Piara", "Palmera", "350c", "G7", "Estepona", "Mar Azul", "307", "Borrasca", "Canon", "Horse", "AMG", "Enzo", "Veneno", "Forest"};
        String[] color = {"Azul", "Verde", "Rojo", "Amarillo", "Blanco", "Negro", "Plateado", "Rosa", "Marron", "Violeta", "Naranja", "Cian", "Gris"};
        int tarifa;
        boolean disponible;
        int numAlea;
        int letraAlea;

        //Bucle para ponerle los numeros a la matricula
        for (int x = 0; x < matricula.length - 3; x++) {
            numAlea = aleatorio.nextInt(10) + 48;
            matricula[x] = (char) numAlea;
        }

        //Bucle para ponerla las letras a la matricula
        for (int x = 4; x < matricula.length; x++) {
            letraAlea = aleatorio.nextInt(25) + 65;
            matricula[x] = (char) letraAlea;
        }

        this.matricula = Arrays.toString(matricula);

        int marcaAlea = aleatorio.nextInt(marca.length - 1);
        int modeloAlea = aleatorio.nextInt(modelo.length - 1);
        int colorAlea = aleatorio.nextInt(color.length - 1);
        tarifa = aleatorio.nextInt(250) + 50;
        disponible = aleatorio.nextBoolean();

        this.marca = marca[marcaAlea];
        this.modelo = modelo[modeloAlea];
        this.color = color[colorAlea];
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    //Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tarifa=" + tarifa + ", disponible=" + disponible + '}';
    }

    public static Vehiculo vehiculoAleatorio() {
        Vehiculo x = new Vehiculo();
        return x;
    }

}
