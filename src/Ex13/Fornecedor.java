package Ex13;

public class Fornecedor {
    private String id;
    private String nome;
    private String cnpj;

    public Fornecedor(String id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Fornecedor [ID=" + id + ", Nome=" + nome + "]";
    }
}