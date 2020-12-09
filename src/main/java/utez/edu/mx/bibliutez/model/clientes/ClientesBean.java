package utez.edu.mx.bibliutez.model.clientes;

import utez.edu.mx.bibliutez.model.usuarios.UsuariosBean;

import java.util.Date;

public class ClientesBean {
    private int id;
    private String fecha_nacimiento;
    private String telefono;
    private UsuariosBean usuariosBean;
    private String domicilio;

    public ClientesBean() {
    }

    public ClientesBean(String fecha_nacimiento, String telefono, UsuariosBean usuariosBean, String domicilio) {
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.usuariosBean = usuariosBean;
        this.domicilio = domicilio;
    }
    public ClientesBean(int id, String fecha_nacimiento, String telefono, UsuariosBean usuariosBean, String domicilio) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.usuariosBean = usuariosBean;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuariosBean getUsuariosBean() {
        return usuariosBean;
    }

    public void setUsuariosBean(UsuariosBean usuariosBean) {
        this.usuariosBean = usuariosBean;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "ClientesBean{" +
                "id=" + id +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono='" + telefono + '\'' +
                ", usuariosBean=" + usuariosBean +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
