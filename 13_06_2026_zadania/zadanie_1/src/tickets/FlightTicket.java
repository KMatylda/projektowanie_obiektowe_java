package tickets;


public class FlightTicket {

    // Dane o locie – pola prywatne (enkapsulacja)
    private String from;            // kod lotniska skąd, np. "WAW"
    private String to;              // kod lotniska dokąd, np. "LHR"
    private long   departureTimeMs; // czas odlotu jako timestamp (milisekundy)
    private double price;           // cena biletu w PLN
    private int    stops;           // liczba przesiadek: 0 = bezpośredni
    private int    durationMinutes; // czas lotu w minutach
    private String airline;         // nazwa linii, np. "United Airlines"

    // Konstruktor – ustawia wszystkie pola na raz
    public FlightTicket(String from, String to, long departureTimeMs,
                        double price, int stops, int durationMinutes, String airline) {
        this.from            = from;
        this.to              = to;
        this.departureTimeMs = departureTimeMs;
        this.price           = price;
        this.stops           = stops;
        this.durationMinutes = durationMinutes;
        this.airline         = airline;
    }

    // Gettery – jedyny sposób odczytu pól z zewnątrz
    public double getPrice()          { return price; }
    public int    getStops()          { return stops; }
    public int    getDurationMinutes(){ return durationMinutes; }
    public String getAirline()        { return airline; }
    public String getFrom()           { return from; }
    public String getTo()             { return to; }

    // toString – ładny wydruk na ekran
    @Override
    public String toString() {
        return airline + " | " + from + " -> " + to
                + " | Cena: " + price + " PLN"
                + " | Przesiadki: " + stops
                + " | Czas: " + durationMinutes + " min";
    }
}

