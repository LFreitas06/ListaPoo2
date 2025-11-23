package Ex4;

public class PrincipalEstoque {
    public static void main(String[] args) {
        Estoque estoque1 = new Estoque("Impressora Jato de Tinta", 13,6);
        Estoque estoque2 = new Estoque("Monitor LCD 17 Polegadas", 11,13);
        Estoque estoque3 = new Estoque("Mouse Ótico", 6,2);

        estoque1.darBaixa(5);
        estoque2.repor(7);
        estoque3.darBaixa(4);

        System.out.println("Estoque 1 (" + estoque1.mostra().split("\n")[0] + ") precisa repor? " + estoque1.precisaRepor());
        System.out.println();
        System.out.println("Estoque 2 (" + estoque2.mostra().split("\n")[0] + ") precisa repor? " + estoque2.precisaRepor());
        System.out.println();
        System.out.println("Estoque 3 (" + estoque3.mostra().split("\n")[0] + ") precisa repor? " + estoque3.precisaRepor());

        System.out.println();

        System.out.println("Informações Estoque 1");
        System.out.println(estoque1.mostra());
        System.out.println();

        System.out.println("Informações Estoque 2");
        System.out.println(estoque2.mostra());
        System.out.println();

        System.out.println("Informações Estoque 3");
        System.out.println(estoque3.mostra());
    }
}
