package Ex14;

public class Aula {
    private String id;
    private String tema;
    private int duracaoMin;

    public Aula(String id, String tema, int duracaoMin) {
        this.id = id;

        if (tema != null && !tema.isEmpty()) {
            this.tema = tema;
        } else {
            this.tema = "TEMA_INVALIDO";
            System.out.println("ERRO: Tema da aula não pode ser vazio.");
        }

        if (duracaoMin > 0) {
            this.duracaoMin = duracaoMin;
        } else {
            this.duracaoMin = 1;
            System.out.println("ERRO: Duração deve ser maior que 0. Definido como 1 min.");
        }
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }

    public String getTema() {
        return tema;
    }

    public String toString() {
        return "Aula [id=" + id + ", tema=" + tema + ", duracao=" + duracaoMin + "min]";
    }
}
