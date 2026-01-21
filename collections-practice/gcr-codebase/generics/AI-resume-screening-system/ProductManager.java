
public class ProductManager extends JobRole {
    public ProductManager(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void requiredSkills() {
        System.out.println("Skills: Communication, Product Roadmap, Agile, Business Analysis");
    }
}
