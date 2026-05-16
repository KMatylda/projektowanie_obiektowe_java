import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj dwa wyrazy: ");

        String line = input.nextLine();
        // podział na dwa wyrazy po spacji
        String[] words = line.split(" ");
        String napis1 = words[0];
        String napis2 = words[1];
        System.out.print("\"%"+ napis2 + " " + napis1 +"%\"");
    }
}