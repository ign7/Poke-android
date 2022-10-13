package com.example.poke;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Types {

    @SerializedName("type")
    @Expose
    private Type type;

    public Types(Type type){
        this.type= type;
    }

    public Type getType() {
        return type;
    }
}
