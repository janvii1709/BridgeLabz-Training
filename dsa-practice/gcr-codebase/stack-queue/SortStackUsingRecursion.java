import java.util.Scanner;
import java.util.Stack;

// Sort Stack using Recursion 
class SortStack {

    // Function to sort the stack
    public void sortStack(Stack<Integer> stack) {
        // Base case: stack is empty
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert the element at correct position
        insertSorted(stack, top);
    }

    // Helper function to insert element in sorted order
    private void insertSorted(Stack<Integer> stack, int element) {

        // Base case: correct position found
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursive call
        insertSorted(stack, element);

        // Put back the removed element
        stack.push(top);
    }
}

// Main class 
public class SortStackUsingRecursion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        SortStack sorter = new SortStack();

        while (true) {
            System.out.println("\n--- Stack Sorting Menu ---");
            System.out.println("1. Push Element");
            System.out.println("2. Sort Stack");
            System.out.println("3. Display Stack");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    System.out.println("Pushed: " + value);
                    break;

                case 2:
                    sorter.sortStack(stack);
                    System.out.println("Stack sorted successfully!");
                    break;

                case 3:
                    System.out.println("Stack elements (Bottom → Top): " + stack);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
