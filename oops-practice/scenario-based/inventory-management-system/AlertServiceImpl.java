public class AlertServiceImpl implements AlertService {

    @Override
    public void checkStock(Product product, int lowStockLimit) throws OutOfStockException {
        if (product.getStock() <= 0) {
            throw new OutOfStockException("Product is out of stock: " + product.getName());
        }
        if (product.getStock() < lowStockLimit) {
            System.out.println(" Low Stock Alert for " + product.getName() + " | Stock: " + product.getStock());
        }
    }
}
