package Ex13;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PedidoCompra {
    private String id;
    private Status status;
    private double descontoPercent;

    private Fornecedor fornecedor;
    private List<ItemPedido> itens;

    public PedidoCompra(String id, Fornecedor fornecedor) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.itens = new ArrayList<>();
        this.status = Status.PENDENTE;
        this.descontoPercent = 0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (this.status != Status.PENDENTE) {
            System.out.println("ERRO: Não é possível adicionar itens a um pedido " + this.status);
            return;
        }

        if (quantidade < 1 || produto.getPrecoUnitario() <= 0) {
            System.out.println("ERRO: Quantidade ou Preço unitário inválido.");
            return;
        }

        ItemPedido itemExistente = buscarItemPorSku(produto.getSku());

        if (itemExistente != null) {
            itemExistente.adicionarQuantidade(quantidade);
        } else {
            ItemPedido novoItem = new ItemPedido(produto, quantidade);
            this.itens.add(novoItem);
        }
    }

    public ItemPedido buscarItemPorSku(String sku) {
        for (ItemPedido item : this.itens) {
            if (item.getProduto().getSku().equals(sku)) {
                return item;
            }
        }
        return null;
    }

    public void removerItemPorSku(String sku) {
        if (this.status != Status.PENDENTE) {
            System.out.println("ERRO: Não é possível remover itens de um pedido " + this.status);
            return;
        }

        Iterator<ItemPedido> iterator = this.itens.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            ItemPedido item = iterator.next();
            if (item.getProduto().getSku().equals(sku)) {
                iterator.remove();
                removido = true;
                break;
            }
        }

        if (removido) {
            System.out.println("Item (SKU: " + sku + ") removido.");
        } else {
            System.out.println("Item (SKU: " + sku + ") não encontrado para remoção.");
        }
    }

    public double getTotalBruto() {
        double totalBruto = 0;
        for (ItemPedido item : this.itens) {
            totalBruto += item.getSubtotal();
        }
        return totalBruto;
    }

    public void aplicarDesconto(int percent) {
        if (this.status != Status.PENDENTE) {
            System.out.println("ERRO: Não é possível aplicar desconto a um pedido " + this.status);
            return;
        }

        if (percent >= 0 && percent <= 20) {
            this.descontoPercent = percent;
            System.out.println("Desconto de " + percent + "% aplicado.");
        } else {
            System.out.println("Desconto inválido. Deve ser entre 0 e 20.");
        }
    }

    public double getTotalLiquido() {
        double totalBruto = getTotalBruto();
        double valorDesconto = totalBruto * (this.descontoPercent / 100.0);
        return totalBruto - valorDesconto;
    }

    public boolean aprovar() {
        if (this.itens.size() > 0 && getTotalLiquido() > 0) {
            this.status = Status.APROVADO;
            System.out.println("Pedido APROVADO.");
            return true;
        } else {
            System.out.println("Falha ao aprovar: O pedido deve ter itens e total líquido > 0.");
            return false;
        }
    }

    public boolean cancelar() {
        if (this.status != Status.APROVADO) {
            this.status = Status.CANCELADO;
            System.out.println("Pedido CANCELADO.");
            return true;
        } else {
            System.out.println("Falha ao cancelar: Pedido já está APROVADO.");
            return false;
        }
    }

    public void imprimirPedido() {
        System.out.println("------------------------------------");
        System.out.println("Detalhes do Pedido: " + this.id);
        System.out.println("Fornecedor: " + this.fornecedor.getNome());
        System.out.println("Status: " + this.status);
        System.out.println("Itens do Pedido:");
        for(ItemPedido item : this.itens) {
            System.out.println("  * " + item);
        }
        System.out.println("Total Bruto: R$" + getTotalBruto());
        System.out.println("Desconto: " + this.descontoPercent + "%");
        System.out.println("Total Líquido: R$" + getTotalLiquido());
        System.out.println("------------------------------------");
    }
}