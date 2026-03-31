import java.util.*;
public class ReverseArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i = 0;i < n ; i++){
            list.add(sc.nextInt());
        }
        int start = 0;
        int end = list.size() - 1;
        while(start < end){
            int temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
        System.out.println("Reversed ArrayList is : " + list);
    }
    
}
