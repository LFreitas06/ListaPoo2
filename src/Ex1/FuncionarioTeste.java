package Ex1;

public class FuncionarioTeste {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        func.nome = "Func";

        double vendasFunc = 9500.00;
        double SalarioFunc = func.calculaSalario(vendasFunc);

        System.out.println("Funcionário: " + func.nome);
        System.out.println("Vendas Brutas: R$ " + vendasFunc);
        System.out.println("Salário Calculado: R$ " + String.format("%.2f", SalarioFunc));
        System.out.println("-----------------------------------------------------------");

        Funcionario func2 = new Funcionario();
        func2.nome = "Func2";

        double vendasFunc2 = 5000.00;
        double SalarioFunc2 = func.calculaSalario(vendasFunc2);

        System.out.println("Funcionário: " + func2.nome);
        System.out.println("Vendas Brutas: R$ " + vendasFunc2);
        System.out.println("Salário Calculado: R$ " + String.format("%.2f", SalarioFunc2));
    }
}
