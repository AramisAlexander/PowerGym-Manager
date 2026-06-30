/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

import java.util.ArrayList;

/**
 * Clase que gestiona el inventario de polos del gimnasio.
 * Permite registrar polos, verificar stock, entregar unidades y reponer stock.
 *
 * @author ALEXANDER
 */
public class InventarioPolos {
    //Lista de polos registrados en el inventario.
    private ArrayList<Polo> listaPolos = new ArrayList<>();

    //Contador para la generación automática de códigos.
    private int contadorCodigo = 5;

    //Variable constante para el stock bajo
    private static final int STOCK_BAJO = 5;

    //Constructor que inicializa el inventario con polos por defecto.
    public InventarioPolos() {
        listaPolos.add(new Polo("P001", "Polo Kit PowerGym", "S",  10));
        listaPolos.add(new Polo("P002", "Polo Kit PowerGym", "M",  10));
        listaPolos.add(new Polo("P003", "Polo Kit PowerGym", "L",  3));
        listaPolos.add(new Polo("P004", "Polo Kit PowerGym", "XL",  0));
    }

    //Metodo que loos códigos se generan automáticamente.
    public String generarCodigo() {
        String codigo = String.format("P%03d", contadorCodigo);
        contadorCodigo++;
        return codigo;
    }

    //Metodo agrega un nuevo polo al inventario con código generado automáticamente.
    public void agregarPolo(Polo polo) {
        listaPolos.add(polo);
    }

    //Metodo que repone stock a un polo existente buscándolo por su código.
    public boolean agregarStock(String codigo, int cantidad) {
        for (Polo p : listaPolos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                p.agregarStock(cantidad);
                return true;
            }
        }
        return false;
    }

    //Metodo que indica si el stock de un polo.
    public boolean tieneStockBajo(String codigo) {
        for (Polo p : listaPolos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p.getStock() <= STOCK_BAJO;
            }
        }
        return false;
    }

    //Getter que retorna el stock disponible para una talla específica.
    public int getStockDeTalla(String talla) {
        for (Polo p : listaPolos) {
            if (p.getTalla().equalsIgnoreCase(talla)) {
                return p.getStock();
            }
        }
        return -1;
    }

    //Metodo de entregar un polo reduciendo en 1 el stock del primero con esa talla que tenga stock.
    public boolean entregarPolo(String talla) {
        for (Polo p : listaPolos) {
            if (p.getTalla().equalsIgnoreCase(talla) && p.getStock() > 0) {
                p.setStock(p.getStock() - 1);
                return true;
            }
        }
        return false;
    }

    //Getters retorna la lista completa de polos registrados.
    public ArrayList<Polo> getListaPolos() {
        return listaPolos;
    }

    //Metodo que muestra el inventario completo de polos en consola.
    public void mostrarInventario() {
        System.out.println("========================================");
        System.out.println("       INVENTARIO DE POLOS");
        System.out.println("========================================");
        for (Polo p : listaPolos) {
            p.mostrarPolo();
            if (p.getStock() <= STOCK_BAJO) {
                System.out.println("Stock bajo. Se recomienda reabastecer este polo.");
            }
        }
        System.out.println("========================================");
    }
}
