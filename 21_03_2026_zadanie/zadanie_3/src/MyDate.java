package md;

public class MyDate {
    private int month;
    private int day;
    private int year;

    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void displayDate() {
        // % początek formatowania, 0 uzupełnia 0, 2  szerokość
        // d liczba całkowita (integer)
        System.out.printf("%02d/%02d/%d%n", day, month, year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int newDay) {
        if (newDay < 0 || newDay > 31) {
            System.out.println("Wrong range (day)! Enter numbers from 0 - 31");
        } else {
            this.day = newDay;
        }
    }


    public int getMonth() {
        return month;
    }

    public void setMonth(int newMonth) {
        if (newMonth < 0 || newMonth > 12) {
            System.out.println("Wrong range (month)! Enter numbers from 0 - 12");
        } else {
            this.month = newMonth;
        }
    }


    public int getYear() {
        return year;
    }

    public void setYear(int newYear) {
        if (newYear < 1990 || newYear > 2050) {
            System.out.println("Wrong range (year)! Enter numbers from 1990 - 2050");
        } else {
            this.year = newYear;
        }

    }
}