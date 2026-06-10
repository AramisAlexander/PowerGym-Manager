/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class Instructor extends Persona {
    private int codigoInstructor;
    private String especialidad;

    public Instructor(int codigoInstructor, String especialidad,
                      String tipoDoc, String nroDoc,
                      String nombre, String apellidoPate,
                      String apellidoMate, int edad) {

        super(tipoDoc, nroDoc, nombre,
              apellidoPate, apellidoMate, edad);

        this.codigoInstructor = codigoInstructor;
        this.especialidad = especialidad;
    }

    public int getCodigoInstructor() {
        return codigoInstructor;
    }

    public void setCodigoInstructor(int codigoInstructor) {
        this.codigoInstructor = codigoInstructor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void mostrarInstructor() {
    System.out.println("========================================");
    System.out.println("     EVALUADO POR EL INSTRUCTOR         ");
    System.out.println("========================================");
    System.out.println("Código        : " + codigoInstructor);
    mostrarDatos(); // método heredado de Persona
    System.out.println("Especialidad  : " + especialidad);
    System.out.println("========================================");
    }
    
}
