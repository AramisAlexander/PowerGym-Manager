/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class Suplemento {
    private String nombre;
    private double precioBase;

    public Suplemento(String nombre, double precioBase) {
        this.nombre     = nombre;
        this.precioBase = precioBase;
    }

    public Suplemento() {
    }

    // Getters
    public String getNombre(){ 
        return nombre; 
    }
    public double getPrecioBase(){
        return precioBase; 
    }

    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    public void setPrecioBase(double precio){ 
        this.precioBase = precio; 
    }

    public void mostrarSuplemento() {
        System.out.printf(this.nombre + "S/ " + this.precioBase + "\n" );
    }
}
