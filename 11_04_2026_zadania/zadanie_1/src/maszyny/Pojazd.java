package maszyny;

public class Pojazd extends Maszyna {

    // static wspólne dla każdego obiektu Pojazd
    protected static int maxLiczbaPojazdow = 0;
    protected int nrPojazdu;
    protected double moc;
    protected double momentObrotowy;

    public Pojazd(String marka, String nazwa, double pojemnoscSilnika,
                  RodzajSilnika rodzajSilnika, double moc, double momentObrotowy) {
        super(marka, nazwa, pojemnoscSilnika, rodzajSilnika);
        maxLiczbaPojazdow++;
        this.nrPojazdu = maxLiczbaPojazdow;
        this.moc = moc;
        this.momentObrotowy = momentObrotowy;
    }

    public void wyswietl() {
        System.out.println("=== Pojazd " + nrPojazdu + " z " + maxLiczbaPojazdow + " ===");
        System.out.println("Marka:             " + marka);
        System.out.println("Nazwa:             " + nazwa);
        System.out.println("Pojemność silnika: " + pojemnoscSilnika + " cm³");
        System.out.println("Rodzaj silnika:    " + rodzajSilnika);
        System.out.println("Moc:               " + moc + " KM");
        System.out.println("Moment obrotowy:   " + momentObrotowy + " Nm");
    }



}
