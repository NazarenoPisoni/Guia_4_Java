package models;

public enum Audiencia {
    G("G"),PG("PG"),PG_13("PG-13"),R("R"),NC_17("NC-17"),UNRATED("UNRATED");

    private String name;
    Audiencia(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
