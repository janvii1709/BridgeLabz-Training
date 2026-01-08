import java.util.Scanner;

public class InventoryManagementSystem {

    // Item node for Singly Linked List
    static class Item {
        int itemId;         // Item ID
        String itemName;    // Item Name
        int quantity;       // Quantity available
        double price;       // Price per item
        Item next;          // Pointer to next item
    }

    // Head of the linked list
    static Item head = null;

    //  ADD AT BEGINNING 
    static void addAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item();
        newItem.itemId = id;
        newItem.itemName = name;
        newItem.quantity = qty;
        newItem.price = price;

        newItem.next = head;
        head = newItem;

        System.out.println("Item added successfully");
    }

    //  ADD AT END 
    static void addAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item();
        newItem.itemId = id;
        newItem.itemName = name;
        newItem.quantity = qty;
        newItem.price = price;
        newItem.next = null;

        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }

        System.out.println("Item added successfully");
    }

    //  ADD AT SPECIFIC POSITION
    static void addAtPosition(int pos, int id, String name, int qty, double price) {

        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Item newItem = new Item();
        newItem.itemId = id;
        newItem.itemName = name;
        newItem.quantity = qty;
        newItem.price = price;

        newItem.next = temp.next;
        temp.next = newItem;

        System.out.println("Item added successfully");
    }

    //  DELETE BY ITEM ID 
    static void deleteByItemId(int id) {

        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed successfully");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully");
        }
    }

    //  UPDATE QUANTITY 
    static void updateQuantity(int id, int qty) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = qty;
                System.out.println("Quantity updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // SEARCH BY ITEM ID 
    static void searchByItemId(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }

    // SEARCH BY ITEM NAME 
    static void searchByItemName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    //  TOTAL INVENTORY VALUE 
    static void totalInventoryValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    //  SORT BY NAME 
    static void sortByName(boolean ascending) {
        if (head == null) return;

        Item i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {

                int cmp = i.itemName.compareToIgnoreCase(j.itemName);
                if ((ascending && cmp > 0) || (!ascending && cmp < 0)) {
                    swapData(i, j);
                }
            }
        }

        System.out.println("Inventory sorted by name");
    }

    //  SORT BY PRICE 
    static void sortByPrice(boolean ascending) {
        if (head == null) return;

        Item i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {

                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }

        System.out.println("Inventory sorted by price");
    }

    //  SWAP ITEM DATA 
    static void swapData(Item a, Item b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    //  DISPLAY INVENTORY 
    static void display() {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        Item temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    //  PRINT ITEM 
    static void printItem(Item i) {
        System.out.println("Item ID: " + i.itemId);
        System.out.println("Item Name: " + i.itemName);
        System.out.println("Quantity: " + i.quantity);
        System.out.println("Price: " + i.price);
        System.out.println("---------------------------");
    }

    // MAIN METHOD 
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by Item ID");
            System.out.println("7. Search by Item Name");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name (Asc)");
            System.out.println("10. Sort by Name (Desc)");
            System.out.println("11. Sort by Price (Asc)");
            System.out.println("12. Sort by Price (Desc)");
            System.out.println("13. Display Inventory");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    if (choice == 3) {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Item ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Item Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        addAtPosition(pos, id, name, qty, price);
                        break;
                    }

                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    if (choice == 1)
                        addAtBeginning(id, name, qty, price);
                    else
                        addAtEnd(id, name, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    deleteByItemId(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    int iid = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int q = sc.nextInt();
                    updateQuantity(iid, q);
                    break;

                case 6:
                    System.out.print("Enter Item ID: ");
                    searchByItemId(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Item Name: ");
                    searchByItemName(sc.nextLine());
                    break;

                case 8:
                    totalInventoryValue();
                    break;

                case 9:
                    sortByName(true);
                    break;

                case 10:
                    sortByName(false);
                    break;

                case 11:
                    sortByPrice(true);
                    break;

                case 12:
                    sortByPrice(false);
                    break;

                case 13:
                    display();
                    break;

                case 14:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 14);
    }
}
