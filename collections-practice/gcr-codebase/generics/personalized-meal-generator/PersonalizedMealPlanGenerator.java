
import java.util.Scanner;

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Personalized Meal Plan Generator!");
        System.out.println("Choose your meal plan type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");
        System.out.println("3. Keto");
        System.out.println("4. High-Protein");

        System.out.print("Enter choice (1-4): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Meal<? extends MealPlan> myMeal = null;

        switch (choice) {
            case 1:
                System.out.print("Enter your name: ");
                String vegName = sc.nextLine();
                System.out.println("Hello, " + vegName + "!");
                myMeal = MealPlanFactory.createMealPlan(new VegetarianMeal());
                break;
            case 2:
                System.out.print("Enter your name: ");
                String veganName = sc.nextLine();
                System.out.println("Hello, " + veganName + "!");
                myMeal = MealPlanFactory.createMealPlan(new VeganMeal());
                break;
            case 3:
                System.out.print("Enter your name: ");
                String ketoName = sc.nextLine();
                System.out.println("Hello, " + ketoName + "!");
                myMeal = MealPlanFactory.createMealPlan(new KetoMeal());
                break;
            case 4:
                System.out.print("Enter your name: ");
                String highProteinName = sc.nextLine();
                System.out.println("Hello, " + highProteinName + "!");
                myMeal = MealPlanFactory.createMealPlan(new HighProteinMeal());
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                System.exit(0);
        }

        // Generate meal plan
        myMeal.generateMeal();

    }
}
