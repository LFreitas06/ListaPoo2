package Ex5;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        List<contaBancaria> contas = new ArrayList<>();
        contas.add(new contaBancaria("001-A", "Ana Silva"));
        contas.add(new contaBancaria("002-B", "Bruno Costa"));
        contas.add(new contaBancaria("003-C", "Carla Dias"));
        contas.add(new contaBancaria("004-D", "Daniel Moreira"));

        System.out.println("--- (1) 4 contas criadas ---");

        for (contaBancaria conta : contas) {
            System.out.println(conta.exibirSaldo());
        }

        System.out.println("\n--- (2) Realizando Operações ---");

        contas.get(0).depositar(1000.0);
        contas.get(1).depositar(1500.0);
        contas.get(0).sacar(200.0);
        contas.get(2).depositar(3000.0);

        System.out.println("-> Teste de Saque Inválido (Saldo Insuficiente):");
        contas.get(1).sacar(2000.0);

        System.out.println("-> Teste de Depósito Inválido (Valor Negativo):");
        contas.get(3).depositar(-100.0);

        System.out.println("\n--- Saldo após operações ---");
        for (contaBancaria conta : contas) {
            System.out.println(conta.exibirSaldo());
        }

        System.out.println("\n--- (3) Buscando conta '003-C' ---");
        String numeroBusca = "003-C";
        contaBancaria contaEncontrada = null;

        for (contaBancaria conta : contas) {
            if (conta.getNumero().equals(numeroBusca)) {
                contaEncontrada = conta;
                break;
            }
        }

        if (contaEncontrada != null) {
            System.out.println("Conta encontrada: " + contaEncontrada.toString());
        } else {
            System.out.println("Conta com número " + numeroBusca + " não foi encontrada.");
        }

        System.out.println("\n--- (4) Buscando conta com maior saldo ---");

        contaBancaria contaMaiorSaldo = contas.get(0);

        for (contaBancaria conta : contas) {
            if (conta.getSaldo() > contaMaiorSaldo.getSaldo()) {
                contaMaiorSaldo = conta;
            }
        }

        System.out.println("Conta com maior saldo encontrada:");
        System.out.println("Titular: " + contaMaiorSaldo.getTitular());
        System.out.println("Saldo: R$" + contaMaiorSaldo.getSaldo());
    }
}