/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase que representa a un instructor del gimnasio.
 * Hereda de Persona e incluye código e especialidad.
 *
 * @author ALEXANDER
 */
public class Instructor extends Persona {
   //Atributos
    private int codigoInstructor;
    private String especialidad;

    //Constructor de Instructor.
    public Instructor(int codigoInstructor, String especialidad,
                      String tipoDoc, String nroDoc,
                      String nombre, String apellidoPate,
                      String apellidoMate, int edad,
                      String celular, String correo) {

        super(tipoDoc, nroDoc, nombre, apellidoPate, apellidoMate, edad, celular, correo);
        this.codigoInstructor = codigoInstructor;
        this.especialidad     = especialidad;
    }

    //GETTERS
    public int getCodigoInstructor() { 
        return codigoInstructor; 
    }
    public String getEspecialidad() { 
        return especialidad; 
    }
    
    //SETTERS
    public void setCodigoInstructor(int codigoInstructor) {
        this.codigoInstructor = codigoInstructor;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //Metodo muestra los datos completos del instructor.
    public void mostrarInstructor() {
        System.out.println("========================================");
        System.out.println("     EVALUADO POR EL INSTRUCTOR         ");
        System.out.println("========================================");
        System.out.println("Código        : " + codigoInstructor);
        mostrarDatos(); 
        System.out.println("Especialidad  : " + especialidad);
        System.out.println("========================================");
    }
}
