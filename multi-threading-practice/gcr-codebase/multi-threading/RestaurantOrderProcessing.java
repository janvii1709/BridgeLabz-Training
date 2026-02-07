import java.util.*;

class Chef extends Thread {
    private String dish;
    private long time;

    Chef(String name, String dish, long time) {
        super(name);
        this.dish = dish;
        this.time = time;
    }

    public void run() {
        System.out.println(getName() + " started preparing " + dish);
        try {
            int[] steps = {25, 50, 75, 100};
            long part = time / 4;
            for (int p : steps) {
                Thread.sleep(part);
                System.out.println(getName() + " preparing " + dish + ": " + p + "% complete");
            }
            System.out.println(getName() + " completed " + dish);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}

public class RestaurantOrderProcessing {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chefs: ");
        int n = sc.nextInt();
        sc.nextLine();

        Chef[] chefs = new Chef[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter dish name for Chef-" + (i + 1) + ": ");
            String dish = sc.nextLine();

            System.out.print("Enter preparation time in seconds: ");
            long time = sc.nextLong() * 1000;
            sc.nextLine();

            chefs[i] = new Chef("Chef-" + (i + 1), dish, time);
        }

        for (Chef c : chefs)
            c.start();

        for (Chef c : chefs)
            c.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}
