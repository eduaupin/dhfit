package com.example.dhfit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhfit.R;

import static com.example.dhfit.views.CadastroActivity.ALTURA_KEY;
import static com.example.dhfit.views.CadastroActivity.IDADE_KEY;
import static com.example.dhfit.views.CadastroActivity.NOME_KEY;
import static com.example.dhfit.views.CadastroActivity.PESO_KEY;

public class ResultadoCadastro extends AppCompatActivity {
    private TextView bemvindoText;
    private TextView idadeText;
    private TextView pesoText;
    private TextView alturaText;
    private Button btnVamosLa;

    public static final String IMC_KEY = "imc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cadastro);

        bemvindoText = findViewById(R.id.bemvindoText);
        idadeText = findViewById(R.id.idadeText);
        pesoText = findViewById(R.id.pesoText);
        alturaText = findViewById(R.id.alturaText);
        btnVamosLa = findViewById(R.id.btnVamosLa);

        Intent intent = getIntent();
        Bundle dados = intent.getExtras();

        String nome = dados.getString(NOME_KEY);
        int idade = Integer.parseInt(dados.getString(IDADE_KEY));
        double peso = Double.parseDouble(dados.getString(PESO_KEY));
        double altura = Double.parseDouble(dados.getString(ALTURA_KEY));

            bemvindoText.setText("Seja bem vindo "+ nome + "! Esse é um aplicativo que te ajuda a saber e calcular o seu Indice de Massa Corporal");
            idadeText.setText("Idade: "+idade);
            pesoText.setText("Peso: " + peso + "KG");
            alturaText.setText("Altura: "+ altura + "m");

        double imc = peso/(altura*altura);
        String resultadoIMC = "";
        if (imc < 17.0) {
            resultadoIMC = "Seu IMC está abaixo de 17 e sua classificação é MUITO ABAIXO DO PESO";
        }
        if (imc > 17.0 && imc < 18.49) {
            resultadoIMC = "Seu IMC está entre 17 e 18,49 e sua classificação é ABAIXO DO PESO";
        }
        if (imc >= 18.5 && imc < 24.99) {
            resultadoIMC = "Seu IMC está entre 18,5 e 24,99 e sua classificação é PESO NORMAL";
        }
        if (imc >= 25.0 && imc < 29.99) {
            resultadoIMC = "Seu IMC está entre 25 e 29,99 e sua classificação é ACIMA DO PESO";
        }
        if (imc >= 30 && imc < 34.99) {
            resultadoIMC = "Seu IMC está entre 30 e 34.99 e sua classificação é OBESIDADE 1";
        }
        if (imc >= 35.0 && imc < 39.99) {
            resultadoIMC = "Seu IMC está entre 35 e 39,99 e sua classificação é OBESIDADE 2";
        }
        if (imc >= 40) {
            resultadoIMC = "Seu IMC está acima de 40 e sua classificação é OBESIDADE MORBIDA";
        }

        String finalResultadoIMC = resultadoIMC;
        btnVamosLa.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, CalculoIMC.class);
            Bundle levaImc = new Bundle();
            levaImc.putString(IMC_KEY, finalResultadoIMC);

            intent1.putExtras(levaImc);
            startActivity(intent1);
        });


    }
}
