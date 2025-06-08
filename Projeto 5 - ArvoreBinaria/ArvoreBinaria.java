public class ArvoreBinaria {
    private No raiz;

    // Construtor inicializando a árvore com um nó raiz
    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
    }

    // Verifica se a árvore está vazia (sem raiz)
    public boolean estaVazia() {
        return raiz == null;
    }

    // ---------- INSERÇÃO ----------

    // Método público que inicia a inserção a partir da raiz
    public void inserirRedirecionamento(int conteudo) {
        No novoNo = new No(conteudo);
        this.raiz = inserir(this.raiz, novoNo);
    }

    // Método recursivo que encontra a posição correta para inserir
    private No inserir(No aux, No novoNo) {
        if(aux == null) {
            return novoNo; // insere quando encontra posição vazia
        } else if (novoNo.getConteudo() > aux.getConteudo()) {
            // Se maior, vai para a subárvore da direita
            aux.setDireita(inserir(aux.getDireita(), novoNo));
        } else {
            // Se menor ou igual, vai para a subárvore da esquerda
            aux.setEsquerda(inserir(aux.getEsquerda(), novoNo));
        }
        return aux; // retorna a árvore atualizada
    }

    // ---------- REMOÇÃO ----------

    // Encontra o menor valor da subárvore (usado no caso com dois filhos)
    private No econtrarMenor(No aux) {
        while(aux.getEsquerda() != null) {
            aux = aux.getEsquerda(); // caminha sempre à esquerda
        }
        return aux;
    }

    // Método público que inicia a remoção a partir da raiz
    public void removerRaiz(int conteudo) {
        this.raiz = remover(this.raiz, conteudo);
    }

    // Método recursivo para remover um nó com base no valor
    public No remover(No aux, int conteudo) {
        if(aux == null) {
            return null; // valor não encontrado
        }

        if(conteudo < aux.getConteudo()) {
            // Busca na subárvore da esquerda
            aux.setEsquerda(remover(aux.getEsquerda(), conteudo));
        } else if (conteudo > aux.getConteudo()) {
            // Busca na subárvore da direita
            aux.setDireita(remover(aux.getDireita(), conteudo));
        } else {
            // Nó encontrado – aplicar os 3 casos de remoção:

            // 1. Nó folha (sem filhos)
            if(aux.getEsquerda() == null && aux.getDireita() == null) {
                return null; // remove o nó
            }

            // 2. Nó com apenas um filho
            if(aux.getEsquerda() == null) {
                return aux.getDireita(); // substitui pelo filho da direita
            } else if (aux.getDireita() == null) {
                return aux.getEsquerda(); // substitui pelo filho da esquerda
            }

            // 3. Nó com dois filhos
            // Encontrar o menor valor da subárvore direita
            No menor = econtrarMenor(aux.getDireita());

            // Substituir o valor do nó atual pelo valor do menor
            aux.setConteudo(menor.getConteudo());

            // Remover o menor valor da subárvore direita (evita duplicação)
            aux.setDireita(remover(aux.getDireita(), menor.getConteudo()));
        }
        return aux; // retorna a árvore atualizada
    }

    // ---------- TRAVESSIAS (para exibir a árvore) ----------

    // Em ordem (esquerda, raiz, direita) - imprime os elementos ordenados
    public void emOrdem() {
        System.out.print("Em ordem: ");
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getEsquerda());
            System.out.print(no.getConteudo() + " ");
            emOrdem(no.getDireita());
        }
    }

    // Pré-ordem (raiz, esquerda, direita)
    public void preOrdem() {
        System.out.print("Pré-ordem: ");
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }

    // Pós-ordem (esquerda, direita, raiz)
    public void posOrdem() {
        System.out.print("Pós-ordem: ");
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.print(no.getConteudo() + " ");
        }
    }
}
