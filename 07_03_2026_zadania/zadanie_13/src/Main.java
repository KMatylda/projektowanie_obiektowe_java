import java.util.Scanner;

public class Main {

    public static int znajdzNaj(int[] tablica, int n) {
        // jeśli mamy tylko jeden element
        if (n == 1) {
            return tablica[0];
        }
        int poprzedniNaj = znajdzNaj(tablica, n - 1);

        // porównanie ostatniego elementu z maksymalnym dotychczasowym
        if (tablica[n - 1] > poprzedniNaj) {
            return tablica[n - 1];
        } else {
            return poprzedniNaj;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz elementy tablicy: ");
        // wczytanie linii i podział na tablicę stringów
        String[] wejscie = scanner.nextLine().split(" ");

        // zamiana string na int
        int[] tablica = new int[wejscie.length];
        for (int i = 0; i < wejscie.length; i++) {
            // konwersja na liczbę całkowitą int
            tablica[i] = Integer.parseInt(wejscie[i]);
        }

        // wywołanie funkcji rekurencyjnej
        int Naj = znajdzNaj(tablica, tablica.length);
        System.out.println(Naj);

        scanner.close();
        }
    }