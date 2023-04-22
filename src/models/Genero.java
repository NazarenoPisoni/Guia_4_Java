package models;

public enum Genero {
    ACCION("Accion"),AVENTURA("Aventura"),COMEDIA("Comedia"),DRAMA("Drama"),HORROR("Horror"),DOCUMENTAL("Documental");
    private String name;

    private Genero(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
