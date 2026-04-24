package maszyny;

public class Main {
    public static void main(String[] args) {
        ParkMaszynowy.main(args);

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

        // test Pojazd
        Pojazd p1 = new Pojazd("Toyota", "DDD", 1600, Maszyna.RodzajSilnika.BENZYNOWY, 132, 230);
        Pojazd p2 = new Pojazd("BMW", "WWW", 3000, Maszyna.RodzajSilnika.BENZYNOWY, 510, 650);
        Pojazd p3 = new Pojazd("Tesla", "XXX", 0, Maszyna.RodzajSilnika.ELEKTRYCZNY, 283, 420);

        p1.wyswietl();
        p2.wyswietl();
        p3.wyswietl();

        Samochod s1 = new Samochod("Toyota", "DDD", 1600, Maszyna.RodzajSilnika.BENZYNOWY,
                132, 230, Samochod.Segment.C, "WBA3A5C50CF256456");

        Jednoslad j1 = new Jednoslad("Honda", "XXX", 500, Maszyna.RodzajSilnika.BENZYNOWY,
                35, 43, Jednoslad.TypJednoSladu.MOTOCYKL);

        Jednoslad j2 = new Jednoslad("Trek", "NNNN", Jednoslad.TypJednoSladu.ROWER);

        s1.wyswietl();
        j1.wyswietl();
        j2.wyswietl();

    }
}
