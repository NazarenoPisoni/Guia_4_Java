package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Videostore {
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();

    public void solicitarPelicula(Cliente cliente, Pelicula pelicula){
        if(listaPeliculas.contains(pelicula) && pelicula.getStock() > 0){
            if(listaClientes.contains(cliente)){
                Alquiler boleta = new Alquiler(cliente, pelicula, "19/04/2023", "24/04/2023");
                listaAlquileres.add(boleta);
                pelicula.stock --;
            }
            else{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su Nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese su Teléfono: ");
                String telefono = scanner.nextLine();
                System.out.println("Ingrese su Dirección: ");
                String direccion = scanner.nextLine();

                Cliente cliente1 = new Cliente(nombre, telefono, direccion);
                Alquiler boleta = new Alquiler(cliente1, pelicula, "19/04/2023", "24/04/2023");
                listaAlquileres.add(boleta);
                pelicula.stock --;
            }
        }
    }

    public void devolverPelicula(Alquiler alquiler, Pelicula pelicula){
        if(listaAlquileres.contains(alquiler)){
            listaAlquileres.remove(alquiler);
            pelicula.stock++;
        }
    }

    public void consultarAlquileresVigentes(){
        for(Alquiler boleta : listaAlquileres){
            System.out.println(boleta.toString());
        }
    }
}
