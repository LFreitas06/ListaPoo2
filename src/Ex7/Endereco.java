package Ex7;

public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String uf;

    public Endereco(String rua, String numero, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;

        // Regra de Negócio: UF deve ter exatamente 2 letras
        if (uf != null && uf.length() == 2) {
            this.uf = uf.toUpperCase();
        } else {
            System.out.println("ERRO: UF '" + uf + "' é inválido. Foi definido como 'XX'.");
            this.uf = "XX";
        }
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Endereco [rua=" + rua + ", numero=" + numero + ", cidade=" + cidade + ", uf=" + uf + "]";
    }
}