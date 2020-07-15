package com.tzgod.user.framework;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Impl {
    Class value() ;
}