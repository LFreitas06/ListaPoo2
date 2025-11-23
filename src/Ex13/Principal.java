package Ex13;

public class Principal {

    public static void main(String[] args) {

        Fornecedor f1 = new Fornecedor("F001", "ACME LTDA", "11.222.333/0001-44");

        Produto p1 = new Produto("SKU-001", "Parafuso Sextavado", 1.50);
        Produto p2 = new Produto("SKU-002", "Porca M10", 0.50);
        Produto p3 = new Produto("SKU-003", "Arruela Lisa", 0.10);

        PedidoCompra pedido = new PedidoCompra("PED-001", f1);
        System.out.println("\n--- (1) Objetos criados ---");
        pedido.imprimirPedido();

        System.out.println("\n--- (2) Adicionando 5 itens ---");
        pedido.adicionarItem(p1, 10);
        pedido.adicionarItem(p2, 20);
        pedido.adicionarItem(p3, 50);
        pedido.adicionarItem(p1, 5);
        pedido.adicionarItem(p2, 10);

        pedido.imprimirPedido();

        System.out.println("\n--- (3) Buscando e Removendo Itens ---");

        System.out.println("Buscando SKU-002:");
        ItemPedido itemP2 = pedido.buscarItemPorSku("SKU-002");
        if (itemP2 != null) {
            System.out.println("Subtotal do SKU-002 (Qtd: 30): R$" + itemP2.getSubtotal());
        }

        pedido.removerItemPorSku("SKU-003");
        pedido.imprimirPedido();

        System.out.println("\n--- (4) Aplicando Desconto ---");
        pedido.aplicarDesconto(10);

        pedido.imprimirPedido();

        System.out.println("\n--- (5) Aprovando e Cancelando ---");

        System.out.println("Tentativa 1: Aprovar");
        pedido.aprovar();

        System.out.println("Tentativa 2: Cancelar");
        pedido.cancelar();

        System.out.println("Tentativa 3: Adicionar item após aprovar");
        pedido.adicionarItem(p3, 100);

        System.out.println("\n--- Estado Final do Pedido ---");
        pedido.imprimirPedido();
    }
}