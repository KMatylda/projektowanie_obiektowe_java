package points;

public class Main {
    public static void main(String[] args) {
        // Test constructor 1: coordinates
        MyRectangle r1 = new MyRectangle(0, 0, 4, 3);
        System.out.println(r1);
        System.out.println("Width:     " + r1.getWidth());
        System.out.println("Height:    " + r1.getHeight());
        System.out.println("Area:      " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println();

        // Test constructor 2: MyPoint objects
        MyPoint p1 = new MyPoint(1, 1);
        MyPoint p2 = new MyPoint(5, 4);
        MyRectangle r2 = new MyRectangle(p1, p2);
        System.out.println(r2);
        System.out.println("Width:     " + r2.getWidth());
        System.out.println("Height:    " + r2.getHeight());
    }
}