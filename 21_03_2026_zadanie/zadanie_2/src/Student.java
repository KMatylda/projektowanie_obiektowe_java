package st;

public class Student {
    private String imie;
    private String nazwisko;
    private int numerIndeksu;
    private float obecnosc;
    private int ocenaPoj;

    //konstruktor bezwarunkowy - ustawia "Unknown"
    public Student() {
        this.imie = "Unknown";
        this.nazwisko = "Unknown";
    }

    // konstruktor z imieniem i nazwiskiem
    public Student(String imie, String nazwisko) {
            setImie(imie);
            setNazwisko(nazwisko);
    }

    // metoda get
    public String getImie() {
        return imie;
    }

    // metoda set
    public void setImie(String newImie) {
        // is.Empty sprawdza dodatkowo czy tekst jest pusty
        if (newImie == null || newImie.isEmpty()) {
            this.imie = "Unknown";
        } else {
            this.imie = newImie;
        }
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String newNazwisko) {
        if (newNazwisko == null || newNazwisko.isEmpty()) {
            this.nazwisko = "Unknown";
        } else {
            this.nazwisko = newNazwisko;
        }
    }

    public int getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(int newNumerIndeksu) {
        this.numerIndeksu = newNumerIndeksu;
    }

    public float getObecnosc() {
        return obecnosc;
    }

    public void setObecnosc(float newObecnosc) {
        this.obecnosc = newObecnosc;
    }

    public int getOcenaPoj() {
        // if jeżeli obeconośc mniejsza niż 50 % zwroć ocenę 2
        if (obecnosc < 0.5f) {
            return 2;
        } else
            return ocenaPoj;
    }

    public void setOcenaPoj(int newOcenaPoj) {
        this.ocenaPoj = newOcenaPoj;
    }


}
