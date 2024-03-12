public class Libro {

    // Atributos
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private boolean prestado;

    // metodo constructor (debe tener le mismo nombre de la clase)
    // recibe como argumento todos los atributos de una clase y los guarda

    public Libro(String titulo, String autor, String fechaPublicacion, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.prestado = prestado;
    }


    // Metodos (get y set)

    // get
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return  this.autor;
    }

    public String getFechaPublicacion(){
        return this.fechaPublicacion;
    }

    public boolean getPrestado(){
        return this.prestado;
    }

    // set
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }


    public void cambiarEstado(){
        this.prestado = !this.prestado;
    }
    //
    @Override // decorador: Este metodo esta sobreescrito
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
