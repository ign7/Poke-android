package com.example.poke;


import java.util.ArrayList;

public class PokemonResposta {

    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "PokemonResposta{" + "results="+ results;
    }
}
