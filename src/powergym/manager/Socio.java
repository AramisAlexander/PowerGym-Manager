/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class Socio extends Persona {
    private int codigoSocio;
    private EvaluacionFisica evaluacion;
    private Membresia membresia;
    private String tallaPolo;  

    public Socio(int codigoSocio,
                 String nombre, String apellido, String dni, int edad,
                 double pesoKg, double tallaCm,
                 String tipoMembresia, int mesesMembresia,
                 String tallaPolo) {

        super(nombre, apellido, dni, edad);
        this.codigoSocio = codigoSocio;
        this.evaluacion  = new EvaluacionFisica(pesoKg, tallaCm);
        this.membresia   = new Membresia(tipoMembresia, mesesMembresia);
        this.tallaPolo   = tallaPolo;
    }

    // Getters
    public int getCodigoSocio(){ 
        return codigoSocio; 
    }
    public EvaluacionFisica getEvaluacion(){
        return evaluacion; 
    }
    public Membresia getMembresia(){ 
        return membresia; 
    }
    public String  getTallaPolo(){ 
        return tallaPolo; 
    }

    // Setters
    public void setCodigoSocio(int codigoSocio){ 
        this.codigoSocio = codigoSocio;
    }
    public void setEvaluacion(EvaluacionFisica evaluacion) {
        this.evaluacion  = evaluacion; 
    }
    public void setMembresia(Membresia membresia) { 
        this.membresia   = membresia; 
    }
    public void setTallaPolo(String tallaPolo) { 
        this.tallaPolo   = tallaPolo; 
    }

    public double calcularPrecioSuplemento(double precioBase) {
        return membresia.calcularPrecioSuplemento(precioBase);
    }

    public void mostrarFicha() {
        System.out.println("========================================");
        System.out.println("     FICHA DEL SOCIO - POWER HOUSE     ");
        System.out.println("========================================");
        System.out.println("Codigo        : " + this.codigoSocio);
        mostrarDatos();       // metodo heredado de Persona
        System.out.println("----------------------------------------");
        evaluacion.mostrarEvaluacion();
        System.out.println("----------------------------------------");
        membresia.mostrarMembresia();
        System.out.println("Talla polo    : " + this.tallaPolo);
        System.out.println("========================================");
    }
}
