import java.util.*;
public class SelectionSortExam {
    public static void examScores(int[] scores ){
        int n = scores.length;
        for(int i = 0 ; i < n - 1 ; i++){
            int minIndex = i;
            for(int j = i + 1 ; j < n ; j++){
                if(scores[j] < scores[minIndex]){
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;

        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int n = sc.nextInt();
        int [] scores = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter the marks of student " + (i + 1) + " is : ");
            scores[i]= sc.nextInt();
        }
        examScores(scores);
        System.out.print("The sorted array of the marks in ascending order is :");
    System.out.print(Arrays.toString(scores));

    }
    
}
