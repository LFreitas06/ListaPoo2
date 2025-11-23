package Ex7;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {


        Endereco e1 = new Endereco("Rua A", "100", "Sao Paulo", "SP");
        Endereco e2 = new Endereco("Rua B", "200", "Rio de Janeiro", "RJ");
        Endereco e3 = new Endereco("Rua C", "300", "Goiania", "GO");
        Endereco e4 = new Endereco("Rua D", "400", "Sao Paulo", "SP");
        Endereco e5 = new Endereco("Rua E", "500", "Goiania", "GO");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Lavinia", "111.111", e1));
        pessoas.add(new Pessoa("Bruno", "222.222", e2));
        pessoas.add(new Pessoa("Carla", "333.333", e3));
        pessoas.add(new Pessoa("Daniel", "444.444", e4));
        pessoas.add(new Pessoa("Elisa", "555.555", e5));

        System.out.println("--- (1) 5 Pessoas criadas ---");
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }

        System.out.println("\n--- Teste de Regras de Negócio ---");
        Endereco eInvalido = new Endereco("Rua F", "600", "Cidade F", "GOIAS");
        Pessoa pInvalida = new Pessoa("Fabio", "", eInvalido);
        System.out.println(pInvalida);

        String cidadeBusca = "Goiania";
        System.out.println("\n--- (2) Filtro por Cidade: " + cidadeBusca + " ---");
        for (Pessoa p : pessoas) {
            if (p.getEndereco().getCidade().equals(cidadeBusca)) {
                System.out.println(p);
            }
        }

        String ufBusca = "SP";
        System.out.println("\n--- (3) Filtro por UF: " + ufBusca + " ---");
        for (Pessoa p : pessoas) {
            if (p.getEndereco().getUf().equals(ufBusca)) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- (4) Trocar Endereço da 'Ana' ---");

        Pessoa pessoaParaTrocar = pessoas.get(0);
        System.out.println("Antes: " + pessoaParaTrocar);

        Endereco novoEndereco = new Endereco("Rua Nova", "999", "Curitiba", "PR");
        pessoaParaTrocar.setEndereco(novoEndereco);

        System.out.println("Depois: " + pessoaParaTrocar);

    }
}