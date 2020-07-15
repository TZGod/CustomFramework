package com.tzgod.user.framework;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MD5 {
    String password()default "";
}