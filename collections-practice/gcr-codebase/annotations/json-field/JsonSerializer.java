import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        boolean first = true;

        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);

                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                Object value = field.get(obj);

                if (!first) {
                    json.append(", ");
                }

                json.append("\"").append(key).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
}
