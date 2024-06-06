import java.util.Scanner;

//ALUNA: JULIANA FURLAN COSTA

public class Vetores {
    public static void main(String[] args) {
        int tamanho, valor1, valor2, pos1, pos2, media;
        int soma = 0;
        int soma2 = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, informe um valor para o tamanho do vetor: ");
        tamanho = scanner.nextInt();

        while (tamanho <= 0) { //impossibilidade de um valor negativo
            do {
                System.out.println("Por favor, informe um número positivo e inteiro:");
                tamanho = scanner.nextInt();
            } while (tamanho <= 0);
        }
        int[] vet1 = new int [tamanho]; // declarção do vetor

        System.out.println("Agora, preencha as posições com números: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Informe o valor do " + (i + 1) + "° : ");
            vet1[i] = scanner.nextInt();
        } // preenchimento dos espaços

        for (int i = 0; i < tamanho; i++) {
            System.out.print(vet1[i] + " ");
            soma = soma + vet1[i];
        } // soma dos valores

        System.out.print("\nA soma de todos os valores é: " + soma);

        media = soma / tamanho;
        System.out.print("\nA média de todos os valores é: " + media);

        int maior = vet1[0]; // inicializar a variável do maior número
        for (int i = 1; i < tamanho; i++) {
            if (vet1[i] > maior) {
                maior = vet1[i];
            }
        } 
        System.out.print("\nO maior valor presente no vetor é: " + maior);

        int menor = vet1[0]; // inicializar a variável do maior número
        for (int i = 1; i < tamanho; i++) {
            if (vet1[i] < menor) {
                menor = vet1[i];
            }
        }
        System.out.println("\nO menor valor presente no vetor é: " + menor);

        // Substituir o valor de 2 posições específicas:
        System.out.print("\nInforme a primeira posição a ser substituída (1 a " + tamanho + "): ");
        pos1 = scanner.nextInt() - 1; // i = n − 1

        if (pos1 < 0 || pos1 >= tamanho) {
             // valor válido
                do {
                    System.out.print("Por favor, informe um valor de (1 a " + tamanho + "): ");
                    pos1 = scanner.nextInt() - 1;
                } while (pos1 < 0 || pos1 >= tamanho);
        }

        System.out.print("\nInforme o novo valor para a posição " + (pos1 + 1) + ": ");
        valor1 = scanner.nextInt();


        System.out.print("\nInforme a segunda posição a ser substituída (1 a " + tamanho + "): ");
        pos2 = scanner.nextInt() - 1; // i = n - i


        if (pos2 < 0 || pos2 >= tamanho) {
            // valor válido
            do {
                System.out.print("Por favor, informe um valor de (1 a " + tamanho + "): ");
                pos2 = scanner.nextInt() - 1;
            } while (pos2 < 0 || pos2 >= tamanho);
        }

            System.out.print("\nInforme o novo valor para a posição " + (pos2 + 1) + ": ");
            valor2 = scanner.nextInt();

            // Substituir os valores nas posições especificadas
            vet1[pos1] = valor1;
            vet1[pos2] = valor2;

            for (int i = 0; i < tamanho; i++) {
                System.out.print(vet1[i] + " ");
                soma2 = soma2 + vet1[i];
            }
            System.out.print("\nA soma de todos os novos valores é: " + soma2);

            media = soma2 / tamanho;
            System.out.print("\nA média de todos os novos valores é: " + media);

        }
    }
