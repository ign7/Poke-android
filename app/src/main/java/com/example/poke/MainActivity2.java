package com.example.poke;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

     TextView texto;
     Button voltar;
     ImageView imgpokemon;
     TextView  ListaPokemon;
    private static String TAG = "POKEDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Activity activity=this;
        texto = (TextView) findViewById((R.id.texto));
        voltar=(Button) findViewById(R.id.voltar);
        imgpokemon=(ImageView) findViewById(R.id.imgpokemon);
        ListaPokemon = (TextView) findViewById((R.id.listaPokemon));


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackPage();
            }
        });

        String _nome=getIntent().getStringExtra("nome");
        String _img=getIntent().getStringExtra("ImgUrl");
        String _tipos=getIntent().getStringExtra("tipos");
        String _resultadoID=getIntent().getStringExtra("input");

        texto.setText(_nome);
        Picasso.get()
                .load(_img)
                .into(imgpokemon);
        ListaPokemon.setText(_tipos);
    }


    public void BackPage(){
        Intent back = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(back);
    }


}
