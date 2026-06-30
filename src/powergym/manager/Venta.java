/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

/**
 * Clase que representa una venta de suplementos en el gimnasio.
 * Se asocia directamente con un Suplemento registrado previamente.
 * Actualiza el stock automáticamente al registrar la venta.
 *
 * @author ALEXANDER
 */
public class Venta {
    //Atributos
    private String codigoVenta;
    private String fechaVenta;
    private Suplemento suplemento;
    private int cantidad;
    private double precioUnitario;
    private double     totalVenta;

    //Constructor de Venta.
    public Venta(String codigoVenta, String fechaVenta,
                 Suplemento suplemento, int cantidad, double precioUnitario) {
        this.codigoVenta    = codigoVenta;
        this.fechaVenta     = fechaVenta;
        this.suplemento     = suplemento;
        this.cantidad       = cantidad;
        this.precioUnitario = precioUnitario;
        calcularTotal();
    }

    //GETTERS
    public String getCodigoVenta() {
        return codigoVenta; 
    }
    public String getFechaVenta() { 
        return fechaVenta; 
    }
    public Suplemento getSuplemento() { 
        return suplemento; 
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario; 
    }
    public double getTotalVenta() { 
        return totalVenta; 
    }
    
    //SETTERS
    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    //Metodo que calcula el total de la venta multiplicando precio por cantidad.
    public void calcularTotal() {
        this.totalVenta = this.precioUnitario * this.cantidad;
    }

    //Metodo que registra la venta descontando el stock del suplemento.
    public void registrarVenta() {
        suplemento.reducirStock(cantidad);
    }

    // Metodo que retorna un resumen de la venta como String para mostrar en pantalla.
    public String mostrarVenta() {
        return "====================================\n"
             + "DETALLE DE VENTA\n"
             + "====================================\n"
             + "Código Venta   : " + this.codigoVenta    + "\n"
             + "Fecha          : " + this.fechaVenta      + "\n"
             + "Suplemento     : " + this.suplemento.getNombre() + "\n"
             + "Cantidad       : " + this.cantidad        + "\n"
             + "Precio unitario: S/ " + String.format("%.2f", this.precioUnitario) + "\n"
             + "TOTAL          : S/ " + String.format("%.2f", this.totalVenta)     + "\n"
             + "====================================";
    }
}