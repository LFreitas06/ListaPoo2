package Ex3;

public class disciplina {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1234, "leo",8,8,8);

        double mediaAluno1 = aluno1.calculaMedia();
        double finalAluno1 = aluno1.notaFinal();

        System.out.println("Aluno: " + aluno1.nome);
        System.out.println("Média: " + String.format("%.2f", mediaAluno1));
        if (mediaAluno1 < 6.0) {
            System.out.println("Quanto preciso no exame final: " + String.format("%.2f", finalAluno1));
        }
        System.out.println();

        Aluno aluno2 = new Aluno(4321, "Aluno2",5,5,5);

        double mediaAluno2 = aluno2.calculaMedia();
        double finalAluno2 = aluno2.notaFinal();

        System.out.println("Aluno: " + aluno2.nome);
        System.out.println("Média: " + String.format("%.2f", mediaAluno2));
        if (mediaAluno2 < 6.0) {
            System.out.println("Quanto preciso no exame final: " + String.format("%.2f", finalAluno2));
        }
        System.out.println();
    }
}
