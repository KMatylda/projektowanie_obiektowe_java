package auction;

// aukcja wydłużana: każda oferta dodaje 1 rundę
// kończy się gdy nikt nie licytuje w danej rundzie
public class ExtendedAuction extends Auction {

    // flaga: czy w bieżącej rundzie ktoś złożył ofertę
    private boolean bidPlacedThisRound = false;

    public ExtendedAuction(String title, String description, double startingPrice,
                           int totalRounds, int minTrustPoints, User seller) {
        super(title, description, startingPrice, totalRounds, minTrustPoints, seller);
    }

    @Override
    public boolean placeBid(User bidder, double amount) {
        if (!canParticipate(bidder)) return false;
        if (amount <= currentPrice) {
            System.out.println("Oferta zbyt niska! Aktualna cena: " + currentPrice);
            return false;
        }
        currentPrice = amount;
        winner = bidder;
        bidders.add(bidder);
        amounts.add(amount);

        // kluczowa różnica od SimpleAuction: każda oferta wydłuża aukcję o 1 rundę
        totalRounds++;
        bidPlacedThisRound = true;
        System.out.println(bidder.getLogin() + " licytuje: " + amount
                + " PLN – aukcja wydluzona do " + totalRounds + " rund");
        return true;
    }

    // nadpisujemy nextRound z klasy Auction
    // jeśli nikt nie licytował w tej rundzie → kończymy aukcję
    @Override
    public void nextRound() {
        if (!bidPlacedThisRound) {
            finished = true;
            System.out.println("Nikt nie licytowal – aukcja zakonczona po rundzie " + currentRound);
        } else {
            bidPlacedThisRound = false; // resetujemy flagę na następną rundę
            super.nextRound();          // wywołujemy nextRound() z klasy Auction
        }
    }
}