public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            // Load class dynamically
            Class<?> cls = Class.forName("Book");
            // Check if @Author is present
            if (cls.isAnnotationPresent(Author.class)) {
                // Get annotation
                Author authorAnnotation = cls.getAnnotation(Author.class);
                // Display value
                System.out.println("Author Name: " + authorAnnotation.name());
            } else {
                System.out.println("@Author annotation is not present on this class.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
