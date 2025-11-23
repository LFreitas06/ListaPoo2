package Ex9;

public class CartaoCredito {
    private double limite;
    private double fatura;

    public CartaoCredito(double limite) {
        if (limite > 0) {
            this.limite = limite;
        } else {
            this.limite = 1; // Limite mínimo
        }
        this.fatura = 0;
    }

    public boolean comprar(double valor) {
        if (valor > 0 && (this.fatura + valor) <= this.limite) {
            this.fatura += valor;
            System.out.println("Compra de R$" + valor + " aprovada. Fatura atual: R$" + this.fatura);
            return true;
        }
        System.out.println("ERRO: Compra de R$" + valor + " negada. Limite disponível: R$" + disponivel());
        return false;
    }

    public boolean pagar(double valor) {
        if (valor > 0) {
            this.fatura -= valor;
            if (this.fatura < 0) {
                this.fatura = 0; // Fatura não pode ser negativa
            }
            System.out.println("Pagamento de R$" + valor + " recebido. Fatura atual: R$" + this.fatura);
            return true;
        }
        System.out.println("ERRO: Valor de pagamento inválido (R$" + valor + ").");
        return false;
    }

    public double disponivel() {
        return this.limite - this.fatura;
    }

    public double getFatura() {
        return this.fatura;
    }

    public double getLimite() {
        return this.limite;
    }

    public String toString() {
        String faturaFormat = String.format("%.2f", fatura);
        String limiteFormat = String.format("%.2f", limite);
        String dispFormat = String.format("%.2f", disponivel());

        return "CartaoCredito [limite=R$" + limiteFormat + ", fatura=R$" + faturaFormat + ", disponivel=R$" + dispFormat + "]";
    }
}