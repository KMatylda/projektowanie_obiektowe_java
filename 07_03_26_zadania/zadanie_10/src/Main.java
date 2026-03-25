import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Podaj ilość wierszy:");
            int a = input.nextInt();

            System.out.print("Podaj ilość kolumn:");
            int b = input.nextInt();

            if (a <= 0 || b <= 0) {
                System.out.println("BŁĄD");
                return;
            }

            int[][] matrix = new int[a][b];

            // wczytanie a X b
            for (int i = 0; i < a; i++) {
                for(int j = 0; j < b; j++) {
                    if (input.hasNextInt()) {
                        matrix[i][j] = input.nextInt();
                    } else {
                        System.out.println("BŁĄD");
                        return;
                    }
                }
            }
            // transpozycja macierzy
            for (int j = 0; j < b; j++) {
                for (int i = 0; i < a; i++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("BŁĄD");
        } finally {
            input.close();
        }
    }
}
