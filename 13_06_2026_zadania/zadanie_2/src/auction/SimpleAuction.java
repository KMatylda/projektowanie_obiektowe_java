package auction;

// aukcja prosta: wygrywa ten kto złożył najwyższą ofertę w ostatniej rundzie
public class SimpleAuction extends Auction {

    public SimpleAuction(String title, String description, double startingPrice,
                         int totalRounds, int minTrustPoints, User seller) {
        // super() wywołuje konstruktor klasy Auction
        super(title, description, startingPrice, totalRounds, minTrustPoints, seller);
    }

    @Override
    public boolean placeBid(User bidder, double amount) {

        // sprawdzamy czy użytkownik ma wystarczające punkty zaufania
        if (!canParticipate(bidder)) {
            System.out.println(bidder.getLogin() + " – za malo punktow zaufania!");
            return false;
        }

        // oferta musi być wyższa niż aktualna cena
        if (amount <= currentPrice) {
            System.out.println("Oferta zbyt niska! Aktualna cena: " + currentPrice);
            return false;
        }

        // akceptujemy ofertę – aktualizujemy cenę i zwycięzcę
        currentPrice = amount;
        winner = bidder;
        bidders.add(bidder);
        amounts.add(amount);
        System.out.println(bidder.getLogin() + " licytuje: " + amount + " PLN");
        return true;
    }
}