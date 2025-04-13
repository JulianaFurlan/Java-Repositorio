import java.util.Scanner;

public class PilhaEstatica implements IEstruturaSimples{
    private Object[] pilha;
    private int topo;
    public int tamanho;

    //Criar construtor da pilha simples
    public PilhaEstatica(int tamanhoInicial) {
        this.tamanho = tamanhoInicial;
        this.pilha = new Object[tamanho];
        this.topo = -1; //Aqui o menos um é para começar a pilha vazia
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaEstatica pilha = null;
        int capacidade = 0;

        //Menu
        boolean pilhaCriada = false;

        while (true) {
            System.out.println("\n    --PILHA SIMPLES--");
            System.out.println(" 0- Criar Pilha (deve ser o primeiro comando)");
            System.out.println(" 1- Inserir Elemento");
            System.out.println(" 2- Inserir Elemento por Índice");
            System.out.println(" 3- Inserir Sequência");
            System.out.println(" 4- Remover Elemento");
            System.out.println(" 5- Remover por Índice");
            System.out.println(" 6- Remover Sequência");
            System.out.println(" 7- Remover Todas as Ocorrências");
            System.out.println(" 8- Verificar se está Cheia");
            System.out.println(" 9- Verificar se está Vazia");
            System.out.println("10- Buscar Elemento");
            System.out.println("11- Buscar Elemento por Índice");
            System.out.println("12- Ordenar Crescente");
            System.out.println("13- Ordenar Decrescente");
            System.out.println("14- Quantidade de Elementos");
            System.out.println("15- Dobrar Capacidade");
            System.out.println("16- Editar Elemento");
            System.out.println("17- Limpar Pilha");
            System.out.println("18- Exibir Pilha");
            System.out.println("19- Obter Primeiro Elemento");
            System.out.println("20- Obter Último Elemento");
            System.out.println("21- Sair");
            System.out.print("\nEscolha uma opção: ");

            int opc = scanner.nextInt();

            try {
                if (!pilhaCriada && opc != 0 && opc != 21) {
                    //Se a pilha não foi criada, não permite acessar outras opções
                    System.out.println("Erro: é preciso criar a pilha primeiro.");
                    continue;
                }

                switch (opc) {
                    case 0:
                        //Criar a pilha
                        while (capacidade <= 0) {
                            System.out.println("Digite a capacidade da pilha:");
                            capacidade = scanner.nextInt();
                        }
                        pilha = new PilhaEstatica(capacidade);
                        pilhaCriada = true;
                        System.out.println("Pilha criada com sucesso! Capacidade: " + capacidade);
                        break;
                    case 1:
                        //Inserir um elemento
                        System.out.println("Digite o elemento a ser inserido: ");
                        Object elemento = scanner.next();
                        pilha.inserirElemento(elemento);
                        break;
                    case 2:
                        //Inserir um elemento por índice
                        System.out.println("Digite um índice para inserir um elemento: ");
                        int indice = scanner.nextInt();
                        System.out.println("Digite o elemento: ");
                        Object elemento1 = scanner.next();
                        pilha.inserirElementoIndice(elemento1, indice);
                        break;
                    case 3:
                        //Inserir sequência
                        System.out.println("Digite os elementos separados por espaço para inserir: ");
                        scanner.nextLine();
                        String linha = scanner.nextLine();
                        String[] partes = linha.split(" ");
                        Object[] entrada = partes;
                        pilha.inserirSequencia(entrada);
                        break;
                    case 4:
                        //Remover elemento
                        pilha.removerElemento();
                        break;
                    case 5:
                        //Remover por índice
                        System.out.println("Digite o índice que deseja remover o elemento: ");
                        int indice1 = scanner.nextInt();
                        pilha.removerIndice(indice1);
                        break;
                    case 6:
                        //Remover uma Sequência
                        System.out.println("Digite os elementos separados por espaço para remover: ");
                        scanner.nextLine();
                        String linha1 = scanner.nextLine();
                        String[] partes1 = linha1.split(" ");
                        Object[] entrada1 = partes1;
                        pilha.removerSequencia(entrada1);
                        break;
                    case 7:
                        //Remover todas as Ocorrências
                        System.out.println("Digite um elemento para ser removido em todas suas ocorrências: ");
                        Object removidosOco = scanner.next();
                        pilha.removerTodasOcorrencias(removidosOco);
                        break;
                    case 8:
                        //Cheia
                        pilha.estaCheia();
                        break;
                    case 9:
                        //Vazia
                        pilha.estaVazia();
                        break;
                    case 10:
                        //Buscar um Elemento
                        System.out.println("Digite o elemento a ser buscado: ");
                        Object elemento2 = scanner.next();
                        pilha.buscarElemento(elemento2);
                        break;
                    case 11:
                        //Buscar elemento por Índice
                        System.out.println("Digite o índice que deseja buscar: ");
                        int indice2 = scanner.nextInt();
                        pilha.buscarElementoIndice(indice2);
                        break;
                    case 12:
                        //Ordenar de forma crescente
                        pilha.ordenarCrescente();
                        break;
                    case 13:
                        //Ordenar de forma decrescente
                        pilha.ordenarDecrescente();
                        break;
                    case 14:
                        //Quantidade de elementos
                        pilha.quantidadeElementos();
                        break;
                    case 15:
                        //Dobrar a capacidade
                        pilha.dobrarCapacidade();
                        break;
                    case 16:
                        //Editar um elemento
                        System.out.println("Digite o elemento que quer mudar: ");
                        Object elementoAntigo = scanner.next();
                        System.out.println("Digite o elemento novo: ");
                        Object elementoNovo = scanner.next();
                        pilha.editarElemento(elementoAntigo, elementoNovo);
                        break;
                    case 17:
                        //Limpar a pilha
                        pilha.limpar();
                        break;
                    case 18:
                        //Exibir a pilha
                        pilha.exibir();
                        break;
                    case 19:
                        //Obter o primeiro elemento
                        pilha.obterPrimeiroElemento();
                        break;
                    case 20:
                        //Obter o último elemento
                        pilha.obterUltimoElemento();
                        break;
                    case 21:
                        //Sair
                        System.out.println("Até logo!");
                        System.out.println("Saindo. . .");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                //Sai do loop
                if (opc == 21) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    @Override
    public void inserirElemento(Object elemento){
        System.out.println("Topo atual: " + (topo + 1) + " | Tamanho da pilha: " + pilha.length);
        if(estaCheia()) {
            System.out.println("A pilha está cheia!");
        } else {
            pilha[++topo] = elemento;
            System.out.println("Elemento inserido: "+ elemento);
        }

    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (elemento == null) {
            System.out.println("Elemento não pode ser nulo");
            return;
        }

        if (indice < 1 || indice > topo + 2) {
            System.out.println("Índice inválido. Deve estar entre 1 e " + (topo + 2));
            return;
        }

        if (estaCheia()) {
            System.out.println("Pilha cheia - não é possível inserir");
            return;
        }

        int indiceInterno = indice - 1;

        //Desloca elementos para a direita
        for (int i = topo; i >= indiceInterno; i--) {
            pilha[i + 1] = pilha[i];
        }

        //Insere o novo elemento
        pilha[indiceInterno] = elemento;
        topo++;

        System.out.println("Elemento " + elemento + " inserido na posição " + indice);
    }

    @Override
    public void inserirSequencia(Object[] elementos) {
        if (elementos == null) {
            System.out.println("Os elementos não podem ser nulos");
            return;
        }


        int espacoLivre = this.tamanho - (topo + 1);
        if (elementos.length > espacoLivre) {
            System.out.println("Não há espaço suficiente na pilha. Espaço livre: " + espacoLivre + ", elementos a inserir: " + elementos.length);
            return;
        }

        StringBuilder elementosInseridos = new StringBuilder();

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null || elementos[i].toString().trim().isEmpty()) {
                System.out.println("Elemento na posição " + (i + 1) + " é nulo ou vazio");
                continue;
            }
            this.pilha[++this.topo] = elementos[i];
            elementosInseridos.append(elementos[i]);
            if (i < elementos.length - 1) {
                elementosInseridos.append(", ");
            }
        }
        System.out.println("Sequência inserida: [" + elementosInseridos.toString() + "]");
    }

    @Override
    public boolean removerElemento() {
        if(estaVazia()) {
            System.out.println("Não há elementos para desimpilhar, pois está vazia");
            return false;
        } else {
            Object removido = pilha[topo];
            pilha[topo] = null;
            topo--;
            System.out.println("Elemento removido: "+ removido);
            return true;
        }
    }

    @Override
    public Object removerIndice(int indice){
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }

        if (indice < 1 || indice > topo + 1) {
            System.out.println("Índice inválido. Deve estar entre 1 e " + (topo + 1));
            return null;
        }

        int indiceInterno = indice - 1;
        Object removido = pilha[indiceInterno];

        //Deslocamentos
        for (int i = indiceInterno; i < topo; i++) {
            pilha[i] = pilha[i + 1];
        }

        pilha[topo--] = null;
        System.out.println("Elemento " + removido + " removido da posição " + indice);
        return removido;
    }

    public void removerSequencia(Object[] elementos) {
        if (elementos == null || elementos.length == 0) {
            System.out.println("Sequência inválida");
            return;
        }

        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return;
        }

        //Verifica se todos os elementos existem na pilha
        for (int i = 0; i < elementos.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j <= topo; j++) {
                if (elementos[i].equals(pilha[j])) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Elemento " + elementos[i] + " não encontrado na pilha");
                return;
            }
        }

