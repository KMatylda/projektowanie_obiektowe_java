package maszyny;

public class Jednoslad extends Pojazd {

    public enum TypJednoSladu {
        MOTOCYKL,
        SKUTER,
        ROWER,
        HULAJNOGA
    }

    private TypJednoSladu typ;

    // konstruktor pełny - dla motocykli, skuterów
    public Jednoslad(String marka, String nazwa, double pojemnoscSilnika,
                     RodzajSilnika rodzajSilnika, double moc, double momentObrotowy,
                     TypJednoSladu typ) {
        super(marka, nazwa, pojemnoscSilnika, rodzajSilnika, moc, momentObrotowy);
        this.typ = typ;
    }

    // konstruktor skrócony - dla rowerów i hulajnóg tradycyjnych
    public Jednoslad(String marka, String nazwa, TypJednoSladu typ) {
        super(marka, nazwa, 0, null, 0, 0);
        this.typ = typ;
    }

    @Override
    public void wyswietl() {
        System.out.println("=== Pojazd " + nrPojazdu + " z " + maxLiczbaPojazdow + " ===");
        System.out.println("Marka:             " + marka);
        System.out.println("Nazwa:             " + nazwa);
        System.out.println("Typ:               " + typ);
        if (pojemnoscSilnika != 0)
            System.out.println("Pojemność silnika: " + pojemnoscSilnika + " cm³");
        if (rodzajSilnika != null)
            System.out.println("Rodzaj silnika:    " + rodzajSilnika);
        if (moc != 0)
            System.out.println("Moc:               " + moc + " KM");
        if (momentObrotowy != 0)
            System.out.println("Moment obrotowy:   " + momentObrotowy + " Nm");
    }
}
