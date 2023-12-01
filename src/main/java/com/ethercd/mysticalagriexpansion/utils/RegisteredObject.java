package com.ethercd.mysticalagriexpansion.utils;

public class RegisteredObject<T> {
    private T object;
    private String name;

    public RegisteredObject(T object, String name) {
        this.object = object;
        this.name = name;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