        //Cria uma nova pilha sem os elementos da sequência informada
        Object[] novaPilha = new Object[tamanho];
        Object[] elementosRemovidos = new Object[this.tamanho];
        int novoTopo = -1;
        int removidos = 0;

        for (int i = 0; i <= topo; i++) {
            boolean deveRemover = false;

            //Verifica se o elemento atual deve ser removido
            for (Object elem : elementos) {
                if (elem.equals(pilha[i])) {
                    deveRemover = true;
                    elementosRemovidos[removidos] = pilha[i];
                    removidos++;
                    break;
                }
            }

            if (!deveRemover) {
                novaPilha[++novoTopo] = pilha[i];
            }
        }

        this.pilha = novaPilha;
        this.topo = novoTopo;

        //Imprimir os elementos removidos
        System.out.print("Removidos " + removidos + " elementos: [");
        for (int i = 0; i < removidos; i++) {
            System.out.print(elementosRemovidos[i]);
            if (i < removidos - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        if (elemento == null) {
            System.out.println("Elemento não pode ser nulo");
            return;
        }

        if(estaVazia()){
            System.out.println("A pilha está vazia");
        }

        int removidos = 0;
        int i = 0;

        //Percorre a pilha e remove as ocorrências
        while (i <= topo) {
            if (elemento.equals(pilha[i])) {
                //Deslocamento
                for (int j = i; j < topo; j++) {
                    pilha[j] = pilha[j + 1];
                }
                pilha[topo] = null;
                topo--;
                removidos++;
            } else {
                //Se o elemento não for o procurado avança
                i++;
            }
        }
        System.out.println("Removidas " + removidos + " ocorrências de " + elemento);
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public boolean estaCheia() {
        return topo == tamanho - 1;
    }

    @Override
    public boolean buscarElemento(Object elemento){
        if(estaVazia()) {
            System.out.println("A pilha está vazia");
            return false;
        }

        if(elemento == null) {
            System.out.println("Elemento não pode ser nulo");
            return false;
        }

        for (int i = 0; i <= topo; i++) {
            if(elemento.equals(pilha[i])){
                System.out.println(elemento + " está na posição: " + (i + 1));
                return true;
            }
        }
        System.out.println("Elemento " + elemento + " não encontrado");
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice){
        if (estaVazia()) {
            System.out.println("A pilha está vazia");
            return null;
        }

        if (indice < 1 || indice > topo + 1) {
            System.out.println("Índice inválido. Deve estar entre 1 e " + (topo + 1));
            return null;
        }
        System.out.println("Na posição " + indice + " esta o elemento " + pilha[indice - 1]);
        return pilha[indice - 1];
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia");
            return;
        }

        //Verifica se todos os elementos são comparáveis
        for (int i = 0; i <= topo; i++) {
            if (!(pilha[i] instanceof Comparable)) {
                System.out.println("Elemento na posição " + (i + 1) + " não é comparável");
                return;
            }
        }

        //Bubble Sort
        for (int i = 0; i < topo; i++) {
            for (int j = 0; j < topo - i; j++) {
                Object a = pilha[j];
                Object b = pilha[j + 1];

                int resultadoComparacao = 0;

                try {
                    //Se os dois forem números, compara como inteiros
                    int valorA = (a instanceof Integer) ? (Integer) a : Integer.parseInt(a.toString());
                    int valorB = (b instanceof Integer) ? (Integer) b : Integer.parseInt(b.toString());
                    resultadoComparacao = Integer.compare(valorA, valorB);
                } catch (NumberFormatException e) {
                    //Se não forem números, compara como strings
                    resultadoComparacao = a.toString().compareTo(b.toString());
                }

                if (resultadoComparacao > 0) {
                    //Troca os elementos de lugar
                    Object temp = pilha[j];
                    pilha[j] = pilha[j + 1];
                    pilha[j + 1] = temp;
                }
            }
        }

        System.out.println("Pilha ordenada crescentemente com sucesso!");
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia");
            return;
        }

        for (int i = 0; i <= topo; i++) {
            if (!(pilha[i] instanceof Comparable)) {
                System.out.println("Elemento na posição " + (i + 1) + " não é comparável");
                return;
            }
        }

        //Bubble Sort (decrescente)
        for (int i = 0; i < topo; i++) {
            for (int j = 0; j < topo - i; j++) {
                Object a = pilha[j];
                Object b = pilha[j + 1];

                int resultadoComparacao = 0;

                try {
                    int valorA = (a instanceof Integer) ? (Integer) a : Integer.parseInt(a.toString());
                    int valorB = (b instanceof Integer) ? (Integer) b : Integer.parseInt(b.toString());
                    resultadoComparacao = Integer.compare(valorB, valorA);  // Invertido para decrescente
                } catch (NumberFormatException e) {
                    resultadoComparacao = b.toString().compareTo(a.toString());
                }

                if (resultadoComparacao > 0) {
                    // Troca os elementos de lugar
                    Object aux = pilha[j];
                    pilha[j] = pilha[j + 1];
                    pilha[j + 1] = aux;
                }
            }
        }

        System.out.println("Pilha ordenada decrescentemente com sucesso!");
    }

