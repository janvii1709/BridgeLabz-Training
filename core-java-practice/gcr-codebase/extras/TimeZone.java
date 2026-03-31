// Import ZonedDateTime class to work with date, time and time zone
import java.time.ZoneId;
import java.time.ZonedDateTime;
public class TimeZone {
    public static void main(String[] args) {
        // Get current time in GMT (Greenwich Mean Time)
        ZonedDateTime gmtTime = ZonedDateTime.now( ZoneId.of ("GMT"));
        // Get current time in IST (Indian Standard Time)
        ZonedDateTime istTime = ZonedDateTime.now( ZoneId.of ("Asia/Kolkata"));
        // Get current time in PST (Pacific Standard Time)
        ZonedDateTime pstTime = ZonedDateTime.now( ZoneId.of ("America/Los_Angeles"));
        // Display current time in GMT
        System.out.println("Current Time in GMT : " + gmtTime);
        // Display current time in IST
        System.out.println("Current Time in IST : " + istTime);
        // Display current time in PST
        System.out.println("Current Time in PST : " + pstTime);
    }
}
