package com.example.poke;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PokeApi {
    @GET("pokemon")
   public Call<PokemonResposta> ObterListaPokemon();
}
