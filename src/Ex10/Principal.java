package Ex10;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Turma t1 = new Turma("POO-N2");
        t1.adicionarAluno(new Aluno("M001", "Lavinia"));
        t1.adicionarAluno(new Aluno("M002", "Bruno Costa"));
        t1.adicionarAluno(new Aluno("M003", "Carla Dias"));
        t1.adicionarAluno(new Aluno("M004", "Daniel Andrade"));
        t1.adicionarAluno(new Aluno("M005", "Ana Beatriz"));

        System.out.println("--- (1) 5 Alunos Adicionados ---");
        System.out.println(t1.listarAlunos());

        System.out.println("--- Teste Adição Duplicada (M001) ---");
        Aluno a6 = new Aluno("M001", "Outro Aluno");
        boolean sucessoAdd = t1.adicionarAluno(a6);
        if (!sucessoAdd) {
            System.out.println("Falha ao adicionar: Matrícula M001 já existe.\n");
        }

        System.out.println("--- (2) Buscas ---");
        System.out.println("Buscando por Matrícula 'M003':");
        Aluno alunoMat = t1.buscarPorMatricula("M003");
        if (alunoMat != null) {
            System.out.println("Encontrado: " + alunoMat);
        }

        System.out.println("\nBuscando por Nome contendo 'Ana':");
        ArrayList<Aluno> alunosNome = t1.buscarPorNomeContendo("Ana");
        if (alunosNome.isEmpty()) {
            System.out.println("Ninguém encontrado.");
        } else {
            for (Aluno a : alunosNome) {
                System.out.println(a);
            }
        }

        System.out.println("\n--- (3) Remover Aluno 'M004' ---");
        boolean sucessoRem = t1.removerAlunoPorMatricula("M004");
        if (sucessoRem) {
            System.out.println("Aluno M004 removido.");
        } else {
            System.out.println("Falha ao remover M004.");
        }

        System.out.println("\n--- Lista Final de Alunos ---");
        System.out.println(t1.listarAlunos());

    }
}