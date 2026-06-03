/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 *
 * @author ALEXANDER
 */
public class EvaluacionFisica {
    private double pesoKg;
    private double tallaCm;
    private double imc;
    private String clasificacion;

    public EvaluacionFisica(double pesoKg, double tallaCm) {
        this.pesoKg  = pesoKg;
        this.tallaCm = tallaCm;
        calcularIMC();
    }
    
    // Getters
    public double getPesoKg(){
        return pesoKg;
    }
    public double getTallaCm(){ 
        return tallaCm; 
    }
    public double getImc(){
        return imc; 
    }
    public String getClasificacion(){
        return clasificacion; 
    }

    // Setters 
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
        calcularIMC();
    }

    public void setTallaCm(double tallaCm) {
        this.tallaCm = tallaCm;
        calcularIMC();
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Metodo privado - el usuario NO puede llamarlo
    private void calcularIMC() {
        double tallaEnMetros = tallaCm / 100.0;
        this.imc = pesoKg / (tallaEnMetros * tallaEnMetros);

        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25.0) {
            clasificacion = "Normal";
        } else if (imc < 30.0) {
            clasificacion = "Sobrepeso";
        } else if (imc < 35.0) {
            clasificacion = "Obesidad Grado I";
        } else if (imc < 40.0) {
            clasificacion = "Obesidad Grado II";
        } else {
            clasificacion = "Obesidad Grado III";
        }
    }

    public void mostrarEvaluacion() {
        System.out.println("Peso          : " + this.pesoKg + " kg");
        System.out.println("Talla         : " + this.tallaCm + " cm");
        System.out.printf ("IMC           : " + this.imc);
        System.out.println("Clasificacion : " + this.clasificacion);
    }
    
}
