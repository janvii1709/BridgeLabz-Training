package Problems;
public class PerformanceService {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // sleeps for 3 seconds
        return "Completed";
    }
}
