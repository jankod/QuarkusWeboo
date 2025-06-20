package hr.ja.ui.js;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a JavaScript function.
 * This annotation can be used to specify the JavaScript code that
 * will be generated for the class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JavaScript {
    String value();
}
