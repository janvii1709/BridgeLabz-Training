import java.lang.reflect.Method;
import java.util.Scanner;

public class TestRepeatableAnnotation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter method name: ");
            String methodName = sc.nextLine();

            Class<BugTracker> cls = BugTracker.class;
            Method method = cls.getMethod(methodName);

            BugReport[] reports = method.getAnnotationsByType(BugReport.class);

            if (reports.length == 0) {
                System.out.println("No bug reports found.");
            } else {
                System.out.println("\n--- Bug Reports ---");
                for (int i = 0; i < reports.length; i++) {
                    System.out.println((i + 1) + ". " + reports[i].description());
                }
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
