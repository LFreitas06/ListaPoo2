package Ex12;

public class Paciente {
    private String id;
    private String nome;

    public Paciente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nome=" + nome + "]";
    }
}