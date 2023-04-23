package models;
import java.time.LocalDate;

public class Pelicula implements Comparable<Pelicula>{
    private String titulo;
    private String fechaLanzamiento;
    private String duracion;
    private String audiencia;
    private String genero;
    private String pais;
    private String descripcion;
    private int stock;
    private int alquileres;


    public Pelicula() {
    }

    public Pelicula(String titulo, String fechaLanzamiento, String duracion, String audiencia, String genero, String pais, String descripcion, int stock) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.duracion = duracion;
        this.audiencia = audiencia;
        this.genero = genero;
        this.pais = pais;
        this.descripcion = descripcion;
        this.stock = stock;
        this.alquileres = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(String audiencia) {
        this.audiencia = audiencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(int alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "Título='" + titulo + '\'' +
                ", Fecha de Lanzamiento='" + fechaLanzamiento + '\'' +
                ", Duración='" + duracion + '\'' +
                ", Audiencia='" + audiencia + '\'' +
                ", Genero='" + genero + '\'' +
                ", País='" + pais + '\'' +
                ", Descripción='" + descripcion + '\'' +
                ", Stock=" + stock +
                ", Alquileres=" + alquileres +
                '}';
    }
    public boolean alquilarPelicula() {
        boolean flag = false;

        if (stock > 0) {
            stock--;
            alquileres++;
            flag = true;
        }
        return flag;
    }
    public void devolverPelicula(){
        stock++;
    }

    @Override
    public int compareTo(Pelicula peli) {
        int i;
        if(this.alquileres<peli.getAlquileres() || peli==null)
            i=1;
        else if (this.alquileres==peli.getAlquileres())
            i=0;
        else
            i=-1;
        return i;
    }
}
