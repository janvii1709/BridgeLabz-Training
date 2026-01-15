import java.util.*;
public class InsertionSortEmployeeIDs {
    public static void employeeId(int[] id){
        int n = id.length;
        for(int i = 1 ; i < n ; i++){
            int key = id[i];
            int j = i - 1;
            while( j >= 0 && id[j] > key){
                id[j + 1] = id[j];
                j--;
            }
            id[j + 1 ] = key ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees : ");
        int n =sc.nextInt();
        int [] id  = new int[n];
        for(int i = 0 ; i < n ;i++){
            System.out.print("The employee id of employee " + (i + 1) + " is : ");
            id[i] = sc.nextInt();
        }
        employeeId(id);
        System.out.print("The Sorted Employee ID's in ascending order is : ");
        System.out.print(Arrays.toString(id) );
        }

    }
    

