package models;

public class Pelicula {
    private String titulo;
    private String fecha;
    private String duracion;
    private Audiencia audiencia;
    private Genero genero;
    private String pais;
    private String descripcion;
    Integer stock;


    //region Constructores
    public Pelicula() {
    }

    public Pelicula(String titulo, String fecha, String duracion, Audiencia audiencia, Genero genero, String pais, String descripcion, Integer stock) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.audiencia = audiencia;
        this.genero = genero;
        this.pais = pais;
        this.descripcion = descripcion;
        this.stock = stock;
    }
    //endregion

    //region Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Audiencia getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(Audiencia audiencia) {
        this.audiencia = audiencia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    //endregion

    @Override
    public String toString() {
        return "Pelicula{" +
                "Título='" + titulo + '\'' +
                ", Fecha='" + fecha + '\'' +
                ", Duración='" + duracion + '\'' +
                ", Audiencia=" + audiencia +
                ", País='" + pais + '\'' +
                ", Descripción='" + descripcion + '\'' +
                '}';
    }


}
