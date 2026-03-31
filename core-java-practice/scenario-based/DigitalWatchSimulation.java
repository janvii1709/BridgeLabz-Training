public class DigitalWatchSimulation {
    public static void main(String[] args) {
        // Loop through hours 0 to 23
        for (int Hour = 0; Hour < 24; Hour++) {
            // Loop through minutes 0 to 59
            for (int Minute = 0; Minute < 60; Minute++) {
                // Print current time in HH:MM format
                System.out.printf("%02d:%02d\n", Hour, Minute);
                // Break if it's 13:00 (simulate power cut)
                if (Hour == 13 && Minute == 0) {
                    System.out.println("Power cut! Watch stopped at 13:00.");
                    break; // exit minute loop
                }
            }
            // If hour is 13 and minute 0, break outer loop too
            if (Hour == 13) {
                break;
            }
        }
    }
}
