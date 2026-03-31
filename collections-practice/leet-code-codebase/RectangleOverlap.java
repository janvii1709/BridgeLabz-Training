import java.util.Scanner;
public class RectangleOverlap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rec1 = new int[4];
        int[] rec2 = new int[4];
        System.out.println("Enter rec1 (x1 y1 x2 y2):");
        for (int i = 0; i < 4; i++) {
            rec1[i] = sc.nextInt();
        }
        System.out.println("Enter rec2 (x1 y1 x2 y2):");
        for (int i = 0; i < 4; i++) {
            rec2[i] = sc.nextInt();
        }
        boolean overlap = !(rec1[2] <= rec2[0] ||rec1[0] >= rec2[2] ||rec1[3] <= rec2[1] ||rec1[1] >= rec2[3]);
        System.out.println(overlap);
    }
}
