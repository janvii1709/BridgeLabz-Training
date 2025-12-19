import java.util.*;
class HarrysAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        int birthyear = sc.nextInt();// taking birth year as input
        int age = 2024 - birthyear;// calculating age in 2024
        System.out.println(" Harry's age in 2024 is " + age);
    }

}