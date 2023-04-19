package models;

public class Pelicula {
    private String titulo;
    private String fecha;
    private String duracion;
    private Audiencia audiencia;
    private String pais;
    private String descripcion;
    private static int cantAlquileres = 0;


    //region Constructores
    public Pelicula() {
    }

    public Pelicula(String titulo, String fecha, String duracion, Audiencia audiencia, String pais, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.audiencia = audiencia;
        this.pais = pais;
        this.descripcion = descripcion;
        cantAlquileres++;
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

    public static int getCantAlquileres() {
        return cantAlquileres;
    }

    public static void setCantAlquileres(int cantAlquileres) {
        Pelicula.cantAlquileres = cantAlquileres;
    }
    //endregion

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", duracion='" + duracion + '\'' +
                ", audiencia=" + audiencia +
                ", pais='" + pais + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
