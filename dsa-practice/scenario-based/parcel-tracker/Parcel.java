class Parcel {

    StageNode head;

    // Initialize default stages
    void initializeStages() {
        head = new StageNode("Packed");
        head.next = new StageNode("Shipped");
        head.next.next = new StageNode("In Transit");
        head.next.next.next = new StageNode("Delivered");
    }

    // Track parcel forward
    void trackParcel() {
        if (head == null) {
            System.out.println(" Parcel is lost or missing!");
            return;
        }

        StageNode temp = head;
        System.out.println(" Parcel Tracking:");
        while (temp != null) {
            System.out.print(temp.stage);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add custom checkpoint
    void addCheckpoint(String afterStage, String newStage) {

        if (head == null) {
            System.out.println(" Parcel not found!");
            return;
        }

        StageNode temp = head;
        while (temp != null) {
            if (temp.stage.equalsIgnoreCase(afterStage)) {
                StageNode node = new StageNode(newStage);
                node.next = temp.next;
                temp.next = node;
                System.out.println(" Checkpoint added!");
                return;
            }
            temp = temp.next;
        }
        System.out.println(" Stage not found!");
    }

    // Mark parcel as lost
    void markLost() {
        head = null;
        System.out.println(" Parcel marked as lost!");
    }
}
