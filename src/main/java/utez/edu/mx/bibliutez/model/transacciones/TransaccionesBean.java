package utez.edu.mx.bibliutez.model.transacciones;

import utez.edu.mx.bibliutez.model.clientes.ClientesBean;
import utez.edu.mx.bibliutez.model.libros.LibrosBean;

import java.util.ArrayList;
import java.util.Date;

public class TransaccionesBean {
    private int id;
    private ClientesBean cliente_id;
    private Date fecha;
    private ArrayList<LibrosBean> libros;

    public TransaccionesBean() {
    }

    public TransaccionesBean(int id, ClientesBean cliente_id, Date fecha, ArrayList<LibrosBean> libros) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.fecha = fecha;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientesBean getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(ClientesBean cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<LibrosBean> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<LibrosBean> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "TransaccionesBean{" +
                "id=" + id +
                ", cliente_id=" + cliente_id +
                ", fecha=" + fecha +
                ", libros=" + libros +
                '}';
    }
}
