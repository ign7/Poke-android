package com.example.poke;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private String name;
    private Sprites sprites;
    private String url;
    private List<Types> types;

    public String getName() {
        return name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public String getUrl() {
        return url;
    }



    public List<Types> getTypes() {
        return types;
    }


    @Override
    public String toString() {
        return " Pokemon {" +
                "name='" + getName() + '\'' +
                ", sprites='" + getSprites().getFront_default() + '\'' +
                ", types=" + getTypes().get(0).getType().getName() +
                '}';
        }
    }
