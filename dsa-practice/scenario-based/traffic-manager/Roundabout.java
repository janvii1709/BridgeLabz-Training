public class Roundabout {
    private Vehicle head = null;

    // Add vehicle to roundabout
    public void addVehicle(Vehicle v) {
        if (head == null) {
            head = v;
            v.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = v;
            v.next = head;
        }
        System.out.println("Vehicle entered roundabout: " + v.vehicleName);
    }

    // Remove vehicle by ID
    public void removeVehicle(int id) {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        Vehicle curr = head, prev = null;
        do {
            if (curr.vehicleId == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        Vehicle last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                }
                System.out.println("Vehicle exited roundabout: " + curr.vehicleName);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Vehicle not found in roundabout");
    }

    // Display all vehicles in roundabout
    public void display() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        Vehicle temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print("[" + temp.vehicleId + " - " + temp.vehicleName + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
