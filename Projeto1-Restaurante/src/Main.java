import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void exibirCardapio(List<Produto> cardapio) {
        System.out.println("\n--CARDÁPIO--\n");
        int index = 1;
        for (Produto produto : cardapio) {
            System.out.println(index++ + ". " + produto);
            if(index == 11 ||index == 17 || index == 22) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opcMenu, opcItens;
        String opcTamanho, opcPedido;

        //Criando a lista que armazena os produtos no cardápio
        List<Produto> cardapio = new ArrayList<>();
        //Criando a lista que armazena apenas os produtos que participaram do rodízio
        List<Produto> rodizio = new ArrayList<>();


        //Criando os itens do Cardápio
            //Hamburguers
        cardapio.add(new Hamburguer("Clássico",25.50,"P M G"));
        cardapio.add(new Hamburguer("Clássico Bacon",26.00,"P M G"));
        cardapio.add(new Hamburguer("Clássico Cheddar",28.90,"P M G"));
        cardapio.add(new Hamburguer("Clássico Vegano",27.50,"P M G"));
        cardapio.add(new Hamburguer("Clássico Frango ",21.00,"P M G"));
        cardapio.add(new Hamburguer("Clássico Kids",19.90,"P M G"));
        cardapio.add(new Hamburguer("Especial com ovo",27.20,"P M G"));
        cardapio.add(new Hamburguer("Especial Barbecue",31.90,"P M G"));
        cardapio.add(new Hamburguer("Especial Queijo Brie",35.90,"P M G"));
        cardapio.add(new Hamburguer("Supreme",42.00,"P M G"));
            //Porções
        cardapio.add(new Porcao("Batata frita","P M G",8.50));
        cardapio.add(new Porcao("Batata frita com bacon","P M G",10.50));
        cardapio.add(new Porcao("Batata frita com cheddar e bacon","P M G",13.50));
        cardapio.add(new Porcao("Anéis de cebolas fritos","P M G",15.00));
        cardapio.add(new Porcao("Iscas de frango","P M G",24.80));
            //Bebidas
        cardapio.add(new Bebida("Água sem gás",5));
        cardapio.add(new Bebida("Água com gás",6.50));
        cardapio.add(new Bebida("Coca-Cola",5));
        cardapio.add(new Bebida("Fanta Laranja",5));
        cardapio.add(new Bebida("Guaraná",5));
        cardapio.add(new Bebida("Suco de uva",4));
            //Adicionais
        cardapio.add(new Adicional("Adicional carne", 7.50));
        cardapio.add(new Adicional("Adicional bacon", 5.50));
        cardapio.add(new Adicional("Adicional cheddar", 3.50));
        cardapio.add(new Adicional("Adicional Frango", 6.00));
        cardapio.add(new Adicional("Adicional ovo", 3.00));
        cardapio.add(new Adicional("Adicional Molho Barbecue", 2.20));

        for (int i = 0; i < 15; i++) {
            rodizio.add(cardapio.get(i));
        }

        //Embaralhar os itens que estão no rodízio
        Collections.shuffle(rodizio);


        do{
        System.out.println("\n--Bem vindo a Chapa Quente--");
        System.out.println("(Escolha a opção que deseja)");
        System.out.println("\n 1.Cardápio \n 2.Rodízio \n 3.Reservar Mesa \n 4.Avaliação \n 5.Sair");
        do {
            opcMenu = scanner.nextInt();

            if(opcMenu > 5 || opcMenu < 1){
                System.out.println("Opção inválida! Informe um número de 1 a 5.");
            }
        } while(opcMenu > 5 || opcMenu < 1);

        switch (opcMenu) {
            case 1:
                //Chamar o método que mostra o cardápio
                exibirCardapio(cardapio);

                //Prosseguir ou não com o pedido
                do {
                    System.out.println("\nDeseja realizar seu pedido? (S ou N)");
                    opcPedido = scanner.nextLine().toUpperCase();

                    if (!opcPedido.equals("S") && !opcPedido.equals("N")) {
                        System.out.println("Opção inválida! Por favor, digite 'S' para sim ou 'N' para não.");
                    }
                } while (!opcPedido.equals("S") && !opcPedido.equals("N"));

                if (!opcPedido.equals("N")) {
                    //Criando a lista que armazenas os itens de um pedido
                    List<Pedido> pedidos = new ArrayList<>();

                    while (true) {
                        exibirCardapio(cardapio);

                        //Escolhe o item ou sai da opc escolha
                        System.out.println("Escolha o número do produto que deseja (ou 0 para finalizar)");
                        opcItens = scanner.nextInt();
                        //Inserir um valor válido
                        if (opcItens < -1 || opcItens > cardapio.size()) {
                            do {
                                System.out.println("Insira um valor válido. De 1 a " + cardapio.size() + ".");
                                opcItens = scanner.nextInt();
                            } while (opcItens < -1 || opcItens > cardapio.size());
                        }
                        //Parar de pedir itens
                        if (opcItens == 0) {
                            break;
                        }

                        Produto produtoEscolhido = cardapio.get(opcItens - 1);

                        if (produtoEscolhido instanceof Hamburguer hamburguer) {
                            System.out.println("Escolha qual o tamanho do(a): " + produtoEscolhido);
                            opcTamanho = scanner.nextLine().toUpperCase();

                            if (!opcTamanho.equals("P") && !opcTamanho.equals("M") && !opcTamanho.equals("G")) {
                                System.out.println("Informe um valor válido (P, M ou G):");
                            }

                            do {
                                opcTamanho = scanner.nextLine().toUpperCase();
                            } while (!opcTamanho.equals("P") && !opcTamanho.equals("M") && !opcTamanho.equals("G"));

                            //Define o tamanho caso seja um hamburguer e já calcula o preço de acordo com o tamanho
                            hamburguer.setTamanho(opcTamanho);
                        } else if (produtoEscolhido instanceof Porcao porcao) {
                            System.out.println("Escolha qual o tamanho do(a): " + produtoEscolhido);
                            opcTamanho = scanner.nextLine().toUpperCase();
                            do {
                                if (!opcTamanho.equals("P") && !opcTamanho.equals("M") && !opcTamanho.equals("G")) {
                                    System.out.println("Informe um valor válido (P, M ou G):");
                                }
                                opcTamanho = scanner.nextLine().toUpperCase();
                            } while (!opcTamanho.equals("P") && !opcTamanho.equals("M") && !opcTamanho.equals("G"));

                            //Define o tamanho caso seja uma porção e já calcula o preço de acordo com o tamanho
                            porcao.setTamanho(opcTamanho);
                        }

                        //Decide quantas unidades serão
                        System.out.println("Informe a quantidade desejada: ");
                        int qtd = scanner.nextInt();

                        //Cria o pedido com o produto e a quantidade desejada
                        pedidos.add(new Pedido(produtoEscolhido, qtd));
                        System.out.println("Produto adicionado ao pedido: " + produtoEscolhido.getNome() + " - " + qtd + "x");


                    }
                    //Resumo do pedido
                    System.out.println("Resumo do seu pedido: ");
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido);
                    }
                    System.out.print("Total final:");
                    double total = 0.0;

                    //Mostra o valor final
                    for (Pedido pedido : pedidos) {
                        double subtotal = pedido.calcularTotal();
                        total += subtotal;
                    }
                    System.out.print(" " + total);

                }
                break;
            case 2:

                System.out.println("Olá, nosso rodízio funciona da seguinte maneira: por R$90.90 você pode comer à vontade os itens que passarão de maneira aleatória por sua mesa.");
                 scanner.nextLine();

                System.out.println("Deseja participar? (S ou N)");
                String opcPedidoRodizio = scanner.nextLine().trim().toUpperCase();

                // Faz a validação caso o input seja inválido
                while (!opcPedidoRodizio.equals("S") && !opcPedidoRodizio.equals("N")) {
                    System.out.println("Opção inválida! Digite apenas 'S' para sim ou 'N' para não.");
                    System.out.println("Deseja participar? (S ou N)");
                    opcPedidoRodizio = scanner.nextLine().trim().toUpperCase();
                }

                if (opcPedidoRodizio.equals("S")) {
                    System.out.println("Bem-vindo ao rodízio! A qualquer momento, digite 'SAIR' para encerrar.");
                    for (Produto item : rodizio) {
                        System.out.println("Item disponível: " + item.getNome());

                        System.out.println("Deseja comer este item? (S/N)");
                        String opcao = scanner.nextLine().trim().toUpperCase();

                        // Opção para sair do rodízio
                        if (opcao.equals("SAIR")) {
                            System.out.println("Você encerrou o rodízio. Obrigado por participar!");
                            break;
                        }

                        while (!opcao.equals("S") && !opcao.equals("N") && !opcao.equals("SAIR")) {
                            System.out.println("Opção inválida! Digite apenas 'S' para sim, 'N' para não ou 'SAIR' para encerrar.");
                            opcao = scanner.nextLine().trim().toUpperCase();
                        }

                        if (opcao.equals("S")) {
                            System.out.println("Você escolheu comer o " + item.getNome() + ". Bom apetite!");
                        } else {
                            System.out.println("Você escolheu não comer o " + item.getNome() + ".");
                        }

                        if (opcao.equals("SAIR")) {
                            System.out.println("Você encerrou o rodízio. Obrigado por participar!");
                            break;
                        }
                    }

                    System.out.println("Rodízio finalizado. Esperamos que tenha gostado!");
                } else {
                    System.out.println("Entendido! Aproveite nosso cardápio à la carte.");
                }

                break;

            case 3:
                System.out.println("Olá gostaria de reservar uma mesa? ");
                scanner.nextLine();
                String opcReservarMesa = scanner.nextLine().trim().toUpperCase();
                // Faz a validação caso o input seja inválido
                while (!opcReservarMesa.equals("S") && !opcReservarMesa.equals("N")) {
                    System.out.println("Opção inválida! Digite apenas 'S' para sim ou 'N' para não.");
                    System.out.println("Deseja reservar? (S ou N)");
                    opcReservarMesa = scanner.nextLine().trim().toUpperCase();
                }

                if (opcReservarMesa.equals("S")) {
                    System.out.println("Por favor, insira seu nome:");
                    String nomeCliente = scanner.nextLine().trim();

                    //Instancia o cliente
                    Cliente cliente = new Cliente(nomeCliente);

                    int numeroMesa = random.nextInt(50) + 1;

                    // Coleta o dia da reserva
                    LocalDate dataReserva;
                    while (true) {
                        try {
                            System.out.println("Informe o dia da reserva (formato: dd/MM/yyyy):");
                            String inputData = scanner.nextLine().trim();
                            DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataReserva = LocalDate.parse(inputData, dataFormatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Data inválida. Tente novamente.");
                        }
                    }

                    // Coleta o horário da reserva
                    LocalTime horarioReserva;
                    while (true) {
                        try {
                            System.out.println("Informe o horário da reserva (formato: HH:mm):");
                            String inputHora = scanner.nextLine().trim();
                            DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");
                            horarioReserva = LocalTime.parse(inputHora, horaFormatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("Horário inválido. Tente novamente.");
                        }
                    }

                    // Combina data e horário em um LocalDateTime
                    LocalDateTime dataHoraReserva = LocalDateTime.of(dataReserva, horarioReserva);


                    // Exibe as informações da reserva
                    System.out.println("\n- Confirmação da Reserva -");
                    System.out.println("Cliente: " + cliente.getNomeCliente());
                    System.out.println("Mesa: " + numeroMesa);
                    System.out.println("Data e Horário: " + dataHoraReserva.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

                    System.out.println("\nObrigado por reservar conosco! Boa refeição.");

                } else {
                    System.out.println("Sem problemas! Voltando ao menu.");
                }
            case 4:
                System.out.println("Obrigado por utilizar nosso serviço! Gostaríamos de saber sua opinião.");

                //Avaliação da qualidade da comida
                int notaComida = 0;
                while (notaComida < 1 || notaComida > 5) {
                    System.out.println("Avalie a qualidade da comida (de 1 a 5 estrelas):");
                    if (scanner.hasNextInt()) {
                        notaComida = scanner.nextInt();
                        if (notaComida < 1 || notaComida > 5) {
                            System.out.println("Por favor, insira um número entre 1 e 5.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Digite um número entre 1 e 5.");
                        scanner.next();
                    }
                }

                //Avaliação da experiência com o sistema
                int notaSistema = 0;
                while (notaSistema < 1 || notaSistema > 5) {
                    System.out.println("Avalie a experiência com o sistema (de 1 a 5 estrelas):");
                    if (scanner.hasNextInt()) {
                        notaSistema = scanner.nextInt();
                        if (notaSistema < 1 || notaSistema > 5) {
                            System.out.println("Por favor, insira um número entre 1 e 5.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Digite um número entre 1 e 5.");
                        scanner.next();
                    }
                }

                scanner.nextLine();

                //Pergunta se o cliente deseja deixar um comentário
                System.out.println("Gostaria de deixar um comentário? (S ou N)");
                String opcaoComentario = scanner.nextLine().trim().toUpperCase();

                String comentario = "";
                if (opcaoComentario.equals("S")) {
                    System.out.println("Por favor, digite seu comentário:");
                    comentario = scanner.nextLine();
                }

                //Exibe o resumo da avaliação
                System.out.println("\nAvaliação registrada com sucesso!");
                System.out.println("Qualidade da comida: " + notaComida + " estrelas");
                System.out.println("Experiência com o sistema: " + notaSistema + " estrelas");

                if (!comentario.isEmpty()) {
                    System.out.println("Comentário: " + comentario);
                } else {
                    System.out.println("Nenhum comentário foi deixado.");
                }

                System.out.println("Agradecemos seu feedback!");
        }
        } while (opcMenu != 5);
        System.out.println("Até mais...!");
    }
}