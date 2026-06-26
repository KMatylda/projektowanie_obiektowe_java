package auction;

// wzorzec Factory Method – tworzy odpowiedni typ aukcji
// zamiast pisać new SimpleAuction(...) bezpośrednio, używamy AuctionFactory.create()
public class AuctionFactory {

    public static final String SIMPLE   = "simple";
    public static final String EXTENDED = "extended";
    public static final String REVERSE  = "reverse";

    public static Auction create(String type, String title, String description,
                                 double startingPrice, int rounds,
                                 int minTrust, User seller) {
        switch (type) {
            case SIMPLE:
                return new SimpleAuction(title, description, startingPrice, rounds, minTrust, seller);
            case EXTENDED:
                return new ExtendedAuction(title, description, startingPrice, rounds, minTrust, seller);
            case REVERSE:
                return new ReverseAuction(title, description, startingPrice, rounds, minTrust, seller);
            default:
                // nieznany typ – rzucamy wyjątek żeby od razu wiedzieć o błędzie
                throw new IllegalArgumentException("Nieznany typ aukcji: " + type);
        }
    }
}
