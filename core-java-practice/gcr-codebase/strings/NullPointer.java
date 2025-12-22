public class NullPointer {
    public static void main(String[] args) {
        // GENERATE NullPointerException
        System.out.println("Generating NullPointerException:");
        try {
            String Text = null ;
            // Accessing the methods on null reference (this will cause exception)
            System.out.println(Text.length());
        } catch (Exception e) {
            System.out.println("Exception generated and program stopped abruptly");
        }

        // HANDLE NullPointerException using try-catch
        System.out.println("Handling NullPointerException using try-catch:");
        try {
            String Text = null;
            // Accessing method inside try block
            System.out.println(Text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
}

