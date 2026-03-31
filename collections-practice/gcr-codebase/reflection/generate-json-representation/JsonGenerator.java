import java.lang.reflect.Field;
public class JsonGenerator {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                json.append("\"").append(fieldName).append("\": ");
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                if (i != fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        json.append("}");
        return json.toString();
    }
}
