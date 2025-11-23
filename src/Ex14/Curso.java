package Ex14;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nome;
    private Professor professor;
    private List<Modulo> modulos;

    public Curso(String codigo, String nome, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.modulos = new ArrayList<>();

        if (professor != null) {
            this.professor = professor;
        } else {
            System.out.println("ERRO: Curso não pode ficar sem professor. Criando professor temporário.");
            this.professor = new Professor("TEMP", "Professor Temporário");
        }
    }

    public void definirProfessor(Professor p) {
        if (p != null) {
            System.out.println("Alterando professor de " + this.professor.getNome() + " para " + p.getNome());
            this.professor = p;
        } else {
            System.out.println("ERRO: Professor inválido.");
        }
    }

    public void adicionarModulo(Modulo m) {
        if (m != null) {
            this.modulos.add(m);
        }
    }

    public List<Modulo> buscarModulosPorTitulo(String substr) {
        List<Modulo> encontrados = new ArrayList<>();
        String termo = substr.toLowerCase();
        for (Modulo m : modulos) {
            if (m.getTitulo().toLowerCase().contains(termo)) {
                encontrados.add(m);
            }
        }
        return encontrados;
    }

    public List<Aula> aulasComDuracaoMin(int min) {
        List<Aula> filtradas = new ArrayList<>();
        for (Modulo m : modulos) {
            for (Aula a : m.getAulas()) {
                if (a.getDuracaoMin() >= min) {
                    filtradas.add(a);
                }
            }
        }
        return filtradas;
    }

    public Aula aulaMaisLonga() {
        Aula maior = null;
        int maxDuracao = -1;

        for (Modulo m : modulos) {
            for (Aula a : m.getAulas()) {
                if (a.getDuracaoMin() > maxDuracao) {
                    maxDuracao = a.getDuracaoMin();
                    maior = a;
                }
            }
        }
        return maior;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(nome).append(" (Cod: ").append(codigo).append(")\n");
        sb.append("Responsável: ").append(professor).append("\n");
        sb.append("Módulos:\n");
        for (Modulo m : modulos) {
            sb.append("  * ").append(m).append("\n");
            sb.append(m.listarAulas());
        }
        return sb.toString();
    }
}