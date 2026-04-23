package maszyny;

public class Lokomotywa extends Maszyna {

    private int rokProdukcji;
    private double maksymalnaPredkosc;

    public Lokomotywa(String marka, String nazwa, double pojemnoscSilnika,
                      RodzajSilnika rodzajSilnika, int rokProdukcji,
                      double maksymalnaPredkosc) {
        // super odwołuje się do klasy Maszyna, po której dziedziczymy
        super(marka, nazwa, pojemnoscSilnika, rodzajSilnika);
        this.rokProdukcji = rokProdukcji;
        this.maksymalnaPredkosc = maksymalnaPredkosc;
    }

    public void wyswietl() {
        System.out.println("=== Lokomotywa ===");
        System.out.println("Marka:               " + marka);
        System.out.println("Nazwa:               " + nazwa);
        System.out.println("Pojemność silnika:   " + pojemnoscSilnika + " cm³");
        System.out.println("Rodzaj silnika:      " + rodzajSilnika);
        System.out.println("Rok produkcji:       " + rokProdukcji);
        System.out.println("Maksymalna prędkość: " + maksymalnaPredkosc + " km/h");
    }
}