class TrackInventoryOfItems {
    String ItemCode, ItemName;
    double Price;
    void Display() {
        System.out.println("itemCode : " + ItemCode);
        System.out.println("itemPrice : " + Price);
        System.out.println("itemName : " + ItemName);
        System.out.println("----------------------------");
    }
    public static void main(String[] args) {
        TrackInventoryOfItems I1 = new TrackInventoryOfItems();
        I1.ItemCode="01AA"; I1.ItemName="Water bottle"; I1.Price=500.0;

        TrackInventoryOfItems I2 = new TrackInventoryOfItems();
        I2.ItemCode="01BB"; I2.ItemName="Rice"; I2.Price=700.0;

        TrackInventoryOfItems I3 = new TrackInventoryOfItems();
        I3.ItemCode="02AA"; I3.ItemName="blackboard"; I3.Price=400.0;

        I1.Display(); I2.Display(); I3.Display();
    }
}