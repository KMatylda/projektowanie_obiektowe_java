import pc.Card;

public class Main {
    public static void main(String[] args) {
        Card test1 = new Card(Card.Wartosc.SIEDEM, Card.Kolor.PIK);
        if (test1.getWartosc() == Card.Wartosc.SIEDEM) {
            System.out.println("Test 1 poprawna wartość");
        }
        if (test1.getKolor() == Card.Kolor.PIK) {
            System.out.println("Test 1 poprawny kolor");
        }

        Card test2 = new Card(Card.Wartosc.DWA, Card.Kolor.TREFL);
        if (test2.getWartosc() == Card.Wartosc.DWA) {
            System.out.println("Test 2 poprawna wartość");
        }
        if (test2.getKolor() == Card.Kolor.TREFL) {
            System.out.println("Test 2 poprawny kolor");
        }

        Card test3 = new Card(Card.Wartosc.DAMA, Card.Kolor.KIER);
        if (test3.getWartosc() == Card.Wartosc.DAMA) {
            System.out.println("Test 3 poprawna wartość");
        }
        if (test3.getKolor() == Card.Kolor.KIER) {
            System.out.println("Test 3 poprawny kolor");
        }
    }
}
