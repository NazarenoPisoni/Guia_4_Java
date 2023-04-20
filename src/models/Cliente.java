package models;
import java.util.Random;

public class Cliente {
    public String getVariableAleatoria() {

        Random aleatorio = new Random();
        String variableAleatoria = "";

        // Genera 8 caracteres aleatorios (4 letras y 4 números)
        for (int i = 0; i < 4; i++) {
            // Genera una letra aleatoria (mayúscula o minúscula)
            char letra = (char) (aleatorio.nextInt(26) + 'a');
            if (aleatorio.nextBoolean()) {
                letra = Character.toUpperCase(letra);
            }
            // Genera un número aleatorio
            int numero = aleatorio.nextInt(10);

            // Concatena la letra y el número generados a la cadena
            variableAleatoria += letra + String.valueOf(numero);

        }
        return variableAleatoria;
    }
    private String id;
    private String nombre;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String direccion) {
        this.id = getVariableAleatoria();
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Dirección='" + direccion + '\'' +
                '}';
    }
}
