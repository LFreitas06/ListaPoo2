package Ex9;

public class Cliente {
    private String id;
    private String nome;
    private CartaoCredito cartao;

    public Cliente(String id, String nome, CartaoCredito cartao) {
        this.id = id;
        this.nome = nome;

        if (cartao == null) {
            System.out.println("ERRO: Cliente " + nome + " deve ter um cartão.");
            this.cartao = new CartaoCredito(1); // Cartão 'dummy'
        } else {
            this.cartao = cartao;
        }
    }

    public CartaoCredito getCartao() {
        return cartao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", " + cartao.toString() + "]";
    }
}