package br.com.financeapp.model;

import java.util.ArrayList;
import java.util.List;

public class Carteira {

    private List<Transacao> transacoes;

    public Carteira() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public double calcularSaldo() {
        double saldo = 0;

        for (Transacao t : transacoes) {
            saldo += t.calcularImpacto();
        }

        return saldo;
    }

    public void listarTransacoes() {

    if (transacoes.isEmpty()) {
        System.out.println("Nenhuma transação cadastrada.");
        return;
    }

    System.out.println("\n--- Lista de Transações ---");

    for (Transacao t : transacoes) {
        System.out.println(
            t.getTipo() + " | " +
            t.getDescricao() + " | " +
            t.getCategoria().name() + " | " +
            "R$ " + t.getValor()
        );
    }
}


    // 🔥 NOVO: acesso controlado às transações
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
