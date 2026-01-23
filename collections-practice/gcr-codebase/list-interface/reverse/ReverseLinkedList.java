import java.util.*;
public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList <Integer> list = new LinkedList <>();
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        LinkedList<Integer> reversedList = new LinkedList<>();
        for(int i=list.size()-1;i>=0;i--){
            reversedList.add(list.get(i));
        }
        System.out.println("Reversed List is : "+reversedList);
    }
    
}
