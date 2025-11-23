package Ex6;

public class Funcionario {
    private String id;
    private String nome;
    private double salario;

    public Funcionario(String id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        if (salario >= 0) {
            this.salario = salario;
        } else {
            this.salario = 0;
        }
    }

    public boolean aplicarBonus(double valor) {
        if (valor >= 0) {
            this.salario += valor;
            System.out.println("Bônus (R$" + valor + ") aplicado para: " + this.nome);
            return true;
        }
        System.out.println("ERRO: Valor de bônus inválido (R$" + valor + ") para " + this.nome);
        return false;
    }

    public boolean reajustar(double percent) {
        double reajuste = this.salario * (percent / 100.0);
        double novoSalario = this.salario + reajuste;

        if (novoSalario >= 0) {
            this.salario = novoSalario;
            System.out.println("Reajuste (" + percent + "%) aplicado para: " + this.nome + ". Novo salário: R$" + this.salario);
            return true;
        }

        System.out.println("ERRO: Reajuste (" + percent + "%) inválido para " + this.nome + ". Salário permanecena R$" + this.salario);
        return false;
    }

    public String toString() {
        String salarioFormatado = String.format("%.2f", this.salario);
        return "Funcionario [id=" + id + ", nome=" + nome + ", salario=R$" + salarioFormatado + "]";
    }
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}