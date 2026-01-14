import java.util.Scanner;

/* Node class represents one entry in HashMap */
class HashNode {
    int key;
    String value;
    HashNode next;

    public HashNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

/* Custom HashMap implementation */
class CustomHashMap {

    private HashNode[] buckets;
    private int size;

    // Constructor
    public CustomHashMap(int size) {
        this.size = size;
        buckets = new HashNode[size];
    }

    // Hash Function
    private int getBucketIndex(int key) {
        return key % size;
    }

    // Insert key-value pair
    public void put(int key, String value) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];

        // Check if key already exists
        while (head != null) {
            if (head.key == key) {
                head.value = value; // Update value
                System.out.println("Key updated successfully!");
                return;
            }
            head = head.next;
        }

        // Insert new node at beginning
        HashNode newNode = new HashNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;

        System.out.println("Key inserted successfully!");
    }

    // Retrieve value by key
    public String get(int key) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];
        HashNode prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                System.out.println("Key removed successfully!");
                return;
            }
            prev = head;
            head = head.next;
        }

        System.out.println("Key not found!");
    }

    // Display HashMap
    public void display() {
        System.out.println("\nHash Map State:");
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode head = buckets[i];
            while (head != null) {
                System.out.print("[" + head.key + " = " + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
}

/* Main class */
public class Custom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter HashMap size: ");
        int size = sc.nextInt();

        CustomHashMap map = new CustomHashMap(size);

        while (true) {
            System.out.println("\n--- Custom HashMap Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Retrieve");
            System.out.println("3. Remove");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (int): ");
                    int key = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter value (String): ");
                    String value = sc.nextLine();
                    map.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key to retrieve: ");
                    int searchKey = sc.nextInt();
                    String result = map.get(searchKey);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = sc.nextInt();
                    map.remove(removeKey);
                    break;

                case 4:
                    map.display();
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
