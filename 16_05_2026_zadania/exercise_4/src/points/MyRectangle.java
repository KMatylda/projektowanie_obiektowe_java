package points;

public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    // Constructor with 4 coordinates
    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.topLeft     = new MyPoint(x1, y1);
        this.bottomRight = new MyPoint(x2, y2);
    }

    // Constructor with 2 MyPoint objects
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft     = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    public double getHeight() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}
