package br.com.financeapp.model;

public class Receita extends Transacao {

    public Receita(double valor, String descricao, Categoria categoria) {
        super(valor, descricao, categoria);
    }

    @Override
    public double calcularImpacto() {
        return valor;
    }

    @Override
    public String getTipo() {
        return "Receita";
    }
}
