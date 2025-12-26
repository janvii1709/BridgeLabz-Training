import java.util.Scanner;
public class BusTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Stop = 1;
        double TotalDistance = 0;
        System.out.print("Enter distance per stop (in km): ");
        double DistancePerStop = sc.nextDouble();
        String Choice = "no";
        while (!Choice.equalsIgnoreCase("yes")) {
            System.out.println("Stop " + Stop + " reached.");
            TotalDistance = TotalDistance + DistancePerStop;
            System.out.println("Distance travelled so far: " + TotalDistance + " km");
            System.out.print("Do you want to get off? (yes/no): ");
            Choice = sc.next();

            Stop++;
        }

        System.out.println("Passenger got off.");
        System.out.println("Total distance travelled: " + TotalDistance + " km");
    }
}
