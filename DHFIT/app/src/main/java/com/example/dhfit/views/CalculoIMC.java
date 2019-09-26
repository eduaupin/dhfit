package com.example.dhfit.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.dhfit.R;
import com.example.dhfit.interfaces.Comunicador;
import com.example.dhfit.model.ModeloFragmento;

import static com.example.dhfit.views.ResultadoCadastro.IMC_KEY;

public class CalculoIMC extends AppCompatActivity implements Comunicador {

    public static final String RESULTADO_KEY = "resultado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

            replaceFragment(R.id.containerBotoes, new FragmentoBotoes());
            Intent intent = getIntent();
            Bundle dados = intent.getExtras();

            String imc = dados.getString(IMC_KEY);

    }
    public void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void setBundleToFragment(ModeloFragmento modeloFragmento, String CHAVE){
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, modeloFragmento);
        Fragment segundoFragmento = new FragmentoCalculo();
        segundoFragmento.setArguments(bundle);

        replaceFragment(R.id.containerFragmentos, segundoFragmento);

    }

    @Override
    public void receberMensagem(ModeloFragmento modeloFragmento) {
        setBundleToFragment(modeloFragmento, RESULTADO_KEY);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
