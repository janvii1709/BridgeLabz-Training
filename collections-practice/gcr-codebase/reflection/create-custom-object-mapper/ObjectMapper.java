import java.lang.reflect.Field;
import java.util.Map;
public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        T obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    // Convert value type if needed (simple int conversion)
                    if (field.getType() == int.class && fieldValue instanceof String) {
                        fieldValue = Integer.parseInt((String) fieldValue);
                    }
                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
