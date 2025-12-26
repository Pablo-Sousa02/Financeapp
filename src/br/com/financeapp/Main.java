package br.com.financeapp;

import br.com.financeapp.model.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Carteira carteira = new Carteira();
            
            int opcao = -1;
            
            while (opcao != 0) {
                
                System.out.println("\n=== FinanceApp ===");
                System.out.println("1 - Adicionar Receita");
                System.out.println("2 - Adicionar Despesa");
                System.out.println("3 - Listar Transações");
                System.out.println("4 - Ver Saldo");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpa buffer
                
                switch (opcao) {
                    
                    case 1 -> adicionarReceita(scanner, carteira);
                    
                    case 2 -> adicionarDespesa(scanner, carteira);
                    
                    case 3 -> carteira.listarTransacoes();
                    
                    case 4 -> System.out.println(
                            "Saldo atual: R$ " + carteira.calcularSaldo()
                    );
                    
                    case 0 -> System.out.println("Saindo do sistema...");
                    
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    }

    // ===== MÉTODOS AUXILIARES =====

    private static void adicionarReceita(Scanner scanner, Carteira carteira) {

        System.out.print("Descrição da receita: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor da receita: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Categoria categoria = escolherCategoria(scanner);

        carteira.adicionarTransacao(
                new Receita(valor, descricao, categoria)
        );

        System.out.println("Receita adicionada com sucesso!");
    }

    private static void adicionarDespesa(Scanner scanner, Carteira carteira) {

        System.out.print("Descrição da despesa: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor da despesa: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Categoria categoria = escolherCategoria(scanner);

        carteira.adicionarTransacao(
                new Despesa(valor, descricao, categoria)
        );

        System.out.println("Despesa adicionada com sucesso!");
    }

    private static Categoria escolherCategoria(Scanner scanner) {

        Categoria[] categorias = Categoria.values();

        System.out.println("Escolha a categoria:");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println(i + " - " + categorias[i].name());
        }

        int escolha;

        while (true) {
            System.out.print("Digite o número da categoria: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha >= 0 && escolha < categorias.length) {
                break;
            }

            System.out.println("Categoria inválida. Tente novamente.");
        }

        return categorias[escolha];
    }
}
