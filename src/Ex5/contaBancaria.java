package Ex5;

public class contaBancaria {

    private String numero;
    private String titular;
    private double saldo;

    public contaBancaria(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso para " + this.titular);
        } else {
            System.out.println("ERRO: Valor de depósito inválido (R$" + valor + "). Deve ser maior que zero.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso por " + this.titular);
            return true;
        } else if (valor > this.saldo) {
            System.out.println("ERRO: Saldo insuficiente para " + this.titular + ". (Saldo: R$" + this.saldo + ", Saque: R$" + valor + ")");
            return false;
        } else {
            System.out.println("ERRO: Valor de saque inválido (R$" + valor + ").");
            return false;
        }
    }

    public String exibirSaldo() {
        return "Conta: " + this.numero + ", Saldo atual: R$" + this.saldo;
    }

    public String toString() {
        return "ContaBancaria [Numero=" + numero + ", Titular=" + titular + ", Saldo=R$" + saldo + "]";
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
