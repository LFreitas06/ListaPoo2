package Ex7;

public class Pessoa {
    private String nome;
    private String cpf;
    private Endereco endereco;

    public Pessoa(String nome, String cpf, Endereco endereco) {
        this.nome = nome;

        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        } else {
            System.out.println("ERRO: CPF inválido (vazio) para " + nome + ".");
            this.cpf = "CPF_INVALIDO";
        }

        if (endereco == null) {
            System.out.println("ERRO: Pessoa " + nome + " criada sem endereço obrigatório.");
            this.endereco = new Endereco("N/A", "0", "N/A", "XX");
        } else {
            this.endereco = endereco;
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
            System.out.println("Endereço de " + this.nome + " atualizado.");
        } else {
            System.out.println("ERRO: Troca de endereço falhou. Endereço não pode ser nulo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", " + this.endereco.toString() + "]";
    }
}