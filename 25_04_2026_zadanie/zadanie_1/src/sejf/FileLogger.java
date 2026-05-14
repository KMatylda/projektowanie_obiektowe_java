package sejf;

import java.io.FileWriter; // pisanie do pliku
import java.io.IOException; // błąd który może wystąpić przy pracy z plikiem
import java.io.PrintWriter; //opakowuje FileWriter, daje wygodną metodę println
import java.util.Date; // aktualna data i godzina

// Logger zapisujący zdarzenia do pliku
public class FileLogger implements Logger {

    private Severity logLevel;  // minimalny poziom zdarzenia
    private String filePath;    // ścieżka do pliku z logami

    // Konstruktor: ustalamy poziom logowania i ścieżkę pliku
    public FileLogger(Severity logLevel, String filePath) {
        this.logLevel = logLevel;
        this.filePath = filePath;
    }

    @Override
    public Severity getLogLevel() {
        return logLevel;
    }

    @Override
    public void logMessage(Severity severity, EventSource source, String message) {
        // Logujemy tylko jeśli poziom zdarzenia jest wystarczająco wysoki
        if (severity.ordinal() >= logLevel.ordinal()) {
            // Otwieramy plik w trybie dopisywania (append=true), zapisujemy log i zamykamy
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
                writer.println(new Date() + " | " + severity + " | " + source.getSourceName() + " | " + message);
                System.out.println("    [PLIK LOG -> " + filePath + "] Zapisano zdarzenie: " + severity + " - " + message);
            } catch (IOException e) {
                System.err.println("    [FileLogger] Błąd zapisu do pliku: " + e.getMessage());
            }
        }
    }
}