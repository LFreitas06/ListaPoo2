package Ex14;

import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private String titulo;
    private List<Aula> aulas;

    public Modulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            this.titulo = "TITULO_INVALIDO";
            System.out.println("ERRO: Título do módulo não pode ser vazio.");
        }
        this.aulas = new ArrayList<>();
    }

    public void adicionarAula(Aula a) {
        if (a != null) {
            this.aulas.add(a);
        }
    }

    public String listarAulas() {
        StringBuilder sb = new StringBuilder();
        for (Aula a : aulas) {
            sb.append("    -> ").append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String toString() {
        return "Modulo [titulo=" + titulo + ", total_aulas=" + aulas.size() + "]";
    }
}