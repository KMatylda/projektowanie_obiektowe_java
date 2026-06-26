package auction;

import java.util.ArrayList;
import java.util.List;

// abstract = nie można zrobić new Auction() bezpośrednio
// trzeba użyć konkretnego typu: SimpleAuction, ExtendedAuction, ReverseAuction
public abstract class Auction {

    protected String  title;
    protected String  description;
    protected double  startingPrice;  // cena na początku aukcji
    protected int     totalRounds;    // ile rund ma trwać aukcja
    protected int     currentRound;   // w której rundzie jesteśmy teraz
    protected int     minTrustPoints; // minimalne punkty zaufania żeby licytować
    protected User    seller;         // kto wystawił aukcję
    protected User    winner;         // kto aktualnie wygrywa (null jeśli nikt nie licytował)
    protected double  currentPrice;   // aktualna najwyższa cena
    protected boolean finished;       // true = aukcja zakończona

    protected List<User>   bidders = new ArrayList<>(); // historia licytujących
    protected List<Double> amounts = new ArrayList<>(); // historia ofert

    public Auction(String title, String description, double startingPrice,
                   int totalRounds, int minTrustPoints, User seller) {
        this.title          = title;
        this.description    = description;
        this.startingPrice  = startingPrice;
        this.currentPrice   = startingPrice; // na starcie cena = cena wywoławcza
        this.totalRounds    = totalRounds;
        this.currentRound   = 1;             // zaczynamy od rundy 1
        this.minTrustPoints = minTrustPoints;
        this.seller         = seller;
        this.finished       = false;
    }

    // przejście do następnej rundy
    // ExtendedAuction nadpisuje tę metodę – dlatego jest tu słowo kluczowe dla podklas
    public void nextRound() {
        currentRound++;
        if (currentRound > totalRounds) {
            finished = true; // przekroczyliśmy limit rund → koniec
        }
    }

    // abstract = każdy typ aukcji MUSI zaimplementować tę metodę po swojemu
    // SimpleAuction, ExtendedAuction i ReverseAuction robią to inaczej
    public abstract boolean placeBid(User bidder, double amount);

    // sprawdza czy użytkownik ma wystarczające punkty zaufania
    protected boolean canParticipate(User user) {
        return user.getTrustPoints() >= minTrustPoints;
    }

    public boolean isFinished()      { return finished; }
    public String  getTitle()        { return title; }
    public User    getSeller()       { return seller; }
    public User    getWinner()       { return winner; }
    public double  getCurrentPrice() { return currentPrice; }
    public int     getCurrentRound() { return currentRound; }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + title
                + " | Runda: " + currentRound + "/" + totalRounds
                + " | Cena: " + currentPrice
                + " | " + (finished ? "ZAKONCZONA" : "TRWA");
    }
}
