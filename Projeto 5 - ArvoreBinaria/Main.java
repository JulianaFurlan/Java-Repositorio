import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a raiz da árvore: ");
        int valorInicial = scanner.nextInt();
        ArvoreBinaria arvore = new ArvoreBinaria(valorInicial);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Remover valor");
            System.out.println("3 - Exibir em ordem");
            System.out.println("4 - Exibir pré-ordem");
            System.out.println("5 - Exibir pós-ordem");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserirRedirecionamento(valorInserir);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.removerRaiz(valorRemover); // vamos criar esse método abaixo
                    break;

                case 3:
                    arvore.emOrdem();
                    break;

                case 4:
                    arvore.preOrdem();
                    break;

                case 5:
                    arvore.posOrdem();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
