package maszyny;

import java.util.ArrayList;
import java.util.List;

public class ParkMaszynowy {
    public static void main(String[] args) {

        List<Maszyna> park = new ArrayList<>();

        // 2x Lokomotywa
        park.add(new Lokomotywa("Newag", "Dragon 2", 0,
                Maszyna.RodzajSilnika.ELEKTRYCZNY, 2021, 160));
        park.add(new Lokomotywa("Pesa", "Gama", 0,
                Maszyna.RodzajSilnika.DIESEL, 2015, 140));

        // 2x Kosiarka
        Kosiarka k1 = new Kosiarka("Husqvarna", "LC 353V", 160,
                Maszyna.RodzajSilnika.BENZYNOWY, false, true, 1);
        Kosiarka k2 = new Kosiarka("Bosch", "Rotak 43", 0,
                Maszyna.RodzajSilnika.ELEKTRYCZNY, true, false, 2);
        park.add(k1);
        park.add(k2);

        // 2x Samochod
        park.add(new Samochod("Toyota", "Corolla", 1600,
                Maszyna.RodzajSilnika.BENZYNOWY, 132, 230,
                Samochod.Segment.C, "WBA3A5C50CF256456"));
        park.add(new Samochod("BMW", "M3", 3000,
                Maszyna.RodzajSilnika.BENZYNOWY, 510, 650,
                Samochod.Segment.D, "WBS8M9C50J5J12345"));

        // 2x Jednoslad
        park.add(new Jednoslad("Honda", "CB500", 500,
                Maszyna.RodzajSilnika.BENZYNOWY, 35, 43,
                Jednoslad.TypJednoSladu.MOTOCYKL));
        park.add(new Jednoslad("Trek", "Marlin 5",
                Jednoslad.TypJednoSladu.ROWER));

        // wyświetlanie wszystkich obiektów pętlą for-each
        for (Maszyna m : park) {
            m.wyswietl();
            System.out.println();
        }

        // setter na obiekcie Kosiarka i ponowne wyświetlenie
        System.out.println("=== Po zmianie ustawień kosiarki k1 ===");
        System.out.println();
        k1.setCzyMelekser(true);
        k1.setLiczbaOstrzy(3);
        k1.wyswietl();
    }
}