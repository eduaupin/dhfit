package com.example.dhfit.views;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dhfit.R;
import com.example.dhfit.interfaces.Comunicador;
import com.example.dhfit.model.ModeloFragmento;

import static com.example.dhfit.views.ResultadoCadastro.IMC_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoBotoes extends Fragment {

    private Button btnCalculo;
    private Button btnInfo;
    private Comunicador comunicador;

    public FragmentoBotoes() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            comunicador = (Comunicador) context;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botoes_info, container, false);
        initViews(view);

        Bundle bundle = this.getArguments();
        String imcfinal = bundle.getString(IMC_KEY);

        btnCalculo.setOnClickListener(view1 -> {

            ModeloFragmento calcularIMC = new ModeloFragmento(R.drawable.famale, IMC_KEY);
            comunicador.receberMensagem(calcularIMC);

        });

        btnInfo.setOnClickListener(view1 -> {
            ModeloFragmento informacoes = new ModeloFragmento(R.drawable.lamp, "O cálculo do IMC é feito dividindo o peso (em quilogramas) pela altura (em metros) ao quadrado. De acordo com a tabela de IMC, você está no seu peso ideal.");
            comunicador.receberMensagem(informacoes);
        });

        return view;
    }

    public void initViews(View view){
        btnCalculo = view.findViewById(R.id.btnCalculo);
        btnInfo = view.findViewById(R.id.btnInfo);
    }



}
