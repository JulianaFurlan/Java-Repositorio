public class Porcao extends Produto{

    protected String tamanho;

    public Porcao(String nome, String tamanho, double preco){
        super(nome, preco);
        this.tamanho = tamanho;

    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes();
    }

    @Override
    public String toString() {
        return super.toString() + " (" + tamanho + ")";
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
        atualizarPrecoPorTamanho();
    }

    public void atualizarPrecoPorTamanho() {
        switch (tamanho) {
            case "P":
                setPreco(preco);
                break;
            case "M":
                setPreco(preco * 1.3);
                break;
            case "G":
                setPreco(preco * 1.5);
                break;
            default:
                System.out.println("Tamanho inválido");
                break;
        }
    }
}
