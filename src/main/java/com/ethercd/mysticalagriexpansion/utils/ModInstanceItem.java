package com.ethercd.mysticalagriexpansion.utils;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Repeatable(ModInstanceItemContainer.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModInstanceItem {
    String name() default "Haha";
}

