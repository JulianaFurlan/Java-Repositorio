public class Bulbasaur extends Pokemon {

    //Construtor bulbassaur
    public Bulbasaur(String nome, int vida, int dano, String tipo, String evolucao) {
        super(nome, vida, dano, tipo, evolucao);
    }

    //Métodos
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes();
    }

    public String evoluir() {
        return super.evoluir(getEvolucao());
    }

    @Override
    public int atacar(Pokemon alvo, int dano) {
        return super.atacar(alvo, this.dano);
    }

    @Override
    public void tomarDano(int dano) {
        super.tomarDano(dano);
    }

    public String curiosidade() {
        return "Por alguem tempo após o nascimento, ele usa os nutrientes contidos na semente em suas costas para crescer.";
    }


}
