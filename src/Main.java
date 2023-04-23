import models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Videostore videoStore = new Videostore();

        Cliente cliente1 = new Cliente("Nazareno", "2235573669", "Olavarria 2261");
        Cliente cliente2 = new Cliente("María", "2236593578", "Arenales 2746");
        Cliente cliente3 = new Cliente("Rodolfo", "1148592290", "Chacabuco 3742");
        Pelicula peli1 = new Pelicula("El conjuro", "26/08/2013", "118 min.", Audiencia.PG_13.getName(),
                Genero.HORROR.getName(), "EEUU", "Una familia vive en una casa poseída por demonios", 4);
        Pelicula peli2 = new Pelicula("John Wick 4", "22/03/2023", "150 min", Audiencia.NC_17.getName()
            , Genero.ACCION.getName(), "EEUU", "John se enfrenta a su duelo final", 3);
        Pelicula peli3 = new Pelicula("Sin Novedad en el Frente", "14/11/2022", "160 min", Audiencia.R.getName(),
                Genero.ACCION.getName(), "Alemania", "Un soldado alemán trata de sobrevivir a la II Guerra Mundial", 4);
        Pelicula peli4 = new Pelicula("El Padrino", "30/05/1977", "190 min", Audiencia.PG_13.getName(),
                Genero.ACCION.getName(), "EEUU", "Muestra la vida de Vito Corleone y su familia", 8);
        Pelicula peli5 = new Pelicula("Jurassic Park", "03/03/1992", "160 min", Audiencia.G.getName(),
                Genero.AVENTURA.getName(), "EEUU", "Un parque en una isla con Dinosaurios vivos", 5);
        Pelicula peli6 = new Pelicula("El plan perfecto", "22/11/2006", "170 min", Audiencia.PG_13.getName(),
                Genero.ACCION.getName(), "EEUU", "Un grupo de ladrones trata de idear un plan para escapar de un Banco con todo el dinero", 5);
        Pelicula peli7 = new Pelicula("La bruja", "09/06/2014", "140 min", Audiencia.NC_17.getName(),
                Genero.HORROR.getName(), "EEUU", "Una joven de una aldea medieval es acusada de asesinatos", 4);
        Pelicula peli8 = new Pelicula("Batman: el Caballero de la Noche", "14/08/2008", "180 min", Audiencia.PG_13.getName(),
                Genero.ACCION.getName(), "EEUU", "Batman se enfrenta una vez más al Joker", 6);
        Pelicula peli9 = new Pelicula("En busca de la felicidad", "15/09/2007", "160 min", Audiencia.G.getName(),
                Genero.DRAMA.getName(), "EEUU", "Un hombre solo cría a su hijo en una dura realidad", 3);
        Pelicula peli10 = new Pelicula("Una loca entrevista", "11/03/2014", "140 min", Audiencia.PG_13.getName(),
                Genero.COMEDIA.getName(), "EEUU", "Dos entrevistadores norteamericanos tratan de envenenar al lider norcoreano", 2);
        Pelicula peli11 = new Pelicula("Joker", "12/05/2018", "180 min", Audiencia.PG_13.getName(),
                Genero.DRAMA.getName(), "EEUU", "Relata el ascenso del Joker en Gotham", 5);
        Pelicula peli12 = new Pelicula("Relatos Salvajes", "29/06/2014", "140 min", Audiencia.NC_17.getName(),
                Genero.DRAMA.getName(), "Argentina", "Distintas historias violentas y cotidianas", 3);

        videoStore.agregarCliente(cliente1);
        videoStore.agregarCliente(cliente2);
        videoStore.agregarCliente(cliente3);
        videoStore.agregarPelicula(peli1);
        videoStore.agregarPelicula(peli2);
        videoStore.agregarPelicula(peli3);
        videoStore.agregarPelicula(peli4);
        videoStore.agregarPelicula(peli5);
        videoStore.agregarPelicula(peli6);
        videoStore.agregarPelicula(peli7);
        videoStore.agregarPelicula(peli8);
        videoStore.agregarPelicula(peli9);
        videoStore.agregarPelicula(peli10);
        videoStore.agregarPelicula(peli11);
        videoStore.agregarPelicula(peli12);

        menuGral(videoStore);
    }
    public static void menuGral(Videostore video){
        int option;

        Consola.escribir("Bienvenido a Blockbuster");
        do{
            Consola.escribir("-------------");
            Consola.escribir("1.Peliculas");
            Consola.escribir("2.Clientes");
            Consola.escribir("3.Alquileres");
            Consola.escribir("0.Salir");
            option=Consola.leerInt("Ingrese una opcion...");
            Consola.limpiar();
        }while (option>3 || option<0);

        switch (option){
            case 1: menuMovies(video);
                break;
            case 2: menuClients(video);
                break;
            case 3: menuLoans(video);
                break;
            case 0: Consola.escribir("Cerrando");
                break;}
    }

    //region Peliculas
    public static void menuMovies(Videostore video){
        int option;
        do{
            do{
                Consola.escribir("-------------");
                Consola.escribir("1.Agregar peli");
                Consola.escribir("2.Ver lista de pelis");
                Consola.escribir("3.Ver detalles de una peli");
                Consola.escribir("4.Titulos mas alquilados");
                Consola.escribir("5.Titulos mas alquilados por genero");
                Consola.escribir("0.Salir");
                option=Consola.leerInt("Ingrese una opcion...");
                Consola.limpiar();
            }while (option>5 || option<0);

            switch (option){
                case 1: ;
                    agregarPeli(video);
                    break;
                case 2: ;
                    Consola.escribir(video.getPeliculas());
                    break;
                case 3:;
                    Consola.escribir(searchAMovie(video));
                    break;
                case 4:;
                    Consola.escribir(video.getPeliculasMasPopulares());
                    break;
                case 5:
                    Consola.escribir(mostPopularByGenre(video));
                    break;
                case 0: Consola.escribir("Volviendo al menu general");
                    break;}
        }while(option!=0);
        menuGral(video);
    }

    public static void agregarPeli(Videostore video){
        Consola.escribir("Complete los datos de la pelicula que desea agregar");
        String title = Consola.leerString("Ingrese el titulo de la pelicula: ");
        if(video.getPelicula(title)!=null){
            String date = Consola.leerString("Ingrese la fecha de lanzamiento: ");
            String duration = Consola.leerString("Ingrese la duracion de la pelicula: ");
            String audienceRating = pickAAudience();
            String genre = pickAGenre();
            String country = Consola.leerString("Ingrese el pais donde fue producida:");
            String description = Consola.leerString("Ingrese una breve descripcion de la pelicula: ");
            int stock = Consola.leerInt("Ingrese la cantidad inicial de copias con las que cuenta: ");
            Consola.limpiar();
            Pelicula newMovie = new Pelicula(title,date,duration,audienceRating,genre,country,description,stock);
            video.agregarPelicula(newMovie);
            Consola.escribir("Pelicula agregada con exito...");
            menuMovies(video);
        }
    }
    public static String pickAAudience(){
        int option;
        List<Audiencia> audiences= Arrays.asList(Audiencia.values());
        do{
            Consola.escribir("Seleccione la audiencia: ");
            Consola.escribir("1.G");
            Consola.escribir("2.PG");
            Consola.escribir("3.PG-13");
            Consola.escribir("4.R");
            Consola.escribir("5.NC-17");
            Consola.escribir("6.UNRATED");
            option = Consola.leerInt("Ingrese la audiencia deseada: ");
            Consola.limpiar();
            if(option<0 || option >6){
                Consola.escribir("Ingrese una opcion valida...");
            }
        }while(option<0 || option >6);
        return audiences.get(option-1).getName();
    }
    public static String pickAGenre(){
        int option;
        List<Genero> genres= Arrays.asList(Genero.values());
        do{
            Consola.escribir("Seleccione el genero: ");
            Consola.escribir("1.ACCION");
            Consola.escribir("2.AVENTURA");
            Consola.escribir("3.COMEDIA");
            Consola.escribir("4.DRAMA");
            Consola.escribir("5.HORROR");
            Consola.escribir("6.DOCUMENTAL");
            option = Consola.leerInt("Ingrese el genero deseado: ");
            Consola.limpiar();
            if(option<0 || option >6){
                Consola.escribir("Ingrese una opcion valida...");
            }
        }while(option<0 || option >6);
        return genres.get(option-1).getName();
    }
    public static String searchAMovie (Videostore video){
        String salir="";
        String titleS;
        String movie="No se encontro...";
        do{
            titleS = Consola.leerString("Ingrese el titulo que desea buscar: ");
            if(video.buscarPelicula(titleS)!=null){
                movie = video.buscarPelicula(titleS).toString();
            }else{
                Consola.escribir("Pelicula no encontrada...");
                salir = Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return movie;
    }
    public static String mostPopularByGenre(Videostore video){
        String genre = pickAGenre();
        return video.getMasPopularesPorGenero(genre);
    }

    //endregion

    //region Clientes
    public static void menuClients(Videostore video){
        int option;
        do{
            do{
                Consola.escribir("-------------");
                Consola.escribir("1.Agregar cliente");
                Consola.escribir("2.Ver lista de clientes");
                Consola.escribir("3.Ver detalles de un cliente");
                Consola.escribir("4.Ver ultimos 10 alquileres de un cliente");
                Consola.escribir("0.Salir");
                option=Consola.leerInt("Ingrese una opcion...");
                Consola.limpiar();
            }while (option>4 || option<0);

            switch (option){
                case 1: ;
                    addClient(video);
                    break;
                case 2: ;
                    Consola.escribir(video.getClientes());
                    break;
                case 3:;
                    Consola.escribir(searchAClient(video));
                    break;
                case 4:;
                    Consola.escribir(getLast10byClient(video));
                    break;
                case 0: Consola.escribir("Volviendo al menu general");
                    break;}}while(option!=0);
        menuGral(video);
    }
    public static void addClient(Videostore video){
        String name = Consola.leerString("Ingrese el nombre completo del cliente.");
        String number = Consola.leerString("Ingrese el numero telefonico del cliente");
        String adress = Consola.leerString("Ingrese la direccion del cliente: ");
        Cliente cliente = new Cliente(name,number,adress);
        video.agregarCliente(cliente);
    }
    public static String searchAClient (Videostore video){
        String salir="";
        String nameS;
        String client="No se encontro...";
        do{
            nameS = Consola.leerString("Ingrese el nombre del cliente que desea buscar: ");
            if(video.buscarCliente(nameS)!=null){
                client = video.buscarCliente(nameS).toString();
            }else{
                Consola.escribir("Cliente no encontrado...");
                salir = Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return client;
    }
    public static String getLast10byClient(Videostore video){
        String salir="";
        String nameS;
        String last10="No se encontro...";
        do{
            nameS = Consola.leerString("Ingrese el nombre del cliente que desea buscar: ");
            if(video.buscarCliente(nameS)!=null){
                last10 =video.getUltimos10PorCliente(nameS);
            }else{
                Consola.escribir("Cliente no encontrado...");
                salir=Consola.leerString("introduzca ´s´ para intentar de nuevo");
            }
        }while(salir.equals("s"));
        return last10;
    }

    //endregion

    //region Alquileres

    public static void menuLoans(Videostore video){
        int option;
        do{
            do{
                Consola.escribir("-------------");
                Consola.escribir("1.Crear Alquiler");
                Consola.escribir("2.Ver alquileres vigentes");
                Consola.escribir("3.Ver alquileres que deberian devolverse hoy");
                Consola.escribir("4.Devolver alquiler.");
                Consola.escribir("0.Salir");
                option=Consola.leerInt("Ingrese una opcion...");
                Consola.limpiar();
            }while (option>5 || option<0);

            switch (option){
                case 1: ;
                    addLoan(video);
                    break;
                case 2: ;
                    Consola.escribir(video.getAlquileresActivos());
                    break;
                case 3:;
                    Consola.escribir(video.getAlquileresPorHoy());
                    break;
                case 4:
                    returnLoan(video);
                    break;
                case 0: Consola.escribir("Volviendo al menu general");
                    break;}}while(option!=0);
        menuGral(video);
    }
    public static void addLoan(Videostore video){
        Consola.escribir("Alquiler: ");
        Pelicula movie = null;
        Cliente client = null;
        int option = 0;
        int day,month,year;
        do{
            String titleS=Consola.leerString("Ingrese el titulo de la pelicula que desea alquilar");
            movie = video.buscarPelicula(titleS);
            if(movie==null){
                Consola.escribir("Pelicula no encontrada, intente de nuevo.");
            }else if(!video.chequearStock(titleS)){
                Consola.escribir("La pelicula no cuenta con stock en este momento... Intente con otra...");
                movie = null;
            }
        }while(movie==null);

        do{
            String nameS = Consola.leerString("Ingrese el nombre del cliente que alquila: ");
            client = video.buscarCliente(nameS);
            if(client == null){

                do{
                    Consola.escribir("Cliente no encontrado...");
                    Consola.escribir("1.Intentar de nuevo.");
                    Consola.escribir("2.Agregar a la base.");
                    option = Consola.leerInt("Ingrese la opcion deseada: ");
                    Consola.limpiar();
                    if(option!=1 || option!=2){
                        Consola.escribir("Ingrese una opcion valida...");
                    }else if(option == 2){
                        client = addClient(video,nameS);
                        Consola.escribir("Cliente agregado con exito...");
                    }
                }while(option>2 || option<1);
            }
        }while(client == null);
        day = Consola.leerInt("Ingrese el dia a devolver...");
        month = Consola.leerInt("Ingrese el mes...");
        year = Consola.leerInt("Ingrese el año...");

        Alquiler loan = new Alquiler(client, movie, LocalDate.of(year,month,day));
        video.agregarAlquiler(loan);
    }
    public static Cliente addClient(Videostore video, String name){
        String number = Consola.leerString("Ingrese el numero telefonico del cliente");
        String adress = Consola.leerString("Ingrese la direccion del cliente: ");
        Cliente cliente = new Cliente(name,number,adress);
        video.agregarCliente(cliente);
        return cliente;
    }
    public static void returnLoan(Videostore video) {
        int option;
        do {
            Consola.escribir(video.getAlquileresActivos());
            option = Consola.leerInt("Ingrese el id del alquiler que desea devolver...");
        }while(!video.devolverPeliculaPorId(option));
        if(video.getAlquilerPorId(option).isDevuelto()){
            Consola.escribir("Alquiler devuelto con exito!");
        }
    }
}