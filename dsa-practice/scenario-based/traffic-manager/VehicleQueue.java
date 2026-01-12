public class VehicleQueue {
    private Vehicle[] queue;
    private int front = 0, rear = -1, size = 0;

    public VehicleQueue(int capacity) {
        queue = new Vehicle[capacity];
    }

    // Add vehicle to queue
    public void enqueue(Vehicle v) {
        if (size == queue.length) {
            System.out.println("Queue Overflow! Cannot add vehicle.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = v;
        size++;
        System.out.println("Vehicle added to waiting queue: " + v.vehicleName);
    }

    // Remove vehicle from queue
    public Vehicle dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        Vehicle v = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return v;
    }

    // Display waiting queue
    public void displayQueue() {
        if (size == 0) {
            System.out.println("Waiting queue is empty");
            return;
        }
        System.out.print("Waiting Queue: ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % queue.length;
            System.out.print("[" + queue[idx].vehicleId + " - " + queue[idx].vehicleName + "] ");
        }
        System.out.println();
    }
}
