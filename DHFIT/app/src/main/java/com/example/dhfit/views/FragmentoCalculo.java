package com.example.dhfit.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhfit.R;
import com.example.dhfit.model.ModeloFragmento;

import static com.example.dhfit.views.CalculoIMC.RESULTADO_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoCalculo extends Fragment {

    private ImageView imageResult;
    private TextView textoResultado;


    public FragmentoCalculo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);
        initView(view);

        if (!getArguments().isEmpty()){
            ModeloFragmento modeloFragmento = getArguments().getParcelable(RESULTADO_KEY);

            if (modeloFragmento != null){
                Drawable drawable = getResources().getDrawable(modeloFragmento.getImagem());

                imageResult.setImageDrawable(drawable);
                textoResultado.setText(modeloFragmento.getTexto());

            }
        }

        return view;
    }

    public void initView(View view){
        imageResult = view.findViewById(R.id.imageResult);
        textoResultado = view.findViewById(R.id.textoResultado);
    }

}
