
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc, opcSwitch1, opcSwitch2, opcAtaque, opcAlvo, opcCuriosidade;
        double resultadoAtaque;
        Pokemon atacante;
        Pokemon alvo;
        Pokemon escolhido;

        //Criando instância do Charmander
        Charmander charmander = new Charmander("Charmander", 1000, 300,"Fogo", "Charizard");
        Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", 3000, 50,"Folha","Ivysaur");
        Squirtle squirtle = new Squirtle("Squirtle",2300,170,"Água","Wartortle");

        boolean continuar  = true;


        while (continuar) {
            System.out.println("--ESCOLHA:--");
            System.out.println(" 1- Ver pokemons \n 2- Atacar \n 3- Curiosidade \n 4- Sair \n ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    //Ver os Pokemons
                    boolean verPokemons = true;
                    while (verPokemons) {
                        //Escolher qual pokemon quer
                        System.out.println("--VEJA SEUS POKEMONS--");
                        System.out.println(" 1- " + charmander.getNome() + " \n 2- " + bulbasaur.getNome() + " \n 3- " + squirtle.getNome());
                        opcSwitch1 = scanner.nextInt();

                        switch (opcSwitch1) {
                            //Caso charmander
                            case 1:
                                System.out.println(charmander.exibirInformacoes());
                                System.out.println("\n--OPÇÕES--\n 1-Trocar de pokemon\n 2-Evoluir pokemon\n 3-Avançar");
                                opcSwitch2 = scanner.nextInt();
                                switch (opcSwitch2) {
                                    //Refazendo a escolha
                                    case 1:
                                        System.out.println("trocando de pokemon...\n");
                                        break;
                                    //Evoluindo o pokemon escolhido
                                    case 2:
                                        charmander.setEvolucao("Charizard");
                                        charmander.setNome("Charizard");
                                        charmander.setVida(2000);
                                        charmander.setDano(610);
                                        System.out.println(charmander.evoluir());
                                        break;
                                    //Continua o processo
                                    case 3:
                                        System.out.println("Avançando...\n");
                                        verPokemons = false;
                                        break;
                                    //Caso nenhuma das alternativas sejam escolhidas
                                    default:
                                        System.out.println("Opção inválida.");
                                }
                                break;
                            //Caso bulbasaur
                            case 2:
                                System.out.println(bulbasaur.exibirInformacoes());
                                System.out.println("\n--OPÇÕES--\n 1-Trocar de pokemon\n 2-Evoluir pokemon\n 3-Avançar");
                                opcSwitch2 = scanner.nextInt();
                                switch (opcSwitch2) {
                                    case 1:
                                        System.out.println("trocando de pokemon...\n");
                                        break;
                                    case 2:
                                        bulbasaur.setEvolucao("Ivysaur");
                                        bulbasaur.setNome("Ivysaur");
                                        bulbasaur.setVida(4800);
                                        bulbasaur.setDano(190);
                                        System.out.println(bulbasaur.evoluir());
                                        break;
                                    case 3:
                                        System.out.println("Avançando...\n");
                                        verPokemons = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                }
                                break;
                            //Caso squirtle
                            case 3:
                                System.out.println(squirtle.exibirInformacoes());
                                System.out.println("\n--OPÇÕES--\n 1-Trocar de pokemon\n 2-Evoluir pokemon\n 3-Avançar\n 4-Voltar");
                                opcSwitch2 = scanner.nextInt();
                                switch (opcSwitch2) {
                                    case 1:
                                        System.out.println("trocando de pokemon...\n");
                                        break;
                                    case 2:
                                        squirtle.setEvolucao("Wartortle");
                                        squirtle.setNome("Wartortle");
                                        squirtle.setVida(3000);
                                        squirtle.setDano(340);
                                        System.out.println(squirtle.evoluir());
                                        break;
                                    case 3:
                                        System.out.println("Avançando...\n");
                                        verPokemons = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                }
                                break;
                            //Saindo da opção escolher pokemon
                            case 4:
                                System.out.println("Voltando...");
                                verPokemons = false;
                        }
                    }
                case 2:
                    //Escolher um pokemon para atacar
                    System.out.println("--ESOLHA UM POKEMOM PARA REALIZAR O ATAQUE--");
                    System.out.println(" 1- " + charmander.getNome() + " \n 2- " + bulbasaur.getNome() + " \n 3- " + squirtle.getNome());
                    do {
                        opcAtaque = scanner.nextInt();
                    } while (opcAtaque > 3 || opcAtaque < 0);
                    //Escolher um pokemon para ser atacado, não podendo ser o mesmo do anterior
                    do {
                        System.out.println("--ESOLHA UM POKEMOM PARA SER ATACADO--");
                        System.out.println(" 1- " + charmander.getNome() + " \n 2- " + bulbasaur.getNome() + " \n 3- " + squirtle.getNome());
                        opcAlvo = scanner.nextInt();
                    } while (opcAlvo == opcAtaque | (opcAlvo > 3 || opcAlvo < 0));

                    switch (opcAtaque) {
                        case 1:
                            atacante = charmander;
                            break;
                        case 2:
                            atacante = bulbasaur;
                            break;
                        case 3:
                            atacante = squirtle;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                    switch (opcAlvo) {
                        case 1:
                            alvo = charmander;
                            break;
                        case 2:
                            alvo = bulbasaur;
                            break;
                        case 3:
                            alvo = squirtle;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            return;
                    }

                    //Mostra as informações após os ataques
                    if (atacante.getVida() <= 0 && alvo.getVida() <=0) {
                        System.out.println("Pokemon abatido!");
                        break;
                    } else {
                        resultadoAtaque = atacante.atacar(alvo, atacante.getDano());
                        System.out.println(atacante.getNome() + " deu " + resultadoAtaque + " de dano");
                        System.out.println(alvo.getNome() + " ficou com " + alvo.getVida() + " de vida");
                    }
                    break;
                case 3:
                    // Curiosidade de cada um específico
                    System.out.println("--ESOLHA UM POKEMOM PARA LER UMA CURIOSIDADE--");
                    System.out.println(" 1- " + charmander.getNome() + " \n 2- " + bulbasaur.getNome() + " \n 3- " + squirtle.getNome());
                    opcCuriosidade = scanner.nextInt();

                    switch (opcCuriosidade) {
                        case 1:
                            System.out.println(charmander.curiosidade());
                            break;
                        case 2:
                            System.out.println(bulbasaur.curiosidade());
                            break;
                        case 3:
                            System.out.println(squirtle.curiosidade());
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                case 4:
                    //Saindo do sistema
                    System.out.println("Colocando os Pokemons para dormir...");
                    continuar = false;
                    break;
                default:
                    //Caso o usuário digite um número inválido no menu
                    System.out.println("Opção inválida");
            }
        }
    }
}