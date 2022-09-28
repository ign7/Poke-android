package com.example.poke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    public Button btn;
    public TextView texto;
    private static String TAG="POKEDEX";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn =(Button)findViewById(R.id.btn);
        texto =(TextView)findViewById((R.id.texto));


        /*OkHttpClient client = new OkHttpClient();
        String Url ="https://pokeapi.co/api/v2/";
        Request request= new Request.Builder()
                .url(Url)
                .build();*/

       /* OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        okhttpbuilder.addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {

                  Request request =chain.request();
                Request.Builder newRequest = request.newBuilder().header("authorization", "secretkey");

                return chain.proceed(newRequest.build());
            }
        });*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                //.baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               PokeApi service = retrofit.create(PokeApi.class);
                Call<PokemonResposta> pokCall = service.ObterListaPokemon();

                pokCall.enqueue(new Callback<PokemonResposta>() {
                    @Override
                    public void onResponse(Call<PokemonResposta> call, Response<PokemonResposta> response) {
                         if(response.isSuccessful()){
                        PokemonResposta pokemonResposta = response.body();
                        ArrayList<Pokemon> Pokedex = pokemonResposta.getResults();

                        for (int i = 0; i < Pokedex.size(); i++){
                            Pokemon p=Pokedex.get(i);
                            Log.i(TAG,"pokemon"+p.getName());
                            texto.setText(p.toString());
                        }
                       }
                    }
                    @Override
                    public void onFailure(Call<PokemonResposta> call, Throwable t) {
                        Log.e(TAG,"erro,ERRO ERRO ERRO ERRRO");
                    }
                });

               /* CEPService cepService=retrofit.create(CEPService.class);
                Call<dtoCEP> cepCall=cepService.recuperarCEP();

                cepCall.enqueue(new Callback<dtoCEP>() {
                    @Override
                    public void onResponse(Call<dtoCEP> call, Response<dtoCEP> response) {
                        dtoCEP ddd =response.body();
                        texto.setText(ddd.toString());
                    }

                    @Override
                    public void onFailure(Call<dtoCEP> call, Throwable t) {
                        Log.e(TAG,"erro,ERRO ERRO ERRO ERRRO");
                    }
                });*/

            }
        });
    }

  }