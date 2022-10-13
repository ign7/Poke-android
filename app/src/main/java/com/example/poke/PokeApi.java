package com.example.poke;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PokeApi {
    @GET(value="pokemon/{id}")
    public Call<Pokemon> ObterListaPokemon(@Path("id") String id);
}
