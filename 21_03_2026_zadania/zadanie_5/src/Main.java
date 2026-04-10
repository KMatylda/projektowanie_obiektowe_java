import nu.Numbers;

public class Main {
    public static void main(String[] args) {

        Numbers test1 = new Numbers(2, 4, 8);
        if (test1.sum() == 14) {
            System.out.println("Test 1 sum() correct");
        } else {
            System.out.println("Test 1 sum() incorrect");
        }

        Numbers test2 = new Numbers(2, 4, 8);
        if (test2.average() == 4.666666666666667) {
            System.out.println("Test 2 average() correct");
        } else {
            System.out.println("Test 2 average() incorrect");
        }

        Numbers test3 = new Numbers(2, 4, 8);
        if (test3.min() == 2) {
            System.out.println("Test 3 min() correct");
        } else {
            System.out.println("Test 3 min() incorrect");
        }

        Numbers test4 = new Numbers(2, 4, 8);
        if (test4.max() == 8) {
            System.out.println("Test 4 max() correct");
        } else {
            System.out.println("Test 4 max() incorrect");
        }

        Numbers test5 = new Numbers(2, 4, 8);
        // Math.pow zwraca 4.00001 nie dokładnie 4.0 czyli robimy tzw.tolerancję
        if (Math.abs(test5.geometric() - 4.0) < 0.0001) {
            System.out.println("Test 5 geometric() correct");
        } else {
            System.out.println("Test 5 geometric() incorrect");
        }
    }
}
