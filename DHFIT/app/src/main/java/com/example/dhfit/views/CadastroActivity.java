package com.example.dhfit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.dhfit.R;

public class CadastroActivity extends AppCompatActivity {
    private Button btnComecar;
    private EditText textNome;
    private EditText textIdade;
    private EditText textPeso;
    private EditText textAltura;

    //CHAVES
    public static final String NOME_KEY = "nome";
    public static final String IDADE_KEY = "idade";
    public static final String PESO_KEY = "peso";
    public static final String ALTURA_KEY = "altura";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnComecar = findViewById(R.id.btnComecar);
        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);
        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);

        btnComecar.setOnClickListener(view->{
            if(!textNome.getText().toString().isEmpty() && !textAltura.getText().toString().isEmpty() && !textIdade.getText().toString().isEmpty() && !textPeso.getText().toString().isEmpty()){


                //atribuicao de variavel para bundle
                String nomeUser = textNome.getText().toString();
                String idadeUser = textIdade.getText().toString();
                String pesoUser = textPeso.getText().toString();
                String alturaUser = textAltura.getText().toString();

                Bundle dados = new Bundle();
                dados.putString(NOME_KEY, nomeUser);
                dados.putString(IDADE_KEY, idadeUser);
                dados.putString(PESO_KEY, pesoUser);
                dados.putString(ALTURA_KEY, alturaUser);

                Intent intent = new Intent(this, ResultadoCadastro.class);
                intent.putExtras(dados);
                startActivity(intent);



            }else{
                textNome.setError("Campo obrigatório!");
                textIdade.setError("Campo obrigatório!");
                textPeso.setError("Campo obrigatório!");
                textAltura.setError("Campo obrigatório!");
            }
        });

    }
}
