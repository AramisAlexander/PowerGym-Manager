/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package powergym.manager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ALEXANDER
 */
public class PowerGymManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc            = new Scanner(System.in);
        GestionSocios gestion = new GestionSocios();
        InventarioPolos polos = new InventarioPolos();
        int opcion            = 0;

        while (opcion != 6) {
            System.out.println("\n========================================");
            System.out.println("         GIMNASIO - MENU PRINCIPAL      ");
            System.out.println("========================================");
            System.out.println("  1: Registrar socio");
            System.out.println("  2: Buscar socio por DNI");
            System.out.println("  3: Listar todos los socios");
            System.out.println("  4: Ver inventario de polos");
            System.out.println("  5: Comprar suplemento");
            System.out.println("  6. Salir");
            System.out.println("========================================");
            System.out.print("  Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Tipo de documento     : ");
                String tipoDoc = sc.nextLine();
                System.out.print("Número de documento   : ");
                String nroDoc = sc.nextLine();
                System.out.print("Nombre                : "); 
                String nombre   = sc.nextLine();
                System.out.print("Apellido paterno      : "); 
                String apellidoPate = sc.nextLine();
                System.out.print("Apellido materno      : "); 
                String apellidoMate = sc.nextLine();
                System.out.print("Edad                  : "); 
                int edad = sc.nextInt();
                System.out.print("Peso (kg)             : "); 
                double peso = sc.nextDouble();
                System.out.print("Talla (cm)            : "); 
                double talla = sc.nextDouble();
                sc.nextLine();
                System.out.print("Membresia (Basica/VIP): "); 
                String membresia = sc.nextLine();
                System.out.print("Meses                 : "); 
                int meses       = sc.nextInt();
                sc.nextLine();
                System.out.print("Talla polo (S/M/L/XL) : "); 
                String tallaPolo = sc.nextLine();
                System.out.println("Instructor que realiza la evaluación:");
                System.out.println("1. Carlos Perez");
                System.out.println("2. Ana Torres");
                System.out.print("Seleccione: ");

                int codInstructor = sc.nextInt();
                sc.nextLine();
                Instructor instructor = gestion.obtenerInstructor(codInstructor);

                if (polos.getStockDeTalla(tallaPolo) <= 0) {
                    System.out.println("Sin stock para talla " + tallaPolo + ". No se puede registrar.");
                } else {
                    Socio nuevo = gestion.registrarSocio(tipoDoc,nroDoc, nombre, apellidoPate, apellidoMate, edad,
                                                         peso, talla, membresia, meses, tallaPolo, instructor);
                    polos.entregarPolo(tallaPolo);
                    System.out.println("Socio registrado con codigo: " + nuevo.getCodigoSocio());
                    nuevo.mostrarFicha();
                }

            } else if (opcion == 2) {
                System.out.print("  Ingresa el DNI a buscar: ");
                String dni   = sc.nextLine();
                Socio  socio = gestion.buscarPorDni(dni);
                if (socio == null) {
                    System.out.println("  Socio no encontrado.");
                } else {
                    socio.mostrarFicha();
                }

            } else if (opcion == 3) {
                gestion.listarSocios();

            } else if (opcion == 4) {
                polos.mostrarInventario();

            } else if (opcion == 5) {
                System.out.print("  DNI del socio: ");
                String dni   = sc.nextLine();
                Socio  socio = gestion.buscarPorDni(dni);
                if (socio == null) {
                    System.out.println("  Socio no encontrado.");
                } else {
                    ArrayList<Suplemento> catalogo = new ArrayList<>();
                    catalogo.add(new Suplemento("Proteina Whey 1kg",  120.00));
                    catalogo.add(new Suplemento("Creatina 500g",       80.00));
                    catalogo.add(new Suplemento("BCAA 300g",           60.00));
                    catalogo.add(new Suplemento("Pre-entreno 250g",    75.00));

                    System.out.println("========================================");
                    System.out.println("         CATALOGO DE SUPLEMENTOS        ");
                    System.out.println("========================================");
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.print("  " + (i + 1) + ". ");
                        catalogo.get(i).mostrarSuplemento();
                    }
                    System.out.println("========================================");
                    System.out.print("  Elige un suplemento (1-" + catalogo.size() + "): ");
                    int opSup = sc.nextInt();
                    sc.nextLine();
                    if (opSup < 1 || opSup > catalogo.size()) {
                        System.out.println("  Opcion invalida.");
                    } else {
                        Suplemento elegido = catalogo.get(opSup - 1);
                        double precioFinal = socio.calcularPrecioSuplemento(elegido.getPrecioBase());
                        System.out.println("  Suplemento : " + elegido.getNombre());
                        System.out.println("  Precio base: S/ " + elegido.getPrecioBase());
                        System.out.println("  Precio final (con membresia " + socio.getMembresia().getTipo() + "): S/ " + precioFinal);
                    }
                }
            } else if (opcion == 6){
                System.out.println("  Hasta luego");          
            }else{
                System.out.println("  Opcion invalida, intenta de nuevo.");
            }
        }
        sc.close();
    }
    
}
