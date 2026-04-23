package pc;
public class Card {
   public enum Wartosc {
        DWA,
        TRZY,
        CZTERY,
        PIEC,
        SZESC,
        SIEDEM,
        OSIEM,
        DZIEWIEC,
        DZIESIEC,
        WALET,
        DAMA,
        KROL,
        AS,
    }

    public enum Kolor {
        KIER,
        KARO,
        PIK,
        TREFL,
    }

    private Wartosc mWartosc;
    private Kolor mKolor;

    public Card(Wartosc wartosc, Kolor kolor) {
        this.mWartosc = wartosc;
        this.mKolor = kolor;

    }
    public Wartosc getWartosc() {
        return this.mWartosc;
    }

    public Kolor getKolor() {
        return this.mKolor;
    }
}
