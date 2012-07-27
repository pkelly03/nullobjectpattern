package com.kata;

/**
 * author : pkelly
 */
public final class HasAValue<T> extends Option<T> {

    private final T value;

    public HasAValue(T value) {
        this.value = value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != HasAValue.class)
            return false;
        HasAValue<?> that = (HasAValue<?>) other;
        Object thatValue = that.get();
        return value.equals(thatValue);
    }

    @Override
    public int hashCode() {
        return 37 * value.hashCode();
    }

}
