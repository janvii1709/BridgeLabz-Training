import java.util.Scanner;
import java.util.Stack;

/* Queue implementation using two stacks */
class QueueUsingStacks {

    private Stack<Integer> inStack;   // Used for enqueue
    private Stack<Integer> outStack;  // Used for dequeue

    // Constructor
    public QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        inStack.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return;
        }

        // Transfer elements only if outStack is empty
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        int removed = outStack.pop();
        System.out.println("Dequeued: " + removed);
    }

    // Peek front element
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        System.out.println("Front element: " + outStack.peek());
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");

        // Display outStack first (top to bottom)
        for (int i = outStack.size() - 1; i >= 0; i--) {
            System.out.print(outStack.get(i) + " ");
        }

        // Display inStack (bottom to top)
        for (int i = 0; i < inStack.size(); i++) {
            System.out.print(inStack.get(i) + " ");
        }

        System.out.println();
    }
}

/* Main class */
public class QueueUsingStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();

        while (true) {
            System.out.println("\n--- Queue Using Stacks Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int data = sc.nextInt();
                    queue.enqueue(data);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
