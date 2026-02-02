import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// Make annotation available at runtime
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}
