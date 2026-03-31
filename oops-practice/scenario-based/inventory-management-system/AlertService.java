public interface AlertService {
    void checkStock(Product product, int lowStockLimit) throws OutOfStockException;
}
