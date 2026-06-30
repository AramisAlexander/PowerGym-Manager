/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase que representa un suplemento disponible para la venta en el gimnasio.
 * Incluye código (generado automáticamente).
 *
 * @author ALEXANDER
 */
public class Suplemento {
    //Atributos
    private String codigo;
    private String nombre;
    private double precioBase;
    private int stock;

    //Esto se arregló: Constructor de Suplemento.
    public Suplemento(String codigo, String nombre, double precioBase, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock  = stock;
    }

    //Constructor vacío. 
    public Suplemento() { }

    //GETTERS 
    public String getCodigo() { 
        return codigo; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public double getPrecioBase() { 
        return precioBase; 
    }
    public int getStock() { 
        return stock; 
    }

    //SETTERS
    public void setCodigo(String codigo) { 
        this.codigo     = codigo;
    }
    public void setNombre(String nombre) { 
        this.nombre     = nombre; 
    }
    public void setPrecioBase(double precio) { 
        this.precioBase = precio; 
    }
    public void setStock(int stock) { 
        this.stock      = stock; 
    }

    // Metodo que reduce el stock en la cantidad indicada.
    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    //Esto se arregló: Metodo que agrega unidades al stock actual del suplemento.
    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    //Metodo quemMuestra la información básica del suplemento.
    public void mostrarSuplemento() {
        System.out.println("[" + this.codigo + "] " + this.nombre +" | S/ " + this.precioBase + " | Stock: " + this.stock);
    }
}
