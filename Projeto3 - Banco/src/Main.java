import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opc;
        String nomeBasico, nomePremium;
        double valorDeposito, valorSaque, valorTransferencia;
        double valorDepositoP, valorSaqueP, valorTransferenciaP;

        //Criar uma conta nova
        System.out.println("Qual o nome do titular da conta básica? ");
        nomeBasico = scanner.next();
        System.out.println("Qual o nome do titular da conta premium? ");
        nomePremium = scanner.next();
        ContaBasic minhaContaBasic = new ContaBasic(nomeBasico);
        Conta minhaContaPremium = new ContaPremium(nomePremium);

        //Repetir o menu após realizar uma ação
        do {
            System.out.println("\n -- MENU DE OPÇÕES -- ");
            System.out.println(" 1. Depositar na Conta Básica \n 2. Sacar da Conta Básica \n 3. Transferir da Conta Básica para a Conta Premium \n 4. Depositar na Conta Premium \n 5. Sacar da Conta Premium \n 6. Transferir da Conta Premium para a Conta Básica \n 7. Mostrar Saldo \n 8. Sair \n");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Quanto deseja depositar? ");
                    valorDeposito = scanner.nextDouble();
                    minhaContaBasic.depositar(valorDeposito);
                    System.out.println("Valor depositado: " + valorDeposito);
                    System.out.println("Saldo atual: " + minhaContaBasic.getSaldo());
                    break;
                case 2:
                    System.out.println("Quanto deseja sacar? ");
                    valorSaque = scanner.nextDouble();
                    try {
                        minhaContaBasic.sacar(valorSaque);
                        System.out.println("Valor sacado: " + valorSaque);
                        System.out.println("Saldo atual: " + minhaContaBasic.getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Quanto deseja transferir da conta básica para a conta premium (titular: " + minhaContaPremium.getTitular() + ") ?");
                    valorTransferencia = scanner.nextDouble();
                    try {
                        minhaContaBasic.transferir(valorTransferencia, minhaContaPremium);
                        System.out.println("Valor transferido: " + valorTransferencia + " para " + minhaContaPremium.getTitular());
                        System.out.println("Saldo atual: " + minhaContaBasic.getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Quanto deseja depositar? ");
                    valorDepositoP = scanner.nextDouble();
                    minhaContaPremium.depositar(valorDepositoP);
                    System.out.println("Valor depositado: " + valorDepositoP);
                    System.out.println("Saldo atual: " + minhaContaPremium.getSaldo());
                    break;
                case 5:
                    System.out.println("Quanto deseja sacar? ");
                    valorSaqueP = scanner.nextDouble();
                    try {
                        minhaContaBasic.sacar(valorSaqueP);
                        System.out.println("Valor sacado: " + valorSaqueP);
                        System.out.println("Saldo atual: " + minhaContaPremium.getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Quanto deseja transferir da conta premium para a conta básica (titular: " + minhaContaBasic.getTitular() + ") ?");
                    valorTransferenciaP = scanner.nextDouble();
                    try {
                        minhaContaPremium.transferir(valorTransferenciaP, minhaContaBasic);
                        System.out.println("Valor transferido: " + valorTransferenciaP + " para " + minhaContaBasic.getTitular());
                        System.out.println("Saldo atual: " + minhaContaPremium.getSaldo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Saldo na conta básica: " + minhaContaBasic.getSaldo());
                    System.out.println("Saldo na conta premium: " + minhaContaPremium.getSaldo());
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                    break;
            }

        } while (opc > 0 && opc < 9);

    }

}