package Ex8;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        System.out.println("### Iniciando Simulação Carro/Motor ###\n");

        Motor m1 = new Motor(100); // 1.0
        Motor m2 = new Motor(140); // 1.4
        Motor m3 = new Motor(160); // 1.6
        Motor m4 = new Motor(200); // 2.0

        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Fiat Uno", m1));
        carros.add(new Carro("VW Golf", m2));
        carros.add(new Carro("Ford Focus", m3));
        carros.add(new Carro("Honda Civic", m4));

        System.out.println("--- (1) 4 Carros criados ---");
        for (Carro c : carros) {
            System.out.println(c);
        }

        int minPotencia = 130;
        int maxPotencia = 180;
        System.out.println("\n--- (2) Filtro por Potência (" + minPotencia + " a " + maxPotencia + ") ---");

        for (Carro c : carros) {
            int p = c.getMotor().getPotencia();
            if (p >= minPotencia && p <= maxPotencia) {
                System.out.println(c);
            }
        }

        System.out.println("\n--- (3) Operações de Ligar/Parar ---");

        Carro carroLiga = carros.get(1);
        Carro carroDesliga = carros.get(2);

        carroLiga.darPartida();

        carroDesliga.parar();

        carroLiga.darPartida();

        carroLiga.parar();

        System.out.println("\n--- Estados Finais ---");
        for (Carro c : carros) {
            System.out.println(c);
        }

        System.out.println("\n### Simulação Finalizada ###");
    }
}