package com.example.poke;

public class Pokemon {

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public String toString() {
        return "PokemonResposta{" +" nome = "+name+" url "+url;
    }

}
