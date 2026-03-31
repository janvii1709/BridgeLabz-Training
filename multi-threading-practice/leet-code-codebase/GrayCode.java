import java.util.*;
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int total = (int) Math.pow(2, n); // 2^n
        List<Integer> grayCode = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            int gray = i ^ (i / 2);
            grayCode.add(gray);
        }
        System.out.println(grayCode);
    }
}
