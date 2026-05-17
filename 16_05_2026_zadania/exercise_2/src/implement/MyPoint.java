package implement;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(MyPoint other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
