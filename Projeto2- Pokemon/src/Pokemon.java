public abstract class Pokemon {
    //ATRIBUTOS
    protected String nome;
    protected int vida;
    protected int dano;
    protected String tipo;
    protected String evolucao;

    //CONSTRUTOR
    public Pokemon(String nome, int vida, int dano, String tipo, String evolucao) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.tipo = tipo;
        this.evolucao = evolucao;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    //MÉTODOS
    public String exibirInformacoes() {
        return "Nome: " + this.nome + "\nVida: " + this.vida + "\nDano: " + this.dano + "\nTipo: " + this.tipo + "\nEvolução: " + this.evolucao;
    }

    public String evoluir(String evolucao) {
        return "Pokemon evoluído para: " + evolucao;
    }

    public int atacar(Pokemon alvo, int dano) {
        alvo.tomarDano(dano);
        return dano;
    }

    public void tomarDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

}
