import java.util.Scanner;

public class Main {
    // fuknkcja do sprawdzenia palindromu
    public static boolean czyToPalindrom(char[] tablica, int dlugosc) {
        // np. kajak 01234 k == k czyli 0 == 4
        for (int i = 0; i < dlugosc / 2; i++){
            // porównanie pierwszego elementu z ostatnim
            if (tablica[i] != tablica[dlugosc -1 - i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[] tablica = new char[100];
        int dlugosc = 0;

    // wczytywanie znaków aż do końca pliku ctrl + d
        while(input.hasNext()) {
            // wczytuje slowo
            String slowo = input.next();
            for (int i = 0; i < slowo.length(); i++) {
                if (dlugosc < 100) {
                    // chartAt(i) pobiera znak pozycji i
                    // dlugosc++ zapisuje znak do tablicy i zwieksza dlugosc o 1
                    tablica[dlugosc++] = slowo.charAt(i);
                }
            }
        }

        if (czyToPalindrom(tablica, dlugosc)) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }
        input.close();
    }
}