package JSONProblems;
import org.json.JSONObject;
class Car {
    private String brand;
    private String model;
    private int year;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
public class CarToJson {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2022);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", car.getBrand());
        jsonObject.put("model", car.getModel());
        jsonObject.put("year", car.getYear());
        System.out.println("JSON Output:");
        System.out.println(jsonObject.toString());
    }
}
