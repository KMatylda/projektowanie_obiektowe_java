import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj trzy boki trójkąta: ");

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("BŁĄD");
        }

        else if (a + b > c && a + c > b && b + c > a) {
            System.out.print("TAK");
        } else {
            System.out.print("NIE");
        }
    }
}