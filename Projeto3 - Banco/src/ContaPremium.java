public class ContaPremium extends Conta {

    public ContaPremium(String titular){
        super(titular);
    }


    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        }
    }

    public double sacar(double valor) throws Exception {
        double limiteDisponivel = saldo + 1000;
        if (valor > limiteDisponivel) {
            throw new Exception("Saldo insuficiente para realizar ação.");
        } else if (valor < limiteDisponivel) {
            saldo = saldo - valor;
        }
        return saldo;
    }

    public double transferir(double valor, Conta destino) throws Exception {
        double limiteDisponivel = saldo + 1000;
        if (valor > limiteDisponivel) {
            throw new Exception("Saldo insuficinte para realizar ação.");
        } else if (valor < limiteDisponivel) {
            saldo = saldo - valor;
            destino.depositar(valor);
        }
        return saldo;
    }
}

