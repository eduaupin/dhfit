package com.example.dhfit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dhfit.R;

public class SpashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarCadastroActivity();
            }
        }, 2000);
    }

    public void mostrarCadastroActivity(){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }
}
