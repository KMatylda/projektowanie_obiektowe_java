package cl;

public class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    // konstruktor domyślny - incjalizuje 12:00:00
    public Clock() {
        setHours(12);
        setMinutes(0);
        setSeconds(0);
    }

    //konstruktor zawierający 3 parametry: hours, minutes, seconds
    public Clock(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    //konstruktor z jednym parametrem
    public Clock(int totalSeconds) {
        totalSeconds = totalSeconds % 86400; //liczba sekund w jednej dobie
        this.hours = totalSeconds / 3600;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }

    //
    public void tick() {
        seconds++;

        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        if (hours == 24) {
            hours = 0;
        }
    }

    public void tickDown() {
        seconds--;

        if (seconds == -1) {
            seconds = 59;
            minutes--;
        }

        if (minutes == -1) {
            minutes = 59;
            hours--;
        }

        if (hours == -1) {
            hours = 23;
        }
    }

    @Override
    public String toString() {
        return String.format("[%02d:%02d:%02d%n]", hours, minutes, seconds);
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int newHours) {
        if (newHours < 0 || newHours > 23) {
            System.out.println("Wrong range (hours)! Enter numbers from 0 - 23");
        } else {
            this.hours = newHours;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int newMinutes) {
        if (newMinutes < 0 || newMinutes > 59) {
            System.out.println("Wrong range (hours)! Enter numbers from 0 - 59");
        } else {
            this.minutes = newMinutes;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int newSeconds) {
        if (newSeconds < 0 || newSeconds > 59) {
            System.out.println("Wrong range (hours)! Enter numbers from 0 - 59");
        } else {
            this.seconds = newSeconds;
        }
    }

}



