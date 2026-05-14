package sejf;

// Alarm z psami – wypuszcza psy gdy ktoś wpisze zły pin
public class DogsAlarm implements Alarm {

    private Logger logger;

    @Override
    public Logger getLogger() { return logger; }

    @Override
    public void setLogger(Logger logger) { this.logger = logger; }

    @Override
    public void alarmTurnOn(PinEvent event) {
        System.out.println("  [DogsAlarm]  Psy wypuszczone!");

        if (logger != null) {
            logger.logMessage(Severity.WARNING, event.getSafe(), "Psy wypuszczone – wykryto nieautoryzowany dostęp.");
        }
    }

    @Override
    public void alarmTurnOff(PinEvent event) {
        System.out.println("  [DogsAlarm] Psy schowane.");

        if (logger != null) {
            logger.logMessage(Severity.INFO, event.getSafe(), "Psy schowane.");
        }
    }
}