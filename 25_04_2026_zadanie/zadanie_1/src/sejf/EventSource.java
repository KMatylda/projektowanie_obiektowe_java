package sejf;

// Interfejs znacznikowy – każda klasa, która może być źródłem zdarzenia,
// powinna go implementować. Np. sejf, alarm itp.
public interface EventSource {
    // metoda pomocnicza – zwraca nazwę źródła do wyświetlenia w logu
    String getSourceName();
}
