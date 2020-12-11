package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;

import java.util.ArrayList;
import java.util.Date;

public class TransaccionesBean {
        private int id;
        private ClientesBean cliente;
        private LibrosBean libro;
        private Double monto_total;


    public TransaccionesBean() {
    }

    public TransaccionesBean(ClientesBean cliente, LibrosBean libro, Double monto_total) {
        this.cliente = cliente;
        this.libro = libro;
        this.monto_total = monto_total;
    }

    public TransaccionesBean(int id, ClientesBean cliente, LibrosBean libro, Double monto_total) {
        this.id = id;
        this.cliente = cliente;
        this.libro = libro;
        this.monto_total = monto_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientesBean getCliente() {
        return cliente;
    }

    public void setCliente(ClientesBean cliente) {
        this.cliente = cliente;
    }

    public LibrosBean getLibro() {
        return libro;
    }

    public void setLibro(LibrosBean libro) {
        this.libro = libro;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    @Override
    public String toString() {
        return "TransaccionesBean{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", libro=" + libro +
                ", monto_total=" + monto_total +
                '}';
    }
}
