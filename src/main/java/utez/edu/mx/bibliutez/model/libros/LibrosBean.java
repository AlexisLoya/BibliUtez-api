package utez.edu.mx.bibliutez.model.libros;

import utez.edu.mx.bibliutez.model.autores.AutoresBean;
import utez.edu.mx.bibliutez.model.categorias.CategoriaBean;
import utez.edu.mx.bibliutez.model.editoriales.EditorialBean;

public class LibrosBean {
    private int id;
    private String nombre;
    private EditorialBean editoriales_id;
    private AutoresBean autores_id;
    private CategoriaBean categorias_id;
    private Double precio;
    private int num_pag;
    private int stock;

    public LibrosBean() {
    }

    public LibrosBean(int id, String nombre, EditorialBean editoriales_id, AutoresBean autores_id, CategoriaBean categorias_id, Double precio, int num_pag, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.editoriales_id = editoriales_id;
        this.autores_id = autores_id;
        this.categorias_id = categorias_id;
        this.precio = precio;
        this.num_pag = num_pag;
        this.stock = stock;
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

    public EditorialBean getEditoriales_id() {
        return editoriales_id;
    }

    public void setEditoriales_id(EditorialBean editoriales_id) {
        this.editoriales_id = editoriales_id;
    }

    public AutoresBean getAutores_id() {
        return autores_id;
    }

    public void setAutores_id(AutoresBean autores_id) {
        this.autores_id = autores_id;
    }

    public CategoriaBean getCategorias_id() {
        return categorias_id;
    }

    public void setCategorias_id(CategoriaBean categorias_id) {
        this.categorias_id = categorias_id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "LibroBean{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", editoriales_id=" + editoriales_id +
                ", autores_id=" + autores_id +
                ", categorias_id=" + categorias_id +
                ", precio=" + precio +
                ", num_pag=" + num_pag +
                ", stock=" + stock +
                '}';
    }
}
