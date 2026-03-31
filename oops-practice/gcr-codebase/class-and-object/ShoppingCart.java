
class ShoppingCart {
    String ItemName;
    double Price;
    int Quantity;

    void AddItem(int Qty) {
        Quantity += Qty;
        System.out.println("Added " + Qty + " of " + ItemName + " to the cart.");
    }

    void RemoveItem(int Qty) {
        Quantity = Math.max(0, Quantity - Qty);
        System.out.println("Removed " + Qty + " of " + ItemName + " from the cart.");
    }

    void DisplayTotal() {
        System.out.println("Total cost: $" + (Quantity * Price));
    }

    public static void main(String[] args) {
        ShoppingCart c = new ShoppingCart();
        c.ItemName = "Laptop";
        c.Price = 999.99;
        c.Quantity = 1;

        System.out.println("Item: " + c.ItemName + ", Price: $" + c.Price + ", Quantity: " + c.Quantity);
        c.AddItem(2);
        c.RemoveItem(1);
        c.DisplayTotal();
    }
}