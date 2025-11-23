package Ex13;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        if (quantidade >= 1) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;
        }
        this.precoUnitario = produto.getPrecoUnitario();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return this.quantidade * this.precoUnitario;
    }

    public void adicionarQuantidade(int qtdAdicional) {
        if (qtdAdicional > 0) {
            this.quantidade += qtdAdicional;
        }
    }

    @Override
    public String toString() {
        return "Item [SKU=" + produto.getSku() + ", Qtd=" + quantidade + ", Subtotal=R$" + getSubtotal() + "]";
    }
}