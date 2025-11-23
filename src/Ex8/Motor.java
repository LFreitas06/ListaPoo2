package Ex8;

public class Motor {
    private int potencia;
    private boolean ligado;

    public Motor(int potencia) {
        if (potencia > 0) {
            this.potencia = potencia;
        } else {
            System.out.println("ERRO: Potência inválida (" + potencia + "). Definido como 1.");
            this.potencia = 1;
        }
        this.ligado = false;
    }

    public void ligar() {
        if (!this.ligado) {
            this.ligado = true;
            System.out.println("Motor (P" + this.potencia + ") ligado.");
        } else {
            System.out.println("Motor (P" + this.potencia + ") já estava ligado.");
        }
    }

    public void desligar() {
        if (this.ligado) {
            this.ligado = false;
            System.out.println("Motor (P" + this.potencia + ") desligado.");
        } else {
            System.out.println("Motor (P" + this.potencia + ") já estava desligado.");
        }
    }

    public boolean isLigado() {
        return this.ligado;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public String toString() {
        String estado = this.ligado ? "Ligado" : "Desligado";
        return "Motor [potencia=" + potencia + ", estado=" + estado + "]";
    }
}