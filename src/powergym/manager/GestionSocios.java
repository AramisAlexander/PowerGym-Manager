/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

import java.util.ArrayList;

/**
 *
 * @author ALEXANDER
 */
public class GestionSocios {
    private ArrayList<Socio> listaSocios = new ArrayList<>();
    private ArrayList<Instructor> instructores = new ArrayList<>();
    private int contadorId = 1;

    public int getTotalSocios() {
        return listaSocios.size();
    }

    public GestionSocios() {
        
        instructores.add(
        new Instructor(1, "Evaluacion Fisica",
                "DNI", "48321232",
                "Carlos", "Perez",
                "Lopez", 30));

         instructores.add(
        new Instructor(2, "Evaluacion Fisica",
                "DNI", "89457623",
                "Ana", "Torres",
                "Diaz", 28));
    }
    
    public Socio registrarSocio(String tipoDoc, String nroDoc,String nombre, String apellidoPate, String apellidomate, int edad,
                                double pesoKg, double tallaCm,
                                String tipoMembresia, int meses,
                                String tallaPolo,Instructor instructor) {
        Socio nuevo = new Socio(contadorId, tipoDoc, nroDoc, nombre, apellidoPate, apellidomate, edad,
                pesoKg, tallaCm, tipoMembresia,
                meses, tallaPolo,instructor);
        listaSocios.add(nuevo);
        contadorId++;
        return nuevo;
    }

    public Socio buscarPorDni(String dni) {
        for (Socio s : listaSocios) {
            if (s.getNroDoc().equals(dni)) {
                return s;
            }
        }
        return null;
    }

    public void listarSocios() {
        if (listaSocios.isEmpty()) {
            System.out.println("  No hay socios registrados aun.");
            return;
        }
        System.out.println("========================================");
        System.out.println("  Cod  Nombre              DNI        Membresia  IMC");
        System.out.println("  ---  ------------------  ---------  ---------  -----");
        for (Socio s : listaSocios) {
            System.out.println(
            s.getCodigoSocio() + " - " +
            s.getNombre() + " " + s.getApellidPate() +  " - " +
            s.getNroDoc() + " - " +
            s.getMembresia().getTipo() + " - " +
            s.getEvaluacion().getImc()
            );
        }
        System.out.println("========================================");
    }
    public Instructor obtenerInstructor(int codigo) {
    for (Instructor i : instructores) {
        if (i.getCodigoInstructor() == codigo) {
            return i;
        }
    }
    return null;
    }
    public ArrayList<Socio> getSocios() {
            return listaSocios;
    }
}
