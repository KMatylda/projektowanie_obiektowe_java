package sejf;

import java.util.ArrayList;
import java.util.List;

// Klasa Safe – główna klasa symulująca działanie sejfu.
// Implementuje EventSource, bo sejf może być źródłem zdarzeń logowanych przez Logger.
public class Safe implements EventSource {

    private List<Alarm> alarms; // lista alarmów podłączonych do sejfu
    private String pin;         // poprawny pin do otwarcia sejfu

    // Konstruktor: tworzymy sejf z zadanym pinem
    public Safe(String pin) {
        this.pin = pin;                     // ustawiamy pin
        this.alarms = new ArrayList<>();    // tworzymy pustą listę alarmów
    }

    // Dodaje nowy alarm do sejfu
    public void addAlarm(Alarm alarm) {
        alarms.add(alarm); // dołączamy alarm do listy
    }

    // Usuwa alarm z sejfu
    public void removeAlarm(Alarm alarm) {
        alarms.remove(alarm); // usuwamy alarm z listy
    }

    // Metoda wywoływana gdy użytkownik wpisuje pin.
    // Sprawdza pin i wywołuje odpowiednią reakcję.
    public void enterPin(String enteredPin) {
        if (enteredPin.equals(this.pin)) {
            // Pin poprawny – informujemy wszystkie alarmy o poprawnym wpisaniu pinu
            correctPin();
        } else {
            // Pin błędny – informujemy wszystkie alarmy o błędnym wpisaniu pinu
            wrongPin();
        }
    }

    // Wywoływana gdy podano ZŁY pin – włącza wszystkie alarmy
    public void wrongPin() {
        System.out.println("[Sejf] Błędny pin! Uruchamianie alarmów...");
        PinEvent event = new PinEvent(this); // tworzymy zdarzenie powiązane z tym sejfem

        // Iterujemy po wszystkich alarmach i każdy z nich włączamy
        for (Alarm alarm : alarms) {
            alarm.alarmTurnOn(event); // każdy alarm reaguje po swojemu
        }
    }

    // Wywoływana gdy podano DOBRY pin – wyłącza wszystkie alarmy
    public void correctPin() {
        System.out.println("[Sejf] Poprawny pin! Sejf otwarty.");
        PinEvent event = new PinEvent(this); // tworzymy zdarzenie powiązane z tym sejfem

        // Iterujemy po wszystkich alarmach i każdy z nich wyłączamy
        for (Alarm alarm : alarms) {
            alarm.alarmTurnOff(event); // każdy alarm wyłącza swoje działanie
        }
    }

    // Implementacja metody z interfejsu EventSource –
    // zwraca nazwę sejfu do wyświetlenia w logu
    @Override
    public String getSourceName() {
        return "Sejf";
    }
}