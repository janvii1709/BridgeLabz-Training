public class AccessManager {
    public static void checkAccessAndExecute(Object obj, String userRole) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();
            if (!allowedRole.equalsIgnoreCase(userRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }
        System.out.println("Access Granted!");
        ((AdminService) obj).performAdminTask();
    }
}
