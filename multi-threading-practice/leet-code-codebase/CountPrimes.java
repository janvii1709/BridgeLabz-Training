import java.util.Scanner;
public class CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        if (n <= 2) {
            System.out.println(0);
            return;
        }
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
        
            }
        }
        System.out.println(count);
    }
}
