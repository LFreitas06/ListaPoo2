package Ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
    private String numero;
    private ArrayList<ItemPedido> itens;

    public Pedido(String numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        if (item != null) {
            this.itens.add(item);
        }
    }

    public ItemPedido buscarItem(String desc) {
        for (ItemPedido item : this.itens) {
            if (item.getDescricao().equalsIgnoreCase(desc)) {
                return item;
            }
        }
        return null;
    }

    public boolean removerItemPorDescricao(String desc) {
        ItemPedido itemParaRemover = buscarItem(desc);
        if (itemParaRemover != null) {
            this.itens.remove(itemParaRemover);
            return true;
        }
        return false;
    }

    public ArrayList<ItemPedido> filtrarPorPrecoUnitMin(double min) {
        ArrayList<ItemPedido> filtrados = new ArrayList<>();
        for (ItemPedido item : this.itens) {
            if (item.getPrecoUnitario() >= min) {
                filtrados.add(item);
            }
        }
        return filtrados;
    }

    public double total() {
        double totalPedido = 0;
        for (ItemPedido item : this.itens) {
            totalPedido += item.subtotal();
        }
        return totalPedido;
    }

    public String listarItens() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Itens do Pedido: " + this.numero + " ---\n");
        if (this.itens.isEmpty()) {
            sb.append("Pedido vazio.\n");
        } else {
            for (ItemPedido item : this.itens) {
                sb.append(item.toString() + "\n");
            }
        }
        return sb.toString();
    }
}