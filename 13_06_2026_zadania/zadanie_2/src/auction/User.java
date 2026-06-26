package auction;


public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private int    trustPoints; // punkty zaufania – można je dostać lub stracić

    public User(String firstName, String lastName, String login, String email) {
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.login       = login;
        this.email       = email;
        this.trustPoints = 0; // nowy użytkownik zaczyna od zera
    }

    // sprzedający wywołuje tę metodę żeby nagrodzić kupującego
    public void addTrustPoint()    { this.trustPoints++; }

    // sprzedający wywołuje tę metodę żeby ukarać kupującego
    public void removeTrustPoint() { this.trustPoints--; }

    public String getLogin()       { return login; }
    public int    getTrustPoints() { return trustPoints; }
    public String getFullName()    { return firstName + " " + lastName; }
}
