import cl.Clock;

public class Main {
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        // konstruktor domyślny
        Clock c1 = new Clock();
        test("Konstruktor domyślny - hours", c1.getHours() == 12);
        test("Konstruktor domyślny - minutes", c1.getMinutes() == 0);
        test("Konstruktor domyślny - seconds", c1.getSeconds() == 0);

        // konstruktor z 3 parametrami
        Clock c2 = new Clock(8, 30, 45);
        test("Konstruktor (h,m,s) - hours",   c2.getHours()   == 8);
        test("Konstruktor (h,m,s) - minutes", c2.getMinutes() == 30);
        test("Konstruktor (h,m,s) - seconds", c2.getSeconds() == 45);

        // konstruktor stowrzony z sekund
        // 3661 = 1h 1 min 1 sec
        Clock c3 = new Clock(3661);
        test("Konstruktor (totalSec) - hours",   c3.getHours()   == 1);
        test("Konstruktor (totalSec) - minutes", c3.getMinutes() == 1);
        test("Konstruktor (totalSec) - seconds", c3.getSeconds() == 1);
        // 0 s = 00:00:00
        Clock c4 = new Clock(0);
        test("Konstruktor (0 sec) - hours",   c4.getHours()   == 0);
        test("Konstruktor (0 sec) - minutes", c4.getMinutes() == 0);
        test("Konstruktor (0 sec) - seconds", c4.getSeconds() == 0);

        // 86399 s = 23:59:59
        Clock c5 = new Clock(86399);
        test("Konstruktor (86399 sec) - hours",   c5.getHours()   == 23);
        test("Konstruktor (86399 sec) - minutes", c5.getMinutes() == 59);
        test("Konstruktor (86399 sec) - seconds", c5.getSeconds() == 59);

        // tick() test zwykły
        Clock t1 = new Clock(0, 0, 1);
        t1.tick();
        test("tick() 00:00:01 -> 00:00:02", t1.getSeconds() == 2);

        // tick() – przeniesienie sekund na minuty
        Clock t2 = new Clock(0, 0, 59);
        t2.tick();
        test("tick() 00:00:59 -> minutes++", t2.getMinutes() == 1);
        test("tick() 00:00:59 -> seconds=0", t2.getSeconds() == 0);

        // tick() – przeniesienie minut na godziny
        Clock t3 = new Clock(0, 59, 59);
        t3.tick();
        test("tick() 00:59:59 -> hours=1",   t3.getHours()   == 1);
        test("tick() 00:59:59 -> minutes=0", t3.getMinutes() == 0);
        test("tick() 00:59:59 -> seconds=0", t3.getSeconds() == 0);

        // tick() – północ (23:59:59 -> 00:00:00)
        Clock t4 = new Clock(23, 59, 59);
        t4.tick();
        test("tick() 23:59:59 -> 00:00:00 hours",   t4.getHours()   == 0);
        test("tick() 23:59:59 -> 00:00:00 minutes", t4.getMinutes() == 0);
        test("tick() 23:59:59 -> 00:00:00 seconds", t4.getSeconds() == 0);

        //test tickDown()
        Clock d1 = new Clock(0, 0, 5);
        d1.tickDown();
        test("tickDown() 00:00:05 -> 00:00:04", d1.getSeconds() == 4);

        // tickDown() – pożyczenie z minut
        Clock d2 = new Clock(0, 1, 0);
        d2.tickDown();
        test("tickDown() 00:01:00 -> minutes=0",  d2.getMinutes() == 0);
        test("tickDown() 00:01:00 -> seconds=59", d2.getSeconds() == 59);

        // tickDown() – pożyczenie z godzin
        Clock d3 = new Clock(1, 0, 0);
        d3.tickDown();
        test("tickDown() 01:00:00 -> hours=0",    d3.getHours()   == 0);
        test("tickDown() 01:00:00 -> minutes=59", d3.getMinutes() == 59);
        test("tickDown() 01:00:00 -> seconds=59", d3.getSeconds() == 59);

        // tickDown() – północ (00:00:00 -> 23:59:59)
        Clock d4 = new Clock(0, 0, 0);
        d4.tickDown();
        test("tickDown() 00:00:00 -> 23:59:59 hours",   d4.getHours()   == 23);
        test("tickDown() 00:00:00 -> 23:59:59 minutes", d4.getMinutes() == 59);
        test("tickDown() 00:00:00 -> 23:59:59 seconds", d4.getSeconds() == 59);

        // test toString()
        Clock s1 = new Clock(3, 12, 56);
        test("toString() format [03:12:56]", s1.toString().equals("[03:12:56]"));

        Clock s2 = new Clock(0, 0, 0);
        test("toString() format [00:00:00]", s2.toString().equals("[00:00:00]"));

        Clock s3 = new Clock(23, 59, 59);
        test("toString() format [23:59:59]", s3.toString().equals("[23:59:59]"));

        // settery walidacja złych danych
        Clock v1 = new Clock(10, 10, 10);
        v1.setHours(99);
        test("setHours(99) - wartość bez zmian", v1.getHours() == 10);

        Clock v2 = new Clock(10, 10, 10);
        v2.setMinutes(-5);
        test("setMinutes(-5) - wartość bez zmian", v2.getMinutes() == 10);

        Clock v3 = new Clock(10, 10, 10);
        v3.setSeconds(60);
        test("setSeconds(60) - wartość bez zmian", v3.getSeconds() == 10);

        System.out.println("=== Wyniki: " + passed + " zaliczone / " + failed + " niezaliczone ===");

    }

    static void test(String name, boolean condition) {
        if (condition) {
            System.out.println("PASS: " + name);
            passed++;
        } else {
            System.out.println("FAIL: " + name);
            failed++;
        }

    }
}
