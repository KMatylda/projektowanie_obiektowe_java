package grades;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter the grade for student " + (i + 1) + ": ");
                int grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    grades[i] = grade;
                    break;
                } else {
                    System.out.println("Grade must be between 0 and 100.");
                }
            }
        }

        GradesStatistics stats = new GradesStatistics(grades);

        System.out.println("The grades are: " + Arrays.toString(grades));
        System.out.printf("The average is: %.2f%n", stats.calculateAverage());
        System.out.printf("The median is: %.2f%n", stats.calculateMedian());
        System.out.println("The minimum is: " + stats.getMinimum());
        System.out.println("The maximum is: " + stats.getMaximum());
        System.out.printf("The standard deviation is: %.2f%n", stats.calculateStdDev());

        scanner.close();
    }
}
