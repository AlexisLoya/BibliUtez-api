package utez.edu.mx.bibliutez.model.carritos;

import utez.edu.mx.bibliutez.model.libros.LibrosBean;
import utez.edu.mx.bibliutez.model.usuarios.UsuariosBean;

import java.util.ArrayList;

public class CarritosBean {
    private int id;
    private UsuariosBean usuarios_id;


    public CarritosBean() {
    }

    public CarritosBean(int id, UsuariosBean usuarios_id) {
        this.id = id;
        this.usuarios_id = usuarios_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuariosBean getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(UsuariosBean usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    @Override
    public String toString() {
        return "CarritosBean{" +
                "id=" + id +
                ", usuarios_id=" + usuarios_id +
                '}';
    }
}