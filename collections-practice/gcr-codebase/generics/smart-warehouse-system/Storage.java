import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
        System.out.println(item.getName() + " added to storage.");
    }

    // Remove item by name
    public boolean removeItem(String name) {
        return items.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    // Get all items
    public List<T> getItems() {
        return items;
    }

    // Display items using wildcard
    public static void displayAllItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            item.displayDetails();
        }
    }
}
