package entity;

public class Libro {
    private int id;
    private String titulo;
    private String anio_public;
    private double precio;
    private int idAutor; // Aqui se ingresa la llave foranea del autor
    private String autor;

    // Constructor vacio
    public Libro() {
    }

    // Metodo constructor
    public Libro(int id, String titulo, String anioPublicacion, double precio,int idAutor, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.anio_public = anioPublicacion;
        this.precio = precio;
        this.autor = autor;
        this.idAutor = idAutor;
    }

    // getters y selects
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio_public() {
        return anio_public;
    }

    public void setAnio_public(String anioPublicacion) {
        this.anio_public= anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAutor() { return autor;
    }

    public void setAutor(String autor) { this.autor = autor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio_public='" + anio_public + '\'' +
                ", precio=" + precio +
                ", idAutor=" + idAutor +
                '}';
    }

    public String toString(int u) {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio_public='" + anio_public + '\'' +
                ", precio=" + precio +
                ", idAutor=" + idAutor +
                ", autor=" + autor +
                '}';
    }
    public String toStringAdvance(){
        return
                "titulo=' " + titulo + '\'' +
                        ",  anio_public= '" + anio_public + '\'' +
                        ",  precio= " + precio +
                        ",  autor= " + autor;

    }
}
