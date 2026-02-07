import java.util.List;
import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();
        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split(":");
            String vesselId = data[0];
            String vesselName = data[1];
            double averageSpeed = Double.parseDouble(data[2]);
            String vesselType = data[3];
            Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            util.addVesselPerformance(vessel);
        }
        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();
        Vessel foundVessel = util.getVesselById(searchId);
        if (foundVessel != null) {
            System.out.println(
                foundVessel.getVesselId() + " | " +
                foundVessel.getVesselName() + " | " +
                foundVessel.getVesselType() + " | " +
                foundVessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }
        System.out.println("High performance vessels are");
        List<Vessel> highPerf = util.getHighPerformanceVessels();
        for (Vessel v : highPerf) {
            System.out.println(
                v.getVesselId() + " | " +
                v.getVesselName() + " | " +
                v.getVesselType() + " | " +
                v.getAverageSpeed() + " knots"
            );
        }
    }
}
