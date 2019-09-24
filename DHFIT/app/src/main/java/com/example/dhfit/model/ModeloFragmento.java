package com.example.dhfit.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModeloFragmento implements Parcelable {
    private int imagem;
    private String texto;

    //construtor
    public ModeloFragmento(int imagem, String texto) {
        this.imagem = imagem;
        this.texto = texto;
    }

    public ModeloFragmento() {
    }

    //getters and Setters


    protected ModeloFragmento(Parcel in) {
        imagem = in.readInt();
        texto = in.readString();
    }

    public static final Creator<ModeloFragmento> CREATOR = new Creator<ModeloFragmento>() {
        @Override
        public ModeloFragmento createFromParcel(Parcel in) {
            return new ModeloFragmento(in);
        }

        @Override
        public ModeloFragmento[] newArray(int size) {
            return new ModeloFragmento[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(texto);
        parcel.writeInt(imagem);
    }
}
