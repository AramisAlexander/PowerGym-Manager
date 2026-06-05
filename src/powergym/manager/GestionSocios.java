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
    private int contadorId = 1;

    public int getTotalSocios() {
        return listaSocios.size();
    }

    public Socio registrarSocio(String nombre, String apellido, String dni, int edad,
                                double pesoKg, double tallaCm,
                                String tipoMembresia, int meses,
                                String tallaPolo) {
        Socio nuevo = new Socio(contadorId, nombre, apellido, dni, edad,
                                pesoKg, tallaCm, tipoMembresia, meses, tallaPolo);
        listaSocios.add(nuevo);
        contadorId++;
        return nuevo;
    }

    public Socio buscarPorDni(String dni) {
        for (Socio s : listaSocios) {
            if (s.getDni().equals(dni)) {
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
            s.getNombre() + " " + s.getApellido() + " - " +
            s.getDni() + " - " +
            s.getMembresia().getTipo() + " - " +
            s.getEvaluacion().getImc()
            );
        }
        System.out.println("========================================");
    }
}
