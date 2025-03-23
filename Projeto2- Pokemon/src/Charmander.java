public class Charmander extends Pokemon{

    //Construtor do charmander
    public Charmander(String nome, int vida, int dano, String tipo, String evolucao) {
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
        return "A chama em sua cauda mostra o nível de sua força vital. Se Charmander estiver fraco, a chama também queima fracamente.";
    }

}
