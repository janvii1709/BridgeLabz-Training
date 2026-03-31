
public class MealPlanFactory {

    // Generic method to validate and create a meal plan
    public static <T extends MealPlan> Meal<T> createMealPlan(T plan) {
        if (plan == null) {
            throw new IllegalArgumentException("Invalid meal plan selected!");
        }
        return new Meal<>(plan);
    }
}
