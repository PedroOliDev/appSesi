package com.example.appsesi;

public class Presenca {
    private String nome;
    private String dataHora;

    public Presenca(String nome, String dataHora) {
        this.nome = nome;
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public String getDataHora() {
        return dataHora;
    }
}
