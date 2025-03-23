public class Pedido {
    protected Produto produto;
    protected int quantidade;

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + "x - Total: R$ " + (produto.getPreco() * quantidade);
    }

    public double calcularTotal(){
            return produto.preco * quantidade;
    }

}
