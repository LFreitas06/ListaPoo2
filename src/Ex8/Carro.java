package Ex8;

public class Carro {
    private String modelo;
    private Motor motor;

    public Carro(String modelo, Motor motor) {
        this.modelo = modelo;

        if (motor == null) {
            System.out.println("ERRO: Carro " + modelo + " precisa de um motor.");
            this.motor = new Motor(1);
        } else {
            this.motor = motor;
        }
    }

    public void darPartida() {
        System.out.print(this.modelo + ": Tentando dar partida... ");
        this.motor.ligar();
    }

    public void parar() {
        System.out.print(this.modelo + ": Tentando parar... ");
        this.motor.desligar();
    }

    public Motor getMotor() {
        return this.motor;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String toString() {
        return "Carro [modelo=" + modelo + ", " + motor.toString() + "]";
    }
}