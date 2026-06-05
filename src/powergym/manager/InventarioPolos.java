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
public class InventarioPolos {
    private ArrayList<String> tallas = new ArrayList<>();
    private ArrayList<Integer> stock = new ArrayList<>();

    public InventarioPolos() {
        tallas.add("S");  stock.add(10);
        tallas.add("M");  stock.add(10);
        tallas.add("L");  stock.add(10);
        tallas.add("XL"); stock.add(10);
    }

    public int getStockDeTalla(String talla) {
        for (int i = 0; i < tallas.size(); i++) {
            if (tallas.get(i).equals(talla)) {
                return stock.get(i);
            }
        }
        return -1;
    }

    public boolean entregarPolo(String talla) {
        for (int i = 0; i < tallas.size(); i++) {
            if (tallas.get(i).equals(talla)) {
                if (stock.get(i) > 0) {
                    stock.set(i, stock.get(i) - 1);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void mostrarInventario() {
        System.out.println("========================================");
        System.out.println("       INVENTARIO DE POLOS KIT          ");
        System.out.println("========================================");
        System.out.println("  Talla     Stock disponible");
        System.out.println("  ------    ----------------");
        for (int i = 0; i < tallas.size(); i++) {
            System.out.println("  " + tallas.get(i) + "         " + stock.get(i) + " unidades");
        }
        System.out.println("========================================");
    }
}
