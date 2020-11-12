package utez.edu.mx.bibliutez.model.autores;

public class AutoresBean {
    private int id;
    private String nombre;

    public AutoresBean() {
    }

    public AutoresBean(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public AutoresBean(String nombre) {
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
        return "AutoresBean{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
