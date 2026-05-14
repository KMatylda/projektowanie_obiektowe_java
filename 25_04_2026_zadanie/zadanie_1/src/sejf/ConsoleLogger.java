package sejf;


// Logger wypisujący zdarzenia na konsolę
public class ConsoleLogger implements Logger {

    private Severity logLevel; // minimalny poziom zdarzenia, żeby zostało zalogowane

    // Konstruktor: ustalamy, od jakiego poziomu ważności logujemy zdarzenia
    public ConsoleLogger(Severity logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public Severity getLogLevel() {
        return logLevel;
    }

    @Override
    public void logMessage(Severity severity, EventSource source, String message) {
        // Logujemy tylko jeśli poziom zdarzenia jest >= naszemu progowi
        //  ordinal (porównujemy kolejność w enum: INFO=0, WARNING=1, ERROR=2)
        if (severity.ordinal() >= logLevel.ordinal()) {
            System.out.println("    [KONSOLA LOG | " + severity + " | " + source.getSourceName() + "] " + message);
        }
    }
}
