public class User {
    @MaxLength(10)
    private String username;
    public User(String username) {
        try {
            // Get the field using reflection
            var field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username length exceeds maximum allowed length of "
                        + maxLength.value()
                    );
                }
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }
}
