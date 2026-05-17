package implement;

public class Main {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle();
        MyCircle c2 = new MyCircle(3, 4, 5);
        MyCircle c3 = new MyCircle(new MyPoint(1, 1), 10);

        System.out.println(c1);              // MyCircle[radius=1,center=(0,0)]
        System.out.println(c2);              // MyCircle[radius=5,center=(3,4)]
        System.out.println(c3);              // MyCircle[radius=10,center=(1,1)]

        System.out.printf("Area: %.2f%n",          c2.getArea());
        System.out.printf("Circumference: %.2f%n", c2.getCircumference());
        System.out.printf("Distance c1->c2: %.2f%n", c1.distance(c2)); // 5.0
    }
}