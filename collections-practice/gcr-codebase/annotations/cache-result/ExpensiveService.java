public class ExpensiveService {

    @CacheResult
    public int square(int number) {
        System.out.println("Computing square for " + number + " (expensive operation)...");
        try {
            Thread.sleep(2000); // simulate heavy computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}
