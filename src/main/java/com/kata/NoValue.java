package com.kata;

/**
 * author : pkelly
 */
public class NoValue<T> extends Option<T> {

    public static class NoneHasNoValue extends RuntimeException{}

    public NoValue(){}

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public T get() {
        throw new NoneHasNoValue();
    }

    @Override
    public String toString() {
        return "NoValue";
    }

    @Override
    public boolean equals(Object other) {
        return (other == null || other.getClass() != NoValue.class) ? false : true;
    }

    @Override
    public int hashCode() {
        return -1;
    }

}
