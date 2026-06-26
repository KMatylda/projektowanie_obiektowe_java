package auction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuctionSystem {

    // wszystkie aukcje w systemie
    private List<Auction> auctions = new ArrayList<>();

    public void addAuction(Auction a) { auctions.add(a); }

    // przechodzi do następnej rundy we wszystkich aktywnych aukcjach
    public void nextRoundAll() {
        for (Auction a : auctions) {
            if (!a.isFinished()) a.nextRound(); // pomijamy już zakończone
        }
    }

    // zwraca listę aukcji które jeszcze trwają
    public List<Auction> findActive() {
        return auctions.stream()
                .filter(a -> !a.isFinished())
                .collect(Collectors.toList());
    }

    // zwraca listę aukcji które już się skończyły
    public List<Auction> findFinished() {
        return auctions.stream()
                .filter(Auction::isFinished)
                .collect(Collectors.toList());
    }

    // zwraca aukcje wystawione przez użytkownika o podanym loginie
    public List<Auction> findBySeller(String login) {
        return auctions.stream()
                .filter(a -> a.getSeller().getLogin().equals(login))
                .collect(Collectors.toList());
    }

    // sprzedający przyznaje punkt kupującemu – tylko sprzedający tej aukcji może to zrobić
    public void grantTrustPoint(User seller, User buyer, Auction auction) {
        if (!auction.getSeller().getLogin().equals(seller.getLogin())) {
            System.out.println("Blad: tylko sprzedajacy moze przyznac punkt!");
            return;
        }
        buyer.addTrustPoint();
        System.out.println(seller.getLogin() + " przyznal punkt dla " + buyer.getLogin());
    }

    // sprzedający odbiera punkt kupującemu – tylko sprzedający tej aukcji może to zrobić
    public void revokeTrustPoint(User seller, User buyer, Auction auction) {
        if (!auction.getSeller().getLogin().equals(seller.getLogin())) {
            System.out.println("Blad: tylko sprzedajacy moze odebrac punkt!");
            return;
        }
        buyer.removeTrustPoint();
        System.out.println(seller.getLogin() + " odebral punkt od " + buyer.getLogin());
    }
}