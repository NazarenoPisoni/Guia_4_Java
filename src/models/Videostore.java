package models;

import java.util.ArrayList;
import java.util.Collections;

public class Videostore {
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();

    public void agregarPelicula(Pelicula nueva) {
        listaPeliculas.add(nueva);
    }
    public void agregarCliente(Cliente nuevo) {
        listaClientes.add(nuevo);
    }
    public Pelicula buscarPelicula(String titulo) {
        boolean flag = false;
        int i = 0;
        Pelicula buscada = null;

        while (i < listaPeliculas.size() && flag == false) {
            if (listaPeliculas.get(i).getTitulo().equals(titulo)) {
                buscada = listaPeliculas.get(i);
                flag = true;
            } else i++;
        }
        return buscada;
    }
    public boolean chequearStock(String titulo) {
        boolean flag = false;
        Pelicula check = buscarPelicula(titulo);

        if (check != null && check.getStock() > 0) {
            flag = true;
        }

        return flag;
    }
    public Cliente buscarCliente(String name) {
        boolean flag = false;
        int i = 0;
        Cliente buscado = null;

        while (i < listaClientes.size() && flag == false) {
            if (listaClientes.get(i).getNombre().equals(name)) {
                buscado = listaClientes.get(i);
                flag = true;
            } else i++;

        }
        return buscado;
    }
    public void agregarAlquiler(Alquiler alquiler) {
        listaAlquileres.add(alquiler);
        buscarPelicula(alquiler.getPelicula().getTitulo()).alquilarPelicula();
    }
    public Alquiler getAlquilerPorId(int id) {
        boolean flag = false;
        int i = 0;
        Alquiler buscado = null;

        while (i < listaAlquileres.size() && flag == false) {
            if (listaAlquileres.get(i).getId() == id) {
                buscado = listaAlquileres.get(i);
                flag = true;
            } else i++;

        }
        return buscado;
    }
    public String getAlquileresPorCliente(String name) {
        String list = "";

        for (Alquiler alquiler : listaAlquileres) {
            if (alquiler.getCliente().getNombre().equals(name)) {
                list += alquiler.toString();
            }
        }
        return list;
    }
    public boolean devolverPeliculaPorId(int id) {
        Alquiler devuelto = getAlquilerPorId(id);
        if(devuelto!=null){
            devuelto.setDevuelto(true);
            buscarPelicula(devuelto.getPelicula().getTitulo()).devolverPelicula();
        }
        return (devuelto!=null);
    }
    public String getPeliculas() {
        return "VideoStore{" +
                "Lista de Películas= " + listaPeliculas+
                '}';
    }

    public String getPelicula(String titulo) {
        String peliculaString;
        if (buscarPelicula(titulo) != null) {
            peliculaString = buscarPelicula(titulo).toString();
        } else peliculaString = "NO SE ENCONTRÓ LA PELICULA";
        return peliculaString;
    }
    public String getClientes() {
        return "VideoStore{" +
                "Lista de Clientes= " + listaClientes +
                '}';
    }
}
