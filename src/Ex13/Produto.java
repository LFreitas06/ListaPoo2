package Ex13;

public class Produto {
    private String sku;
    private String descricao;
    private double precoUnitario;

    public Produto(String sku, String descricao, double precoUnitario) {
        this.sku = sku;
        this.descricao = descricao;
        if (precoUnitario > 0) {
            this.precoUnitario = precoUnitario;
        } else {
            this.precoUnitario = 0;
        }
    }

    public String getSku() {
        return sku;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public String toString() {
        return "Produto [SKU=" + sku + ", Descrição=" + descricao + ", Preço=R$" + precoUnitario + "]";
    }
}