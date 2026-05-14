package sejf;

// Alarm dźwiękowy – włącza syrenę gdy ktoś wpisze zły pin
public class SoundAlarm implements Alarm {

    private Logger logger; // podłączone urządzenie logujące (może być null)

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void alarmTurnOn(PinEvent event) {
        System.out.println("  [SoundAlarm] BEEEP BEEEP! Alarm dźwiękowy włączony!");

        if (logger != null) {
            logger.logMessage(Severity.ERROR, event.getSafe(), "Alarm dźwiękowy włączony – błędny pin.");
        }
    }

    @Override
    public void alarmTurnOff(PinEvent event) {
        System.out.println("  [SoundAlarm] Alarm dźwiękowy wyłączony.");

        if (logger != null) {
            logger.logMessage(Severity.INFO, event.getSafe(), "Alarm dźwiękowy wyłączony – poprawny pin.");
        }
    }
}