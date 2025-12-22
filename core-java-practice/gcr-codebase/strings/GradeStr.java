import  java.util.*;
public class GradeStr {
    // a) Generate random 2-digit PCM scores for students
    static int[][] Generate_PCM_Scores(int Students) {
        int[][] PCM= new int[Students][3]; // P, C, M

        for (int i = 0; i < Students; i++) {
            for (int j = 0; j < 3; j++) {
                PCM[i][j] = (int) (Math.random() * 51) + 50; // 50–100
            }
        }
        return PCM;
    }

    // b) Calculate total, average and percentage
    static double[][] Calculate_Res(int[][] PCM) {
        double[][] Res = new double[PCM.length][3]; // total, avg, %

        for (int i = 0; i < PCM.length; i++) {
            int TOTAL = PCM[i][0] + PCM[i][1] + PCM[i][2];
            double AVG = TOTAL / 3.0;
            double Percent = (TOTAL / 300.0) * 100;

            Res[i][0] = Math.round(TOTAL * 100.0) / 100.0;
            Res[i][1] = Math.round(AVG * 100.0) / 100.0;
            Res[i][2] = Math.round(Percent * 100.0) / 100.0;
        }
        return Res;
    }

    // c) Calculate grade based on percentage
    static String[][] Calculate_Grades(double[][] Res) {
        String[][] Grades = new String[Res.length][1];

        for (int i = 0; i < Res.length; i++) {
            double P = Res[i][2];

            if (P >= 80) Grades[i][0] = "A";
            else if (P >= 70) Grades[i][0] = "B";
            else if (P >= 60) Grades[i][0] = "C";
            else if (P >= 50) Grades[i][0] = "D";
            else if (P >= 40) Grades[i][0] = "E";
            else Grades[i][0] = "R";
        }
        return Grades;
    }

    // d) Display scorecard in tabular format
    static void Display_Score_Card(int[][] PCM, double[][] Res, String[][] Grades) {
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < PCM.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                PCM[i][0] + "\t" +
                PCM[i][1] + "\t" +
                PCM[i][2] + "\t" +
                Res[i][0] + "\t" +
                Res[i][1] + "\t" +
                Res[i][2] + "\t" +
                Grades[i][0]
            );
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int Num = sc.nextInt();

        int[][] PCM_Scores = Generate_PCM_Scores(Num);
        double[][] Res = Calculate_Res(PCM_Scores);
        String[][] Grades = Calculate_Grades(Res);
        Display_Score_Card(PCM_Scores , Res , Grades);
        sc.close();
    }
}