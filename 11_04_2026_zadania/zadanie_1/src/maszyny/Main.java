package maszyny;

public class Main {
    public static void main(String[] args) {

        // LOKOMOTYWA
        Lokomotywa lok = new Lokomotywa(
                "Newag",
                "EU07",
                0,
                Maszyna.RodzajSilnika.ELEKTRYCZNY,
                2021,
                160.0
        );

        lok.wyswietl();

        // KOSIARKA
        Kosiarka kos = new Kosiarka(
                "Husqvarna",
                "LC 353V",
                160,
                Maszyna.RodzajSilnika.BENZYNOWY,
                false,
                true,
                1
        );

        kos.wyswietl();

// test zmiany atrybutów przez settery
        kos.setCzyMelekser(true);
        kos.setCzyNaped(false);
        kos.setLiczbaOstrzy(3);
        kos.wyswietl();
    }
}
