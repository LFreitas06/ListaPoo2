package Ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("F001", "Lavinia", 5000.0));
        funcionarios.add(new Funcionario("F002", "Bruno", 8000.0));
        funcionarios.add(new Funcionario("F003", "Carla", 4500.0));
        funcionarios.add(new Funcionario("F004", "Daniel", 12000.0));
        funcionarios.add(new Funcionario("F005", "Elisa", 7500.0));
        funcionarios.add(new Funcionario("F006", "Fabio", 5200.0));

        System.out.println("--- (1) 6 Funcionários criados ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        System.out.println("\n--- Testando Regras de Negócio ---");
        funcionarios.get(0).aplicarBonus(500);
        funcionarios.get(1).aplicarBonus(-100);
        funcionarios.get(2).reajustar(-10);
        funcionarios.get(3).reajustar(-110);

        System.out.println("\n--- (2) Buscar por ID 'F004' ---");
        String idBusca = "F004";
        Funcionario encontrado = null;

        for (Funcionario f : funcionarios) {
            if (f.getId().equals(idBusca)) {
                encontrado = f;
                break;
            }
        }

        if (encontrado != null) {
            System.out.println("Funcionário encontrado: " + encontrado);
        } else {
            System.out.println("Funcionário " + idBusca + " não encontrado.");
        }

        double min = 5000.0;
        double max = 8000.0;
        System.out.println("\n--- (3) Filtrar por Salário (R$" + min + " a R$" + max + ") ---");

        List<Funcionario> filtrados = funcionarios.stream()
                .filter(f -> f.getSalario() >= min && f.getSalario() <= max)
                .collect(Collectors.toList());

        if (filtrados.isEmpty()) {
            System.out.println("Nenhum funcionário nessa faixa salarial.");
        } else {
            for (Funcionario f : filtrados) {
                System.out.println(f);
            }
        }

        System.out.println("Top 3 Maiores Salários ---");

        List<Funcionario> top3 = funcionarios.stream()
                .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
                .limit(3)
                .collect(Collectors.toList());

        int rank = 1;
        for (Funcionario f : top3) {
            System.out.println("Top " + rank + ": " + f.getNome() + " - " + f);
            rank++;
        }
    }
}