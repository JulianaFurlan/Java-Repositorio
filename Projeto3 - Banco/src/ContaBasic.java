public class ContaBasic extends Conta {

    public ContaBasic (String titular) {
        super (titular);
    }



    public void depositar(double valor) {
        if (valor > 0) {
            //saldo += valor;
            saldo = saldo + valor;
        }
    }


    public double sacar(double valor) throws Exception {
        if (valor > saldo) {
            throw new Exception("Saldo insuficinte para realizar ação.");
        } else if (valor < saldo) {
            saldo = saldo - valor;
        }
        return valor;
    }

    public double transferir(double valor, Conta destino) throws Exception {
        if (valor > saldo) {
            throw new Exception("Saldo insuficinte para realizar ação.");
        } else if (valor < saldo) {
            saldo = saldo - valor;
            destino.depositar(valor);
        }
        return valor;
    }
}