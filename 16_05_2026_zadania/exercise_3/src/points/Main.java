package points;

public class Main {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        System.out.println(t1);
        System.out.printf("Perimeter: %.2f%n", t1.getPerimeter());
        System.out.println("Type: " + t1.getType());

        System.out.println();

        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(5, 0);
        MyPoint p3 = new MyPoint(0, 5);
        MyTriangle t2 = new MyTriangle(p1, p2, p3);
        System.out.println(t2);
        System.out.printf("Perimeter: %.2f%n", t2.getPerimeter());
        System.out.println("Type: " + t2.getType());
    }
}