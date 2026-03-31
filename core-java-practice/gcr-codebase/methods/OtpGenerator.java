public class OtpGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static int GenerateOTP() {
        // Generates a random number between 100000 and 999999
        return (int)(Math.random() * 900000) + 100000;
    }

    // Method to check whether all OTPs are unique
    public static boolean CheckUnique(int[] Otps) {
        // Compare each OTP with every other OTP
        for (int i = 0; i < Otps.length; i++) {
            for (int j = i + 1; j < Otps.length; j++) {
                if (Otps[i] == Otps[j]) {
                    return false; // duplicate found
                }
            }
        }
        return true; // all OTPs are unique
    }

    public static void main(String[] args) {

        int[] OtpArray = new int[10]; // array to store 10 OTPs
        // Generate OTPs 10 times
        for (int i = 0; i < OtpArray.length; i++) {
            OtpArray[i] = GenerateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (int otp : OtpArray) {
            System.out.println(otp);
        }

        // Check uniqueness
        boolean IsUnique = CheckUnique(OtpArray);

        System.out.println("\nAre all OTPs unique ? " + IsUnique);
    }
}