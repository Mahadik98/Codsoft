import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input marks obtained in each subject
        int totalMarks = 0;
        int totalSubjects = 5;

        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("marks obtained in Subject " + i + " : ");
            int marks = input.nextInt();
            totalMarks += marks;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / (totalSubjects * 100) * 100;

        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        input.close();
    }
}
