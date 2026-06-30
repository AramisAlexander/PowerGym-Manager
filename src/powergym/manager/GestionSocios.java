/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

import java.util.ArrayList;

/**
 * Clase que gestiona el registro y consulta de socios e instructores del gimnasio.
 * Mantiene listas en memoria usando ArrayList.
 *
 * @author ALEXANDER
 */
public class GestionSocios {
    //Lista de socios registrados. 
    private ArrayList<Socio>      listaSocios   = new ArrayList<>();

    //Lista de instructores disponibles.
    private ArrayList<Instructor> instructores  = new ArrayList<>();

    //Contador autoincrementable para el codigo de socio.
    private int contadorId = 1;

    //Constructor que inicializa los instructores por defecto del sistema.
    public GestionSocios() {
        instructores.add(new Instructor(
                1, "Evaluacion Fisica",
                "DNI", "48321232",
                "Carlos", "Perez", "Lopez", 30,
                "987654321", "carlos.perez@powergym.com"));

        instructores.add(new Instructor(
                2, "Evaluacion Fisica",
                "DNI", "89457623",
                "Ana", "Torres", "Diaz", 28,
                "912345678", "ana.torres@powergym.com"));
    }

    // Metodo retorna el total de socios registrados.
    public int getTotalSocios() {
        return listaSocios.size();
    }

    //Metodo registrarSocio.
    public Socio registrarSocio(String tipoDoc, String nroDoc,
                                String nombre, String apellidoPate, String apellidomate,
                                int edad, double pesoKg, double tallaCm,
                                String tipoMembresia, int meses, String tallaPolo,
                                Instructor instructor,
                                String celular, String correo) {

        Socio nuevo = new Socio(contadorId, tipoDoc, nroDoc, nombre,
                apellidoPate, apellidomate, edad, pesoKg, tallaCm,
                tipoMembresia, meses, tallaPolo, instructor,
                celular, correo);
        listaSocios.add(nuevo);
        contadorId++;
        return nuevo;
    }

    //Metodo busca un socio por su número de DNI.
    public Socio buscarPorDni(String dni) {
        for (Socio s : listaSocios) {
            if (s.getNroDoc().equals(dni)) {
                return s;
            }
        }
        return null;
    }

    //Metodo de validación de duplicados para el número de documento.
    public boolean documentoExiste(String nroDoc) {
        for (Socio s : listaSocios) {
            if (s.getNroDoc().equals(nroDoc)) {
                return true;
            }
        }
        return false;
    }

    // Metodo listar todos los socios registrados.
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
                s.getNombre() + " " + s.getApellidPate() + " - " +
                s.getNroDoc() + " - " +
                s.getMembresia().getTipo() + " - " +
                s.getEvaluacion().getImc()
            );
        }
        System.out.println("========================================");
    }

    //Metodo que obtiene un instructor por su código.
    public Instructor obtenerInstructor(int codigo) {
        for (Instructor i : instructores) {
            if (i.getCodigoInstructor() == codigo) {
                return i;
            }
        }
        return null;
    }

    //Getter que devuelve todos los socios almacenados en la lista.
    public ArrayList<Socio> getSocios() {
        return listaSocios;
    }
}


