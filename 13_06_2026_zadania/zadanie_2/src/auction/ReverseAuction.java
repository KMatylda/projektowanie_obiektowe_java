
package auction;

// aukcja odwrotna: każda oferta OBNIŻA cenę o 1 zł i kosztuje kupującego 1 zł
// cena pokazywana dopiero po złożeniu oferty
public class ReverseAuction extends Auction {

    public ReverseAuction(String title, String description, double startingPrice,
                          int totalRounds, int minTrustPoints, User seller) {
        super(title, description, startingPrice, totalRounds, minTrustPoints, seller);
    }

    @Override
    public boolean placeBid(User bidder, double amount) {
        if (!canParticipate(bidder)) return false;

        // kluczowa różnica: ignorujemy parametr amount
        // każda oferta zawsze obniża cenę o dokładnie 1 zł
        currentPrice -= 1.0;
        winner = bidder; // ostatni licytujący ma prawo kupić po aktualnej cenie
        bidders.add(bidder);
        amounts.add(currentPrice);

        // cena pokazywana DOPIERO PO złożeniu oferty
        System.out.println(bidder.getLogin() + " zlozyl oferte. Aktualna cena: " + currentPrice + " PLN");
        return true;
    }
}