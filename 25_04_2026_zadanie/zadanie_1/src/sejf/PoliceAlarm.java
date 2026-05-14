package sejf;

// Alarm policyjny – wzywa policję gdy ktoś wpisze zły pin
public class PoliceAlarm implements Alarm {

    private Logger logger;

    @Override
    public Logger getLogger() { return logger; }

    @Override
    public void setLogger(Logger logger) { this.logger = logger; }

    @Override
    public void alarmTurnOn(PinEvent event) {
        System.out.println("  [PoliceAlarm] Wezwano policję! Numer zgłoszenia: #" + event.eventDate.getTime());

        if (logger != null) {
            logger.logMessage(Severity.ERROR, event.getSafe(), "Policja wezwana – błędny pin o " + event.eventDate);
        }
    }

    @Override
    public void alarmTurnOff(PinEvent event) {
        System.out.println("  [PoliceAlarm] Odwołano policję.");

        if (logger != null) {
            logger.logMessage(Severity.INFO, event.getSafe(), "Alarm policyjny odwołany.");
        }
    }
}
