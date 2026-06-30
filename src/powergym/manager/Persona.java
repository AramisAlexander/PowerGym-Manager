/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase base que representa a una persona dentro del sistema PowerGym Manager.
 * Es la clase padre de Socio e Instructor.
 *
 * @author ALEXANDER
 */
public class Persona {
    //Atributos
    protected String tipoDoc;
    protected String nroDoc;
    protected String nombre;
    protected String apellidPate;
    protected String apellidmate;
    protected int    edad;
    protected String celular;
    protected String correo;

    //Constructor de Persona.
    public Persona(String tipoDoc, String nroDoc, String nombre,
                   String apellidPate, String apellidmate, int edad,
                   String celular, String correo) {
        this.tipoDoc    = tipoDoc;
        this.nroDoc     = nroDoc;
        this.nombre     = nombre;
        this.apellidPate= apellidPate;
        this.apellidmate= apellidmate;
        this.edad       = edad;
        this.celular    = celular;
        this.correo     = correo;
    }

    //GETTERS
    public String getTipoDoc() { 
        return tipoDoc; 
    }
    public String getNroDoc() { 
        return nroDoc; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public String getApellidPate() { 
        return apellidPate; 
    }
    public String getApellidmate() { 
        return apellidmate; 
    }
    public int getEdad() { 
        return edad; 
    }
    public String getCelular() { 
        return celular; 
    }
    public String getCorreo() { 
        return correo; 
    }

    //SETTERS
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }
    public void setNombre(String nombre) { 
        this.nombre     = nombre; 
    }
    public void setApellidPate(String apellidPate) { 
        this.apellidPate= apellidPate; 
    }
    public void setApellidmate(String apellidmate) { 
        this.apellidmate= apellidmate; 
    }
    public void setEdad(int edad) { 
        this.edad       = edad; 
    }
    public void setCelular(String celular) { 
        this.celular    = celular;
    }
    public void setCorreo(String correo) { 
        this.correo     = correo; 
    }

    //Metodo que muestra los datos básicos de la persona en consola.
    public void mostrarDatos() {
        System.out.println("Tipo de documento   : " + this.tipoDoc);
        System.out.println("Número de documento : " + this.nroDoc);
        System.out.println("Nombre              : " + this.nombre);
        System.out.println("Apellido paterno    : " + this.apellidPate);
        System.out.println("Apellido materno    : " + this.apellidmate);
        System.out.println("Edad                : " + this.edad + " años");
        System.out.println("Celular             : " + this.celular);
        System.out.println("Correo              : " + this.correo);
    }
}
