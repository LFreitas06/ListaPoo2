package Ex14;

public class Professor {
    private String id;
    private String nome;

    public Professor(String id, String nome) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            this.id = "ID_INVALIDO";
            System.out.println("ERRO: ID do professor não pode ser vazio.");
        }

        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "NOME_INVALIDO";
            System.out.println("ERRO: Nome do professor não pode ser vazio.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + "]";
    }
}