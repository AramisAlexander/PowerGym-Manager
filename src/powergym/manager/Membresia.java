/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase que representa la membresía de un socio en el gimnasio.
 * Controla el tipo (Basica o VIP) y la duración en meses.
 * Los socios VIP obtienen 15% de descuento en suplementos.
 *
 * @author ALEXANDER
 */
public class Membresia {
    //Atributos
    private String tipo;
    private int    mesesDuracion;

    //Constructor de Membresia.
    public Membresia(String tipo, int mesesDuracion) {
        this.tipo = tipo;
        this.mesesDuracion = mesesDuracion;
    }

    //GETTERS
    public String getTipo() { 
        return tipo; 
    }
    public int getMesesDuracion() { 
        return mesesDuracion; 
    }

    //SETTERS
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }
    public void setMesesDuracion(int meses) { 
        this.mesesDuracion = meses; 
    }

    //Metodo que calcula el precio final de un suplemento aplicando descuento VIP del 15%.
    public double calcularPrecioSuplemento(double precioBase) {
        double precioFinal;
        if (tipo.equals("VIP")) {
            precioFinal = precioBase - (precioBase * 0.15);
        } else {
            precioFinal = precioBase;
        }
        return precioFinal;
    }

    //Metodo que muestra los datos de la membresía.
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

