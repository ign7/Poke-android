package com.example.poke;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {

    @GET("01001000/json/")
    public Call<dtoCEP> recuperarCEP();

}
