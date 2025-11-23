package Ex11;

public class ItemPedido {
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String descricao, int quantidade, double precoUnitario) {
        this.descricao = descricao;

        if (quantidade >= 1) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;
        }

        if (precoUnitario > 0) {
            this.precoUnitario = precoUnitario;
        } else {
            this.precoUnitario = 0.01; // Valor padrão mínimo
        }
    }

    public double subtotal() {
        return this.quantidade * this.precoUnitario;
    }

    @Override
    public String toString() {
        String precoFormat = String.format("%.2f", precoUnitario);
        String subtotalFormat = String.format("%.2f", subtotal());
        return "ItemPedido [descricao=" + descricao + ", qtd=" + quantidade
                + ", precoUnit=R$" + precoFormat + ", subtotal=R$" + subtotalFormat + "]";
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}