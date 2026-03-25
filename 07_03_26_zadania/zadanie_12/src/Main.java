import java.util.Scanner;

public class Main {

    // Stała: liczba sekund w roku ziemskim
    public static final double sekundyZiemskie = 31557600;

    // Metoda obliczająca wiek na danej planecie
    public static double obliczanieWieku(double sekundy, String planeta) {
        double lataZiemskie = sekundy / sekundyZiemskie;
        double czasOrbityPlanety = 1.0; // domyślnie Ziemia

        switch (planeta.toLowerCase()) {
            case "merkury":
                czasOrbityPlanety = 0.2408467;
                break;
            case "wenus":
                czasOrbityPlanety = 0.61519726;
                break;
            case "mars":
                czasOrbityPlanety = 1.8808158;
                break;
            case "jowisz":
                czasOrbityPlanety = 11.862615;
                break;
            case "saturn":
                czasOrbityPlanety = 29.447498;
                break;
            case "uran":
                czasOrbityPlanety = 84.016846;
                break;
            case "neptun":
                czasOrbityPlanety = 164.79132;
                break;
            case "ziemia":
                czasOrbityPlanety = 1.0;
                break;
            default:
                System.out.println("Nieznana planeta.");
        }

        return lataZiemskie / czasOrbityPlanety;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wiek w sekundach: ");
        double sekundy = scanner.nextDouble();
        // nowa linijka
        scanner.nextLine();

        System.out.print("Podaj planetę: ");
        String planeta = scanner.nextLine();

        double wiek = obliczanieWieku(sekundy, planeta);
        System.out.printf("Wiek na planecie %s: %.2f lat%n", planeta, wiek);
    }
}