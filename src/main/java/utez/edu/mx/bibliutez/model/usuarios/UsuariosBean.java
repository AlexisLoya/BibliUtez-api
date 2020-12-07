package utez.edu.mx.bibliutez.model.usuarios;

import utez.edu.mx.bibliutez.model.roles.RolesBean;


public class UsuariosBean {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private int estatus;
    private String sexo;
    private RolesBean rolesid;
    private String password;

    public UsuariosBean() {
    }

    public UsuariosBean(int id, String nombre, String apellido1, String apellido2, String email, int estatus, String sexo, RolesBean rolesid) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.estatus = estatus;
        this.sexo = sexo;
        this.rolesid = rolesid;
    }

    public UsuariosBean(int id, String nombre, String apellido1, String apellido2, String email, int estatus, String sexo, RolesBean rolesid, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.estatus = estatus;
        this.sexo = sexo;
        this.rolesid = rolesid;
        this.password = password;
    }
    public UsuariosBean(String nombre, String apellido1, String apellido2, String email, int estatus, String sexo, RolesBean rolesid, String password) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.estatus = estatus;
        this.sexo = sexo;
        this.rolesid = rolesid;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public RolesBean getRolesid() {
        return rolesid;
    }

    public void setRolesid(RolesBean rolesid) {
        this.rolesid = rolesid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuariosDao{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", email='" + email + '\'' +
                ", estatus=" + estatus +
                ", sexo=" + sexo +
                ", rolesid=" + rolesid +
                '}';
    }
}