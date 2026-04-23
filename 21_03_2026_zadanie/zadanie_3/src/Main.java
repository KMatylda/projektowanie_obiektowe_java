import md.MyDate;

public class Main {
    public static void main(String[] args) {

        // Test 1 poprawne dane i format
        MyDate t1 = new MyDate(1, 2, 1990);
        t1.displayDate();

        // Test 2 zły zakres
        MyDate t2 = new MyDate(45, 13, 2026);
        t2.displayDate();

    }

}