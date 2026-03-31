import java.util.Scanner;
public class StudentsGrade {
    // Method to generate random 2-digit PCM scores
    public static int[][] GeneratePCMScores(int Students) {
        int[][] Scores = new int[Students][3]; // Physics, Chemistry, Maths

        for (int i = 0; i < Students; i++) {
            Scores[i][0] = (int)(Math.random() * 90) + 10;
            Scores[i][1] = (int)(Math.random() * 90) + 10;
            Scores[i][2] = (int)(Math.random() * 90) + 10;
        }
        return Scores;
    }

    // Method to calculate total, average, percentage
    public static double[][] CalculateResults(int[][] Scores) {
        double[][] Result = new double[Scores.length][3]; // total, average, percentage

        for (int i = 0; i < Scores.length; i++) {
            int Total = Scores[i][0] + Scores[i][1] + Scores[i][2];
            double Avg = Total / 3.0;
            double Percent = (Total / 300.0) * 100;

            Result[i][0] = Math.round(Total * 100.0) / 100.0;
            Result[i][1] = Math.round(Avg * 100.0) / 100.0;
            Result[i][2] = Math.round(Percent * 100.0) / 100.0;
        }
        return Result;
    }

    // Method to find grade
    public static String FindGrade(double Percentage) {
        if (Percentage >= 80) return "A";
        else if (Percentage >= 70) return "B";
        else if (Percentage >= 60) return "C";
        else if (Percentage >= 50) return "D";
        else if (Percentage >= 40) return "E";
        else return "R";
    }

    // Method to display scorecard
    public static void DisplayScoreCard(int[][] Scores, double[][] Result) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < Scores.length; i++) {
            System.out.println(
                Scores[i][0] + "\t" +
                Scores[i][1] + "\t" +
                Scores[i][2] + "\t" +
                Result[i][0] + "\t" +
                Result[i][1] + "\t" +
                Result[i][2] + "\t" +
                FindGrade(Result[i][2])
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students : ");

        int Students = sc.nextInt();

        int[][] Scores = GeneratePCMScores(Students);
        double[][] Result = CalculateResults(Scores);

        DisplayScoreCard(Scores, Result);
    }
}