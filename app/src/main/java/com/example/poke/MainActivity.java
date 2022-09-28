package com.example.poke;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public Button botao;
    public Button btnQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQR=(Button) findViewById(R.id.btnQR);
        final Activity activity=this;
        botao =(Button)findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Ver();
            }
        });

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("CAMERA SCAN");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

    public void Ver(){
        Intent it = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(it);
    }

      @Override //QRCODE//
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null){

            if(result.getContents()!=null){
                 alert(result.getContents());
            }
            else{
                alert("cancelado");
            }

        }

        else{
            super.onActivityResult(requestCode,resultCode,data);
        }

    }

    private  void alert(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }




}