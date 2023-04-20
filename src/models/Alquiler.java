package models;

public class Alquiler {

    private Integer id;
    private Cliente cliente;
    private Pelicula pelicula;
    private String fechaRetiro; //Hacer con LocalDate
    private String fechaDevolucion; //Hacer con LocalDate
    private static int cantAlquileres = 0;
    private boolean devuelto;

    public Alquiler() {
    }

    public Alquiler(Cliente cliente, Pelicula pelicula, String fechaRetiro, String fechaDevolucion) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.id = cantAlquileres++;
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public static int getCantAlquileres() {
        return cantAlquileres;
    }

    public static void setCantAlquileres(int cantAlquileres) {
        Alquiler.cantAlquileres = cantAlquileres;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "Id=" + id +
                ", Cliente=" + cliente.toString() +
                ", Película=" + pelicula.toString() +
                ", FechaRetiro='" + fechaRetiro + '\'' +
                ", FechaDevolucion='" + fechaDevolucion + '\'' +
                '}';
    }
}
