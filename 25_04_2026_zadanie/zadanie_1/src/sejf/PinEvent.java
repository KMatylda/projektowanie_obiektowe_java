package sejf;

import java.util.Date;

// PinEvent – obiekt zdarzenia przekazywany do alarmu.
// Zawiera informację o tym, który sejf wywołał zdarzenie i kiedy.
public class PinEvent {

    private Safe safe;          // sejf, który wygenerował zdarzenie
    public Date eventDate;      // data i godzina zdarzenia

    // Konstruktor: tworzymy zdarzenie przekazując sejf, który je wywołał
    public PinEvent(Safe safe) {
        this.safe = safe;           // zapamiętujemy sejf
        this.eventDate = new Date(); // ustawiamy aktualną datę/godzinę
    }

    // Getter – pozwala alarmowi dowiedzieć się, który sejf go wywołał
    public Safe getSafe() {
        return safe;
    }
}