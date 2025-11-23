package Ex14;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Professor prof1 = new Professor("P100", "Dr. Alberto");
        Curso curso = new Curso("ENG-SOFT", "Engenharia de Software", prof1);

        System.out.println("--- (1) Curso Criado ---");
        System.out.println(curso);

        Modulo m1 = new Modulo("Introdução a POO");
        m1.adicionarAula(new Aula("A01", "História de Java", 40));
        m1.adicionarAula(new Aula("A02", "Classes e Objetos", 50));

        Modulo m2 = new Modulo("Herança e Polimorfismo");
        m2.adicionarAula(new Aula("A03", "Conceito de Herança", 45));
        m2.adicionarAula(new Aula("A04", "Interfaces", 55));
        m2.adicionarAula(new Aula("A05", "Classes Abstratas", 60));

        Modulo m3 = new Modulo("Padrões de Projeto");
        m3.adicionarAula(new Aula("A06", "Singleton", 30));
        m3.adicionarAula(new Aula("A07", "Factory", 90)); // Aula longa

        curso.adicionarModulo(m1);
        curso.adicionarModulo(m2);
        curso.adicionarModulo(m3);

        System.out.println("--- Curso com Módulos ---");
        System.out.println(curso);

        System.out.println("\n--- (3) Buscar Módulos com 'Poli' ---");
        List<Modulo> mods = curso.buscarModulosPorTitulo("Poli");
        for (Modulo m : mods) {
            System.out.println(m);
        }

        int duracaoFiltro = 50;
        System.out.println("\n--- (4a) Aulas com duração >= " + duracaoFiltro + " min ---");
        List<Aula> aulasLongas = curso.aulasComDuracaoMin(duracaoFiltro);
        for (Aula a : aulasLongas) {
            System.out.println(a);
        }

        System.out.println("\n--- (4b) Aula de Maior Duração ---");
        Aula maiorAula = curso.aulaMaisLonga();
        if (maiorAula != null) {
            System.out.println("A aula mais longa é: " + maiorAula.getTema() + " (" + maiorAula.getDuracaoMin() + " min)");
        }

        System.out.println("\n--- (5) Trocar Professor ---");
        Professor prof2 = new Professor("P200", "Dra. Beatriz");
        curso.definirProfessor(prof2);

        System.out.println("\n--- Resumo Atualizado ---");
        System.out.println(curso);
    }
}