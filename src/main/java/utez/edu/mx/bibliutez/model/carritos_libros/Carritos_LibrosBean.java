package utez.edu.mx.bibliutez.model.carritos_libros;

import utez.edu.mx.bibliutez.model.carritos.CarritosBean;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;

public class Carritos_LibrosBean {
    private int id;
    private CarritosBean carritos_id;
    private LibrosBean libros_id;
    private int cantidad;


    public Carritos_LibrosBean() {
    }

    public Carritos_LibrosBean(int id, CarritosBean carritos_id, LibrosBean libros_id, int cantidad) {
        this.id = id;
        this.carritos_id = carritos_id;
        this.libros_id = libros_id;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarritosBean getCarritos_id() {
        return carritos_id;
    }

    public void setCarritos_id(CarritosBean carritos_id) {
        this.carritos_id = carritos_id;
    }

    public LibrosBean getLibros_id() {
        return libros_id;
    }

    public void setLibros_id(LibrosBean libros_id) {
        this.libros_id = libros_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carritos_LibrosBean{" +
                "id=" + id +
                ", carritos_id=" + carritos_id +
                ", libros_id=" + libros_id +
                ", cantidad=" + cantidad +
                '}';
    }
}
