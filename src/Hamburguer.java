public class Hamburguer extends Produto{
    protected String tamanho;

    public Hamburguer(String nome, double preco, String tamanho){
        super(nome, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() ;
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
        atualizarPrecoPorTamanho();
    }

    public void atualizarPrecoPorTamanho() {
        switch (tamanho) {
            case "P":
                setPreco(preco);  // Sem alteração
                break;
            case "M":
                setPreco(preco * 1.3);  // Preço ajustado para tamanho médio
                break;
            case "G":
                setPreco(preco * 1.5);  // Preço ajustado para tamanho grande
                break;
            default:
                System.out.println("Tamanho inválido");
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (" + tamanho + ")";
    }
}
