/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase que representa un polo (prenda) del kit de bienvenida del gimnasio.
 * Incluye código (generado automáticamente), nombre, talla y stock.
 *
 * @author ALEXANDER
 */
public class Polo {
    //Atributos
    private String codigo;
    private String nombre;
    private String talla;
    private int stock;

    //Esto se arregló:Constructor de Polo.
    public Polo(String codigo, String nombre, String talla, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.talla  = talla;
        this.stock  = stock;
    }

    //GETTERS
    public String getCodigo() { 
        return codigo; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getTalla() { 
        return talla; 
    }
    public int getStock() { 
        return stock; 
    }

    //SETTERS 
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setTalla(String talla) { 
        this.talla  = talla; 
    }
    public void setStock(int stock) { 
        this.stock  = stock; 
    }

    //Esto se arregló: Metodo que agrega unidades al stock actual del polo.
    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    //Metodo que muestra la información del polo.
    public void mostrarPolo() {
        System.out.println("[" + this.codigo + "] " + this.nombre + " | Talla: " + this.talla + " | Stock: " + this.stock);
    }
}
