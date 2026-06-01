/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre   = nombre;
        this.apellido = apellido;
        this.dni      = dni;
        this.edad     = edad;
    }

    // Getters
    public String getNombre(){ 
        return nombre; 
    }
    public String getApellido(){
        return apellido;
    }
    public String getDni(){ 
        return dni;
    }
    public int getEdad(){ 
        return edad; 
    }

    // Setters
    public void setNombre(String nombre){ 
        this.nombre   = nombre; 
    }
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }
    public void setDni(String dni){ 
        this.dni      = dni; 
    }
    public void setEdad(int edad){
        this.edad     = edad; 
    }

    public void mostrarDatos() {
        System.out.println("Nombre  : " + this.nombre + " " + this.apellido);
        System.out.println("DNI     : " + this.dni);
        System.out.println("Edad    : " + this.edad + " años");
    }
}
