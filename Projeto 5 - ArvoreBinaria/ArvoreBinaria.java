public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
    }

    public boolean estaVazia() {
        if(raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    //inserção
    public void inserirRedirecionamento(int conteudo) {
        No novoNo = new No(conteudo);
        this.raiz = inserir(this.raiz, novoNo);
    }

    private No inserir(No aux, No novoNo) {
        if(aux == null) {
            return novoNo;
        } else if (novoNo.getConteudo() > aux.getConteudo()) {
            //aponta para o próximo nó da direita do nó atual
            aux.setDireita(inserir(aux.getDireita(), novoNo));
        } else {
            aux.setEsquerda(inserir(aux.getEsquerda(), novoNo));
        }
        return aux;
    }

    //remoção
    private No econtrarMenor(No aux) {
        while(aux.getEsquerda() != null) {
            aux = aux.getEsquerda();
        }
        return aux;
    }

    public No remover(No aux, int conteudo) {
        if(aux == null) {
            return null;
        }
        if(conteudo < aux.getConteudo()) {
            aux.setEsquerda(remover(aux.getEsquerda(), conteudo));
        } else if (conteudo > aux.getConteudo()) {
            aux.setDireita(remover(aux.getDireita(),conteudo));
        } else {
            //casos

            //1. Nó folha
            if(aux.getEsquerda() == null && aux.getDireita() == null) {
                return null;
            }

            //2. Um filho
            if(aux.getEsquerda() == null) {
                return aux.getDireita();
            } else if (aux.getDireita() == null) {
                return aux.getEsquerda();
            }

            //3. Dois filhos
            No menor = econtrarMenor(aux.getDireita());
            aux.setConteudo(menor.getConteudo());
            aux.setDireita(remover(aux.getDireita(), menor.getConteudo()));
        }
        return aux;
    }
}
