import java.util.*;

public class ParcelTracker {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Parcel parcel = new Parcel();
        parcel.initializeStages();

        while (true) {
            System.out.println("\n Parcel Tracker Menu");
            System.out.println("1. Track Parcel");
            System.out.println("2. Add Custom Checkpoint");
            System.out.println("3. Mark Parcel as Lost");
            System.out.println("4. Recreate Parcel");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    parcel.trackParcel();
                    break;

                case 2:
                    System.out.print("Enter stage after which to add checkpoint: ");
                    String after = sc.nextLine();

                    System.out.print("Enter new checkpoint name: ");
                    String stage = sc.nextLine();

                    parcel.addCheckpoint(after, stage);
                    break;

                case 3:
                    parcel.markLost();
                    break;

                case 4:
                    parcel.initializeStages();
                    System.out.println(" Parcel recreated successfully!");
                    break;

                case 5:
                    System.out.println(" Exiting Parcel Tracker");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}
