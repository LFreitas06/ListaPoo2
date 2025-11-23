package Ex10;

import java.util.ArrayList;

public class Turma {
    private String codigo;
    private ArrayList<Aluno> alunos;

    public Turma(String codigo) {
        this.codigo = codigo;
        this.alunos = new ArrayList<>();
    }

    public Aluno buscarPorMatricula(String m) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula().equals(m)) {
                return aluno;
            }
        }
        return null;
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            return false;
        }
        if (buscarPorMatricula(aluno.getMatricula()) != null) {
            return false;
        }
        this.alunos.add(aluno);
        return true;
    }

    public boolean removerAlunoPorMatricula(String m) {
        Aluno alunoParaRemover = buscarPorMatricula(m);
        if (alunoParaRemover != null) {
            this.alunos.remove(alunoParaRemover);
            return true;
        }
        return false;
    }

    public ArrayList<Aluno> buscarPorNomeContendo(String substr) {
        ArrayList<Aluno> encontrados = new ArrayList<>();
        String substrLower = substr.toLowerCase();

        for (Aluno aluno : this.alunos) {
            if (aluno.getNome().toLowerCase().contains(substrLower)) {
                encontrados.add(aluno);
            }
        }
        return encontrados;
    }

    public String listarAlunos() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Alunos da Turma: " + this.codigo + " (" + getQuantidade() + " alunos) ---\n");
        if (this.alunos.isEmpty()) {
            sb.append("Turma vazia.\n");
        } else {
            for (Aluno aluno : this.alunos) {
                sb.append(aluno.toString() + "\n");
            }
        }
        return sb.toString();
    }

    public int getQuantidade() {
        return this.alunos.size();
    }
}