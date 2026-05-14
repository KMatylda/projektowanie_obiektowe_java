package sejf;

// Interfejs Alarm – każdy rodzaj alarmu MUSI implementować te dwie metody.
// Dzięki temu sejf nie musi wiedzieć, jaki konkretnie alarm jest podłączony.
public interface Alarm {

    // logger – urządzenie rejestrujące, które można podłączyć do alarmu (Zadanie 2)
    Logger getLogger();
    void setLogger(Logger logger);

    // Włącz alarm – wywoływane gdy ktoś wpisze ZŁY pin
    void alarmTurnOn(PinEvent event);

    // Wyłącz alarm – wywoływane gdy ktoś wpisze DOBRY pin
    void alarmTurnOff(PinEvent event);
}
