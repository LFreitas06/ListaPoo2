package Ex2;

public class PrincipalQuadrado {
    public static void main(String[] args) {
        Quadrado q1 = new Quadrado(2.0);
        Quadrado q2 = new Quadrado(4.0);
        Quadrado q3 = new Quadrado(5.0);

        System.out.println("Quadrado q1");
        System.out.println("Lado: 2");
        System.out.println("Área: " + q1.area());
        System.out.println("Perímetro: " + q1.perimetro());
        System.out.println();

        System.out.println("Quadrado q2");
        System.out.println("Lado: 4");
        System.out.println("Área: " + q2.area());
        System.out.println("Perímetro: " + q2.perimetro());
        System.out.println();

        System.out.println("Quadrado q3");
        System.out.println("Lado: 5");
        System.out.println("Área: " + q3.area());
        System.out.println("Perímetro: " + q3.perimetro());
        System.out.println();
    }
}
