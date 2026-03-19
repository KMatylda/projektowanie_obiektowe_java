import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        //sprawdzam czy liczba jest całkowita
        while (true) {
            if (input.hasNextInt()) {
                n = input.nextInt();
                if (n > 0) {
                    break;
                }
            } else {
                // odrzucam błędne dane
                input.next();
            }
        }

        // znaczki rosnąco
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // znaczki malejąco
        for (int i = n; i >= 1; i--){
            for(int j = 0; j < i; j++){
               System.out.print("*");
            }
            System.out.println();
        }

        // znaczki ze spacjami malejąco
        for (int i = n; i >= 1; i--) {
            // spacje
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // znaczki ze spacjami rosnąco
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++ ) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    input.close();

    }
}