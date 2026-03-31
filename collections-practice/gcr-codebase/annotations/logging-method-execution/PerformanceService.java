public class PerformanceService {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1_000_000; i++) {
            // simulate fast work
        }
        System.out.println("Fast method executed");
    }
    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 10_000_000; i++) {
            // simulate slow work
        }
        System.out.println("Slow method executed");
    }
    public void normalMethod() {
        System.out.println("Normal method executed (no timing)");
    }
}
