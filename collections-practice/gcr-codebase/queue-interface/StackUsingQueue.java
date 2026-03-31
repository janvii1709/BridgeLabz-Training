import java.util.*;
class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        q1.add(x);
    }
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int top = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        int top = pop();
        push(top);
        return top;
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
public class StackUsingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();
        while (true) {
            System.out.println("\nChoose operation: 1-Push 2-Pop 3-Top 4-Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    System.out.println(val + " pushed onto stack.");
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Popped: " + stack.pop());
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Top element: " + stack.top());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
