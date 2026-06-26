package auction;

public class Main {
    public static void main(String[] args) {

        // tworzymy użytkowników
        User anna  = new User("Anna",  "Kowalska",   "anna_k",  "anna@mail.com");
        User marek = new User("Marek", "Nowak",      "marek_n", "marek@mail.com");
        User ewa   = new User("Ewa",   "Wisniewska", "ewa_w",   "ewa@mail.com");

        AuctionSystem system = new AuctionSystem();

        // tworzymy aukcje przez fabrykę – wzorzec Factory Method
        // nigdzie nie piszemy new SimpleAuction() bezpośrednio
        Auction a1 = AuctionFactory.create(AuctionFactory.SIMPLE,
                "Laptop Dell", "Uzywany, dobry stan", 500.0, 3, 0, anna);
        Auction a2 = AuctionFactory.create(AuctionFactory.EXTENDED,
                "Rower MTB", "Rama L, shimano", 300.0, 2, 0, anna);
        Auction a3 = AuctionFactory.create(AuctionFactory.REVERSE,
                "iPhone 14", "Nowy, gwarancja", 2000.0, 5, 0, marek);

        system.addAuction(a1);
        system.addAuction(a2);
        system.addAuction(a3);

        // runda 1
        System.out.println("=== RUNDA 1 ===");
        a1.placeBid(marek, 550.0); // marek licytuje laptopa
        a1.placeBid(ewa,   620.0); // ewa przelicytowuje
        a2.placeBid(marek, 350.0); // marek licytuje rower – aukcja wydłuży się o 1 rundę
        a3.placeBid(ewa,   1.0);   // ewa składa ofertę – cena iPhone spada o 1 zł

        // przechodzimy do rundy 2 we wszystkich aukcjach
        system.nextRoundAll();

        // runda 2
        System.out.println("\n=== RUNDA 2 ===");
        a1.placeBid(marek, 700.0); // marek znów licytuje laptopa
        // a2: nikt nie licytuje → ExtendedAuction zakończy się przy nextRoundAll()
        a3.placeBid(marek, 1.0);   // marek obniża cenę iPhone

        // a2 zakończy się tutaj bo nikt nie licytował w rundzie 2
        system.nextRoundAll();

        // wyniki
        System.out.println("\n=== WYNIKI ===");
        System.out.println("Aktywne:    " + system.findActive().size());
        System.out.println("Zakonczone: " + system.findFinished().size());

        System.out.println("\nAukcje Anny:");
        system.findBySeller("anna_k").forEach(System.out::println);

        // anna przyznaje punkt marekowi za udaną transakcję (laptop)
        system.grantTrustPoint(anna, marek, a1);
        System.out.println("Punkty Marka: " + marek.getTrustPoints());
    }
}
