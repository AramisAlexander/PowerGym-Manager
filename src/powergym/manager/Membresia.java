/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class Membresia {
    private String tipo;         
    private int    mesesDuracion;

    public Membresia(String tipo, int mesesDuracion) {
        this.tipo          = tipo;
        this.mesesDuracion = mesesDuracion;
    }

    // Getters
    public String getTipo(){
        return tipo; 
    }
    public int getMesesDuracion(){
        return mesesDuracion; 
    }

    // Setters
    public void setTipo(String tipo){ 
        this.tipo = tipo; 
    }
    public void setMesesDuracion(int meses){
        this.mesesDuracion = meses; 
    }

    // El descuento del 15% esta fijo en el codigo, nadie puede cambiarlo
    public double calcularPrecioSuplemento(double precioBase) {
        double precioFinal;
        if (tipo.equals("VIP")) {
            precioFinal = precioBase - (precioBase * 0.15);
        } else {
            precioFinal = precioBase;
        }
        return precioFinal;
    }

    public void mostrarMembresia() {
        System.out.println("Membresia     : " + this.tipo);
        System.out.println("Duracion      : " + this.mesesDuracion + " meses");
        if (tipo.equals("VIP")) {
            System.out.println("Beneficio     : 15% descuento en suplementos");
        } else {
            System.out.println("Beneficio     : Sin descuento en suplementos");
        }
    }
    
}
