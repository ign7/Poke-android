package com.example.poke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

     Button botao;
     String nome;
     String ImgUrl;
     String tipos;
     String results;
     EditText input;

    private static String TAG = "POKEDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity activity=this;
        botao =(Button)findViewById(R.id.botao);
        input= (EditText)findViewById(R.id.input);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results=(input.getText().toString());
                new FetchData().start();
                //Ver();
            }
        });
    }

    public void Ver(){
        Intent it = new Intent(MainActivity.this, MainActivity2.class);
        it.putExtra("nome",nome);
        it.putExtra("ImgUrl",ImgUrl);
        it.putExtra("tipos",tipos);
        it.putExtra("input",input.getText());
        startActivity(it);
    }

    class FetchData extends Thread{

        public synchronized void run(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                PokeApi service = retrofit.create(PokeApi.class);
                Call<Pokemon> pokCall = service.ObterListaPokemon(results);
                pokCall.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if (response.isSuccessful()) {
                            Pokemon pp = response.body();
                            for (int i = 0; i < pp.getTypes().size(); i++) {
                                Log.i(TAG, "RESULTS : " + pp.getName());
                                nome=pp.getName();
                                ImgUrl=pp.getSprites().getFront_default();
                                tipos=pp.getTypes().get(0).getType().getName();
                            }
                            Ver();
                        }
                    }
                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.e(TAG, "ERRO,ERRO ERRO ERRO ERRRO");
                    }
                });
        }
    }









}