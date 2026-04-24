package maszyny;

public class Samochod extends Pojazd {

    public enum Segment {
        A, B, C, D, E, F, SUV, VAN
    }

    private Segment segment;
    private String VIN;

    public Samochod(String marka, String nazwa, double pojemnoscSilnika,
                    RodzajSilnika rodzajSilnika, double moc, double momentObrotowy,
                    Segment segment, String VIN) {
        super(marka, nazwa, pojemnoscSilnika, rodzajSilnika, moc, momentObrotowy);
        this.segment = segment;
        this.VIN = VIN;
    }

    @Override
    public void wyswietl() {
        super.wyswietl();
        System.out.println("Segment:           " + segment);
        System.out.println("VIN:               " + VIN);
    }
}