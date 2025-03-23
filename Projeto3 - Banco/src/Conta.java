public abstract class Conta {

    //ATRIBUTOS
    protected String titular;
    protected double saldo;

    //CONSTRUTOR
    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract double transferir(double valor, Conta destino) throws Exception;

    public abstract double sacar(double valor) throws Exception;
}
