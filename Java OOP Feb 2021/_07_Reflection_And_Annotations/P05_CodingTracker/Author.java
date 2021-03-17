package _07_Reflection_And_Annotations.P05_CodingTracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    public String name();
}
