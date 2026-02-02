import java.lang.reflect.*;
public class LoggingProxy {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // Log method call
                    System.out.println("[LOG] Method called: " + method.getName());
                    // Call actual method
                    return method.invoke(target, args);
                }
            }
        );
    }
}
