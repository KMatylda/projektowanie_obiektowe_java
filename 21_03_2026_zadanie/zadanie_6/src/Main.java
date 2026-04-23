import iv.Invoice;

public class Main {
    public static void main(String[] args) {

        // Test 1: Normal case – 3 items at 2.50 each
        Invoice test1 = new Invoice("001", "Pen", 3, 2.50);
        if (test1.amount() == 7.50) {
            System.out.println("Test 1 amount() correct");
        } else {
            System.out.println("Test 1 amount() incorrect");
        }

        // Test 2: Negative price – should return 0
        Invoice test2 = new Invoice("002", "Notebook", 5, -1.00);
        if (test2.amount() == 0) {
            System.out.println("Test 2 amount() correct");
        } else {
            System.out.println("Test 2 amount() incorrect");
        }

        // Test 3: Negative quantity – should return 0
        Invoice test3 = new Invoice("003", "Ruler", -2, 3.00);
        if (test3.amount() == 0) {
            System.out.println("Test 3 amount() correct");
        } else {
            System.out.println("Test 3 amount() incorrect");
        }


    }

}
