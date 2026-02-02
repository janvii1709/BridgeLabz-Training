public class BugTracker {

    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Incorrect calculation for negative values")
    public void processData() {
        System.out.println("Processing data...");
    }
}
