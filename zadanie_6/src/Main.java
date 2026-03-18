import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj trzy liczby rzeczywiste: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // Sortowanie od najmniejszej do największej, zmienna schowek tymczasowa
        double schowek;
        if (a > b) { schowek = a; a = b; b = schowek; }
        if (a > c) { schowek = a; a = c; c = schowek; }
        if (b > c) { schowek = b; b = c; c = schowek; }

        // Wyświetlenie od najmniejszej do największej
        System.out.printf("%.6f %.6f %.6f\n", a, b, c);

        // Wyświetlenie od największej do najmniejszej
        System.out.printf("%.6f %.6f %.6f\n", c, b, a);


    }
}