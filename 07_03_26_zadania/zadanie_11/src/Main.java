import java.util.Scanner;

public class Main {

    public static boolean Panagram(String tekst) {
        // ignorowanie wielkosci liter
        tekst = tekst.toLowerCase();
        for (char litera = 'a'; litera <= 'z'; litera++) {
            // sprawdzam czy litera występuje w tekście
            if (tekst.indexOf(litera) == -1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz tekst do sprawdzenia: ");
        // odczytuje cały wiersz wpisany od użytkownika
        String tekst = input.nextLine();

        boolean wynik = Panagram(tekst);
        System.out.println(wynik);

        input.close();
    }
}