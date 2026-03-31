
public class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public void generateMeal() {
        System.out.println("\nGenerating your personalized meal plan...");
        plan.displayPlan();
        System.out.println("Enjoy your healthy meals!\n");
    }

    public T getPlan() {
        return plan;
    }
}
