package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;

import java.util.ArrayList;
import java.util.Date;

public class TransaccionesBean {
    private int id;
    private ClientesBean cliente;
    private Double monto_total;
    private Date fecha;

    public TransaccionesBean() {
    }

    public TransaccionesBean(ClientesBean cliente, Double monto_total, Date fecha) {
        this.cliente = cliente;
        this.monto_total = monto_total;
        this.fecha = fecha;
    }

    public TransaccionesBean(int id, ClientesBean cliente, Double monto_total, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.monto_total = monto_total;
        this.fecha = fecha;
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

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TransaccionesBean{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", monto_total=" + monto_total +
                ", fecha=" + fecha +
                '}';
    }
}
