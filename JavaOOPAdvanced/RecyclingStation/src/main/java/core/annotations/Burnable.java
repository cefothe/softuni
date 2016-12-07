package core.annotations;

import framework.waste.disposal.annotations.Disposable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by stefanangelov on 8/7/16.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Disposable
public @interface Burnable {
}
