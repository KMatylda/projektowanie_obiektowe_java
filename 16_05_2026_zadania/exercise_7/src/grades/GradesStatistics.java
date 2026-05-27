package grades;

import java.util.Arrays;

public class GradesStatistics {

    private int[] grades;

    public GradesStatistics(int[] grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.length;
    }

    public int getMinimum() {
        int min = grades[0];
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    public int getMaximum() {
        int max = grades[0];
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    public double calculateMedian() {
        int[] sorted = grades.clone();
        Arrays.sort(sorted);
        int n = sorted.length;
        int mid = n / 2;
        if (n % 2 == 1) {
            return sorted[mid];
        } else {
            return (sorted[mid - 1] + sorted[mid]) / 2.0;
        }
    }

    public double calculateStdDev() {
        int n = grades.length;
        double mean = calculateAverage();
        double sumOfSquares = 0;
        for (int g : grades) sumOfSquares += (double) g * g;
        return Math.sqrt(sumOfSquares / n - mean * mean);
    }
}