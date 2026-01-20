import java.util.*;

public class BrowserBuddy {

    static Scanner sc = new Scanner(System.in);
    static Stack<BrowserTab> closedTabs = new Stack<>();
    static BrowserTab currentTab = new BrowserTab();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nBrowserBuddy Menu");
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Close Current Tab");
            System.out.println("5. Reopen Last Closed Tab");
            System.out.println("6. Show Current Page");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    currentTab.visitPage(url);
                    break;

                case 2:
                    currentTab.goBack();
                    break;

                case 3:
                    currentTab.goForward();
                    break;

                case 4:
                    closedTabs.push(currentTab);
                    currentTab = new BrowserTab();
                    System.out.println("Tab closed successfully!");
                    break;

                case 5:
                    if (!closedTabs.isEmpty()) {
                        currentTab = closedTabs.pop();
                        System.out.println("Last closed tab reopened!");
                    } else {
                        System.out.println("No closed tabs available!");
                    }
                    break;

                case 6:
                    System.out.println("Current Page: " + currentTab.currentPage());
                    break;

                case 7:
                    System.out.println("Exiting BrowserBuddy");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
