package sejf;

// Interfejs Loggera – każde urządzenie rejestrujące zdarzenia musi go implementować.
// Zadanie 2: dodajemy system logowania.
public interface Logger {

    // Poziom ważności – tylko zdarzenia o ważności >= logLevel będą rejestrowane
    Severity getLogLevel();

    // Metoda logująca zdarzenie:
    //   severity   – jak ważne jest zdarzenie
    //   source     – kto je wywołał (np. sejf)
    //   message    – opis słowny
    void logMessage(Severity severity, EventSource source, String message);
}