package Ex9;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        CartaoCredito cc1 = new CartaoCredito(1000.0);
        CartaoCredito cc2 = new CartaoCredito(1500.0);
        CartaoCredito cc3 = new CartaoCredito(500.0);
        CartaoCredito cc4 = new CartaoCredito(2000.0);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("C001", "Ana", cc1));
        clientes.add(new Cliente("C002", "Bruno", cc2));
        clientes.add(new Cliente("C003", "Carla", cc3));
        clientes.add(new Cliente("C004", "Daniel", cc4));

        System.out.println("--- (1) 4 Clientes criados ---");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\n--- (2) Realizando Operações ---");

        clientes.get(0).getCartao().comprar(400.0);
        clientes.get(1).getCartao().comprar(1000.0);

        clientes.get(1).getCartao().pagar(200.0);

        System.out.println("-> Teste Compra Negada (Limite):");
        clientes.get(2).getCartao().comprar(600.0);

        System.out.println("-> Teste Pagamento Inválido:");
        clientes.get(3).getCartao().pagar(-100.0);

        clientes.get(3).getCartao().comprar(1800.0);

        System.out.println("\n--- Estado após operações ---");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        double valorX = 300.0;
        System.out.println("\n--- (3) Clientes com disponível < R$" + valorX + " ---");

        boolean encontrou = false;
        for (Cliente c : clientes) {
            if (c.getCartao().disponivel() < valorX) {
                System.out.println(c);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum cliente com disponível menor que R$" + valorX);
        }

        System.out.println("\n--- (4) Cliente com Maior Fatura ---");

        Cliente clienteMaiorFatura = clientes.get(0);
        for (Cliente c : clientes) {
            if (c.getCartao().getFatura() > clienteMaiorFatura.getCartao().getFatura()) {
                clienteMaiorFatura = c;
            }
        }

        System.out.println("Cliente: " + clienteMaiorFatura.getNome());
        System.out.println("Fatura: R$" + clienteMaiorFatura.getCartao().getFatura());

    }
}