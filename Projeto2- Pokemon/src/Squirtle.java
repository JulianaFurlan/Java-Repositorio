public class Squirtle extends Pokemon{

    //Construtor do squirtle
    public Squirtle(String nome, int vida, int dano, String tipo, String evolucao) {
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

    public String curiosidade() {
        return "Após o nascimento, suas costas incham e endurecem em uma concha. Ele borrifa uma espuma potente de sua boca.";
    }

}
