package utez.edu.mx.bibliutez.model.editoriales;

public class EditoralBean {
    private int id;
    private String nombre;

    public EditoralBean() {
    }

    public EditoralBean(int id, String nombre) {
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
        return "EditoralBean{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
