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
    protected String tipoDoc;
    protected String nroDoc;
    protected String nombre;
    protected String apellidPate;
    protected String apellidmate;
    protected int edad;

    public Persona(String tipoDoc, String nroDoc, String nombre, String apellidPate, String apellidmate, int edad) {
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.nombre = nombre;
        this.apellidPate = apellidPate;
        this.apellidmate = apellidmate;
        this.edad = edad;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        if (tipoDoc.equals("DNI") || tipoDoc.equals("CE")) {
            System.out.println("Documento valido");
            this.tipoDoc = tipoDoc;
        }else{
            System.out.println("Documento invalido");
        }
        
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        if (tipoDoc.equals("DNI")) {
            if (nroDoc.length() == 8) {
                 this.nroDoc = nroDoc;
                 System.out.println("DNI VALIDO");
            }
            else{
                System.out.println("Error....");
            }
        }else if (tipoDoc.equals("CE")) {
            if (nroDoc.length() == 9) {
                this.nroDoc = nroDoc;
                System.out.println("CE VALIDO");
            }else{
                System.out.println("Error....");
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidPate() {
        return apellidPate;
    }

    public void setApellidPate(String apellidPate) {
        this.apellidPate = apellidPate;
    }

    public String getApellidmate() {
        return apellidmate;
    }

    public void setApellidmate(String apellidmate) {
        this.apellidmate = apellidmate;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void mostrarDatos() {
        System.out.println("Tipo de documeto    : "+ this.tipoDoc);
        System.out.println("Número de documento : " + this.nroDoc);
        System.out.println("Nombre              : " + this.nombre );
        System.out.println("Apellido paterno    :" + this.apellidPate);
        System.out.println("Apellido materno    :" + this.apellidmate);
        System.out.println("Edad                : " + this.edad + " años");
    }
}
