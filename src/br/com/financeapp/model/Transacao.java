package br.com.financeapp.model;

import java.time.LocalDate;

public abstract class Transacao {

    protected double valor;
    protected LocalDate data;
    protected String descricao;
    protected Categoria categoria;

    public Transacao(double valor, String descricao, Categoria categoria) {
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data = LocalDate.now();
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public abstract String getTipo();

    public abstract double calcularImpacto();
}
