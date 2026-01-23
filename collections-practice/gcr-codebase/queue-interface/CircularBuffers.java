import java.util.Scanner;
class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int count = 0;
    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }
    public void insert(int val) {
        int end = (start + count) % size;
        buffer[end] = val;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size;
        }
    }
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index]);
            if (i != count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
public class CircularBuffers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();
        CircularBuffer buffer = new CircularBuffer(size);
        while (true) {
            System.out.println("\nChoose operation: 1-Insert 2-Display 3-Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = sc.nextInt();
                    buffer.insert(val);
                    System.out.println(val + " inserted.");
                    break;
                case 2:
                    buffer.display();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
