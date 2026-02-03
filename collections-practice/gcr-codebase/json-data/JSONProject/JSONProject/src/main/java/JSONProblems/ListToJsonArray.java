package JSONProblems;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
class Cars {
    private String brand;
    private String model;
    private int year;
    public Cars(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
public class ListToJsonArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 2022));
        cars.add(new Car("Honda", "Civic", 2021));
        cars.add(new Car("Ford", "Mustang", 2023));
        JSONArray jsonArray = new JSONArray();
        for (Car car : cars) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("brand", car.getBrand());
            jsonObject.put("model", car.getModel());
            jsonObject.put("year", car.getYear());
            jsonArray.put(jsonObject);
        }
        System.out.println("JSON Array Output:");
        System.out.println(jsonArray.toString());
    }
}

