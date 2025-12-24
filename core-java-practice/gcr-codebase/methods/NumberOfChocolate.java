import java.util.*;
public class NumberOfChocolate {
    public static int[] FindNumberOfChocolates(int numberOfchocolates , int numberOfChildren){
        int ChocolatesEachGet = numberOfchocolates / numberOfChildren;
        int RemainingChocolates = numberOfchocolates % numberOfChildren;
        return new int[] {ChocolatesEachGet , RemainingChocolates};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates : ");
        int numberOfchocolates = sc.nextInt();
        System.out.print("Enter the number of childrens : ");
        int numberOfChildren = sc.nextInt();


        int [] arr = FindNumberOfChocolates(numberOfchocolates, numberOfChildren);
        System.out.println("The number of chocolates each get are : " + arr[0]);
        System.out.println("The remainig chocolates are : " + arr[1]);
    }
    
}
