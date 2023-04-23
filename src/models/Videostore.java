package models;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

public class Videostore {
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Alquiler> listaAlquileres = new ArrayList<>();

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
    public String getCliente(String name) {
        String clienteString;
        if (buscarCliente(name) != null) {
            clienteString = buscarCliente(name).toString();
        } else clienteString = "NO SE ENCONTRÓ EL CLIENTE";
        return clienteString;
    }

    public String getAlquileresActivosPorCliente(String name){
        String list="";

        for(Alquiler alquiler : listaAlquileres){
            if(alquiler.getCliente().getNombre().equals(name) && !alquiler.isDevuelto()){
                list+=alquiler.toString();
            }
        }
        return list;
    }
    public String getUltimos10PorCliente(String name){
        String list = "";
        if (buscarCliente(name) != null) {
            int i = listaAlquileres.size()-1 ;
            int j = 0;
            while (i >=0 && j < 10) {
                if (listaAlquileres.get(i).getCliente().getNombre().equals(name)) {
                    j++;
                    list += listaAlquileres.get(i).toString();
                }
                i--;
            }

        }return list;
    }
    public String getAlquileresPorHoy(){
        String list="";
        for(Alquiler alquiler : listaAlquileres){
            if(alquiler.getFechaDevolucion().equals(LocalDate.now())){
                list+=alquiler.toString();
            }
        }
        return list;
    }
    public String getAlquileres() {
        return "VideoStore{" +
                "Lista de Alquileres= " + listaAlquileres +
                '}';
    }
    public String getAlquileresActivos() {
        String list = "";

        for (Alquiler alquiler : listaAlquileres) {
            if (!alquiler.isDevuelto()) {
                list += alquiler.toString();
            }
        }
        return list;
    }
    public String getPeliculasMasPopulares(){
        String list="";
        Collections.sort(listaPeliculas);
        if(listaPeliculas.size()<=3){
            list=listaPeliculas.toString();
        }else {
            for(int i=0;i<3;i++){
                list+=listaPeliculas.get(i).toString();
            }
        }
        return list;
    }
    public String getMasPopularesPorGenero(String genero){
        ArrayList<Pelicula> masPopulares = new ArrayList<>();
        String list;
        for (Pelicula peli : listaPeliculas){
            if(peli.getGenero().equals(genero)){
                masPopulares.add(peli);
            }
        }
        Collections.sort(masPopulares);
        list = masPopulares.toString();
        return list;
    }
}