    @Override
    public int quantidadeElementos(){
        if(estaVazia()) {
            System.out.println("A pilha está vazia");
        }
        System.out.println("Quantidade de elementos: " + (topo + 1));
        return topo + 1;
    }

    @Override
    public void dobrarCapacidade() {
        //Cria novo vetor com o dobro da capacidade
        int novaCapacidade = this.tamanho * 2;
        Object[] novaPilha = new Object[novaCapacidade];

        for (int i = 0; i <= topo; i++) {
            novaPilha[i] = this.pilha[i];
        }

        this.pilha = novaPilha;
        this.tamanho = novaCapacidade;

        System.out.println("Capacidade dobrada para " + novaCapacidade + " elementos");
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        if (elementoAntigo == null || elementoNovo == null) {
            System.out.println("Elementos não podem ser nulos");
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i <= topo; i++) {
            if (elementoAntigo.equals(pilha[i])) {
                pilha[i] = elementoNovo;
                System.out.println("Elemento " + elementoAntigo + " foi substitudo por " + elementoNovo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento não encontrado na pilha");
        }
    }

    @Override
    public void limpar() {
        for (int i = 0; i <= topo; i++) {
            pilha[i] = null;
        }
        topo = -1; //Reseta o topo
        System.out.println("Pilha esvaziada");
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return;
        }

        System.out.println("\nElementos da pilha (do topo para a base):");
        for (int i = topo; i >= 0; i--) {
            System.out.println("[" + (i + 1) + "] " + pilha[i]);
        }
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        System.out.println("Primeiro elemento: " + pilha[0]);
        return pilha[0];
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        System.out.println("Último elemento: " + pilha[topo]);
        return pilha[topo];
    }

}