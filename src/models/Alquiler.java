package models;
import java.time.LocalDate;

public class Alquiler {

    private Integer id;
    private Cliente cliente;
    private Pelicula pelicula;
    private LocalDate fechaRetiro;
    private LocalDate fechaDevolucion;
    private static int cantAlquileres = 0;
    private boolean devuelto;

    public Alquiler() {
    }

    public Alquiler(Cliente cliente, Pelicula pelicula, LocalDate fechaDevolucion) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaRetiro = LocalDate.now();
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.id = cantAlquileres;
        cantAlquileres++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    @Override
    public String toString() {
        return "Alquiler{" +
                "Id=" + id +
                ", Cliente=" + cliente.getNombre() +
                ", Película=" + pelicula.getTitulo() +
                ", FechaRetiro='" + fechaRetiro + '\'' +
                ", FechaDevolucion='" + fechaDevolucion + '\'' +
                ", Devuelta='" + devuelto + '\'' +
                ", ID='" + id + '\'' +
                '}';
    }



}
