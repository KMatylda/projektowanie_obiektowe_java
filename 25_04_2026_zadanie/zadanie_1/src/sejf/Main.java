package sejf;


// ZADANIE 3 – Testy poprawności działania sejfu
// Różne konfiguracje alarmów i loggerów


public class Main {

    public static void main(String[] args) {


        // TEST 1: Sejf tylko z alarmem dźwiękowym, bez loggera

        System.out.println("========================================");
        System.out.println("TEST 1: Alarm dźwiękowy, brak loggera");
        System.out.println("========================================");

        Safe sejf1 = new Safe("1234");           // tworzymy sejf z pinem "1234"
        SoundAlarm soundAlarm = new SoundAlarm(); // tworzymy alarm dźwiękowy
        sejf1.addAlarm(soundAlarm);               // podłączamy alarm do sejfu

        sejf1.enterPin("0000"); // wpisujemy ZŁY pin – oczekujemy alarmu dźwiękowego
        sejf1.enterPin("1234"); // wpisujemy DOBRY pin – alarm powinien się wyłączyć


        // TEST 2: Sejf z alarmem dźwiękowym i loggerem konsolowym

        System.out.println("\n========================================");
        System.out.println("TEST 2: Alarm dźwiękowy + ConsoleLogger (poziom WARNING)");
        System.out.println("========================================");

        Safe sejf2 = new Safe("abcd");                          // pin to "abcd"
        SoundAlarm soundAlarm2 = new SoundAlarm();              // alarm dźwiękowy
        ConsoleLogger consoleLogger = new ConsoleLogger(Severity.WARNING); // logujemy od WARNING wzwyż
        soundAlarm2.setLogger(consoleLogger);                   // podłączamy logger do alarmu
        sejf2.addAlarm(soundAlarm2);                            // podłączamy alarm do sejfu

        sejf2.enterPin("zzzz"); // ZŁY pin – alarm włączony, logger zapisze ERROR (>= WARNING)
        sejf2.enterPin("abcd"); // DOBRY pin – alarm wyłączony, logger NIE zapisze INFO (< WARNING)


        // TEST 3: Sejf z wieloma alarmami i loggerem do pliku
        System.out.println("\n========================================");
        System.out.println("TEST 3: Wiele alarmów (psy + policja) + FileLogger");
        System.out.println("========================================");

        Safe sejf3 = new Safe("9999");                    // pin to "9999"

        DogsAlarm dogsAlarm = new DogsAlarm();            // alarm z psami
        PoliceAlarm policeAlarm = new PoliceAlarm();      // alarm policyjny

        // Tworzymy FileLogger zapisujący do pliku alarm_log.txt, od poziomu INFO
        FileLogger fileLogger = new FileLogger(Severity.INFO, "alarm_log.txt");

        dogsAlarm.setLogger(fileLogger);    // psy logują do pliku
        policeAlarm.setLogger(fileLogger);  // policja też loguje do tego samego pliku

        sejf3.addAlarm(dogsAlarm);          // podłączamy alarm z psami
        sejf3.addAlarm(policeAlarm);        // podłączamy alarm policyjny

        sejf3.enterPin("1111"); // ZŁY pin – obydwa alarmy włączone, obydwa wpiszą do pliku
        sejf3.enterPin("9999"); // DOBRY pin – obydwa alarmy wyłączone, logowane w pliku



        // TEST 4: Sejf bez żadnych alarmów (edge case)

        System.out.println("\n========================================");
        System.out.println("TEST 4: Sejf bez alarmów");
        System.out.println("========================================");

        Safe sejf4 = new Safe("xyz"); // sejf bez żadnych alarmów

        sejf4.enterPin("abc"); // ZŁY pin – nic się nie stanie (brak alarmów)
        sejf4.enterPin("xyz"); // DOBRY pin – sejf się otworzy cicho

        System.out.println("\n========================================");
        System.out.println("Wszystkie testy zakończone!");
        System.out.println("Sprawdź pliki alarm_log.txt i sound_log.txt");
        System.out.println("========================================");
    }
}
