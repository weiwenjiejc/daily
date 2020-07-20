package org.wwj.demo.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    /**
     * 名字
     * @return
     */
    String value() default "wwj";
}
