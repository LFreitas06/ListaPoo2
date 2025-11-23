package Ex4;

public class Estoque {
    String nome;
    int qtdAtual;
    int qtdMinima;

    public Estoque(){}


    public Estoque(String nome, int qtdAtual, int qtdMinima){
        this.nome = nome;

        do{
            this.qtdAtual = qtdAtual;
            this.qtdMinima = qtdMinima;

            if (qtdAtual < 0){
                System.out.println("A quantidade atual não pode ser menor que zero. Tente novamente.");
            } else if (qtdMinima < 0) {
                System.out.println("A quantidade mínima não pode ser menor que zero. Tente novamente");
            }

        }while(qtdAtual < 0 || qtdMinima < 0);
    }

    public void mudarNome(String nome){
        this.nome = nome;
    }

    public void mudarQtdMinima(int qtdMinima){
        do {
            if (qtdMinima >= 0){
                this.qtdMinima = qtdMinima;
            }else{
                System.out.println("A quantidade mínima não pode ser menor que zero");
            }
        }while (qtdMinima < 0 );
    }

    public void repor(int qtd){
        do{
            if (qtd > 0){
                this.qtdAtual += qtd;
            } else {
                System.out.println("A quantidade a ser reposta não pode ser menor que zero");
            }
        }while(qtd < 0);
    }

    public void darBaixa(int qtd){
        if (qtd > 0){
            if (this.qtdAtual >= qtd){
                this.qtdAtual -= qtd;
            } else {
                this.qtdAtual = 0;
                System.out.println("esse produto acabou :(");
            }
        }
    }


    public String mostra(){
        return "Produto: " + this.nome +
                "\nQuantidade mínima: " + this.qtdMinima +
                "\nQuantidade atual";
    }

    public boolean precisaRepor(){
        return qtdAtual <= qtdMinima;
    }

}
