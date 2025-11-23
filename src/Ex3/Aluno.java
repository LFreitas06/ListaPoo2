package Ex3;

public class Aluno {
    int matricula;
    String nome;
    double n1;
    double n2;
    double trabalho;

    public Aluno(int matricula,String nome, double n1, double n2, double trabalho){
        this.matricula = matricula;
        this.nome = nome;
        this.n1 = n1;
        this.n2 = n2;
        this.trabalho = trabalho;
    }

    double calculaMedia(){
        return (this.n1 + this.n2 + this.trabalho)/3;
    }

    public double notaFinal(){
        double mediaAtual = this.calculaMedia();

        if (mediaAtual < 6.0){
            double notaNecessaria = 10.0 - mediaAtual;
            return notaNecessaria;
        } else {
            return 0;
        }

    }
}
