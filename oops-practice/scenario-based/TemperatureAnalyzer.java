public class TemperatureAnalyzer {
    /*
     * This method analyzes the temperature data of one full week.
     * It finds the hottest day, the coldest day,
     * and also calculates the average temperature for each day.
     */
    public static void AnalyzeTemperature(float[][] Temperatures) {
        // This will store which day has the highest temperature
        int HottestDay = 0;
        // This will store which day has the lowest temperature
        int ColdestDay = 0;
        // Assume the first temperature is both max and min at the start
        float MaxTemp = Temperatures[0][0];
        float MinTemp = Temperatures[0][0];
        // This array will store the average temperature of each day
        float[] DailyAverage = new float[7];
        // Loop through each day of the week
        for (int Day = 0; Day < 7; Day++) {
            // This variable will hold the total temperature of the current day
            float DailySum = 0;
            // Loop through all 24 hours of the current day
            for (int Hour = 0; Hour < 24; Hour++) {
                // Get the temperature for the current hour
                float CurrentTemp = Temperatures[Day][Hour];
                // Add this hour's temperature to the daily total
                DailySum += CurrentTemp;
                // If current temperature is higher than max, update hottest day
                if (CurrentTemp > MaxTemp) {
                    MaxTemp = CurrentTemp;
                    HottestDay = Day;
                }
                // If current temperature is lower than min, update coldest day
                if (CurrentTemp < MinTemp) {
                    MinTemp = CurrentTemp;
                    ColdestDay = Day;
                }
            }
            // Calculate and store the average temperature for the current day
            DailyAverage[Day] = DailySum / 24;
        }
        // Print the hottest day and its temperature
        System.out.println("Hottest Day: Day " + (HottestDay + 1)
                + " with temperature " + MaxTemp);
        // Print the coldest day and its temperature
        System.out.println("Coldest Day: Day " + (ColdestDay + 1)
                + " with temperature " + MinTemp);
        // Print the average temperature for each day
        System.out.println("\nAverage Temperature Per Day:");
        for (int i = 0; i < DailyAverage.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + DailyAverage[i]);
        }
    }

    /*
     * Main method to test the temperature analyzer program
     */
    public static void main(String[] args) {
        // Create a 2D array for 7 days and 24 hours
        float[][] WeeklyTemperatures = new float[7][24];
        // Fill the array with sample temperature values
        for (int Day = 0; Day < 7; Day++) {
            for (int Hour = 0; Hour < 24; Hour++) {
                WeeklyTemperatures[Day][Hour] = 20 + Day + (Hour * 0.1f);
            }
        }
        // Call the method to analyze the temperature data
        AnalyzeTemperature(WeeklyTemperatures);
    }
}
