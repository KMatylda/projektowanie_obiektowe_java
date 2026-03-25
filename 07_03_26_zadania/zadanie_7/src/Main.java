import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // try zawiera kod, który może spowodować błąd w czasie wykonania
        try {
            int n = input.nextInt();
            int m = input.nextInt();

            // sprawdzam, czy są to liczby naturalne
            if (n <= 0 || m <= 0) {
                System.out.println("BŁĄD");
                return;
            }

            // tworzę tablicę
            int[] tablica1 = new int[n];
            int[] tablica2 = new int[m];

            // wczytywanie liczb do tablica1
            for (int i = 0; i < n; i++) {
                tablica1[i] = input.nextInt();
                if (tablica1[i] < 0) { // tylko liczby naturalne
                    System.out.println("BŁĄD");
                    return;
                }
            }

            // wczytywanie liczb do tablica2
            for (int i = 0; i < n; i++) {
                tablica2[i] = input.nextInt();
                if (tablica2[i] < 0) { // tylko liczby naturalne
                    System.out.println("BŁĄD");
                    return;
                }
            }

            // obliczanie iloczynu skalarnego (do długości, krótszej tablicy)
            int dlugosc = Math.min(n, m);
            int iloczyn = 0;
            for (int i = 0; i < dlugosc; i++) {
                iloczyn += tablica1[i] * tablica2[i];
            }
            System.out.println(iloczyn);

        } catch (Exception blad){
            System.out.println("BŁĄD"); // przypadek gdy dane nie nie są liczbą
        }


    }



}