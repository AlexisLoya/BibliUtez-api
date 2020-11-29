package utez.edu.mx.bibliutez.model.transacciones_detalles;

import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.transacciones.TransaccionesBean;

public class TransaccionesDetallesBean {
    private int id;
    private TransaccionesBean transacciones;
    private LibrosBean libros;
    private double monto;

    public TransaccionesDetallesBean() {
    }

    public TransaccionesDetallesBean(int id, TransaccionesBean transacciones, LibrosBean libros, double monto) {
        this.id = id;
        this.transacciones = transacciones;
        this.libros = libros;
        this.monto = monto;
    }

    public TransaccionesDetallesBean(TransaccionesBean transacciones, LibrosBean libros, double monto) {
        this.transacciones = transacciones;
        this.libros = libros;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransaccionesBean getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(TransaccionesBean transacciones) {
        this.transacciones = transacciones;
    }

    public LibrosBean getLibros() {
        return libros;
    }

    public void setLibros(LibrosBean libros) {
        this.libros = libros;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TransaccionesDetallesBean{" +
                "id=" + id +
                ", transacciones=" + transacciones +
                ", libros=" + libros +
                ", monto=" + monto +
                '}';
    }
}
