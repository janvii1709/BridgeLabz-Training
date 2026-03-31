package ProblemTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import Problems.PerformanceService;
import java.util.concurrent.TimeUnit;
public class PerformanceServiceTest {
    private PerformanceService service = new PerformanceService();
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() throws InterruptedException {
        service.longRunningTask();
    }
}
