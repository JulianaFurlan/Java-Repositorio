public abstract class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String exibirInformacoes(){
        return  nome + " - R$ " + preco;
    }


    public String toString() {
        return nome + " - R$ " + preco;
    }


    public String getNome() {
        return nome;
    }


}
