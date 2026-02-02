import java.util.Scanner;
public class TestLoggingProxy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Original object
        Greeting greeting = new GreetingImpl();
        // Create proxy
        Greeting proxyGreeting = LoggingProxy.createProxy(greeting, Greeting.class);
        // Take user input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        // Call method via proxy
        proxyGreeting.sayHello(name);
    }
}
