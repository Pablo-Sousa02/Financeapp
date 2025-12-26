package br.com.financeapp.model;

public class Despesa extends Transacao {

    public Despesa(double valor, String descricao, Categoria categoria) {
        super(valor, descricao, categoria);
    }

    @Override
    public double calcularImpacto() {
        return -valor;
    }

    @Override
    public String getTipo() {
        return "Despesa";
    }
}
