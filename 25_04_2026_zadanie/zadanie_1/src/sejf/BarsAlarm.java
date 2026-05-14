package sejf;

// Alarm kratowy – opuszcza metalową kratę blokując wejście
public class BarsAlarm implements Alarm {

    private Logger logger;

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
        System.out.println("  [BarsAlarm] Krata opuszczona! Wejście zablokowane.");

        if (logger != null) {
            logger.logMessage(Severity.ERROR, event.getSafe(), "Krata opuszczona – próba włamania o " + event.eventDate);
        }
    }

    @Override
    public void alarmTurnOff(PinEvent event) {
        System.out.println("  [BarsAlarm] Krata podniesiona.");

        if (logger != null) {
            logger.logMessage(Severity.INFO, event.getSafe(), "Krata podniesiona – dostęp przyznany.");
        }
    }
}
