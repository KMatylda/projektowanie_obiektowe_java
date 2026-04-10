package nu;

public class Numbers {
    private int x;
    private int y;
    private int z;

    public Numbers(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int sum() {
        return x + y + z;
    }

    public double average() {
        return sum() / 3.0;
    }

    public int min() {
        int min = x;
        if (y < min) min = y;
        if (z < min) min = z;
        return min;
    }

    public int max() {
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

    // Math.abs -> wartość bezwzględna

    public double geometric() {
        return Math.pow(Math.abs(x) * Math.abs(y) * Math.abs(z), 1.0 / 3.0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }


}
