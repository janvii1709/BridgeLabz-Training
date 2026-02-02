import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
public class CacheExecutor {
    private static final Map<String, Object> cache = new HashMap<>();
    public static Object execute(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, int.class);
        String cacheKey = methodName + "_" + args[0];
        if (method.isAnnotationPresent(CacheResult.class)) {
            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result...");
                return cache.get(cacheKey);
            }
            Object result = method.invoke(obj, args);
            cache.put(cacheKey, result);
            return result;
        }
        return method.invoke(obj, args);
    }
}
