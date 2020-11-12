package utez.edu.mx.bibliutez.model.roles;

public class RolesBean {
    private int id;
    private String nombre;

    public RolesBean() {
    }

    public RolesBean(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "RolesBean{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
