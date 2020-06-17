package com.singhjasneet.clrs.common;

import java.util.Arrays;

public final class ArrayUtils {
    private ArrayUtils() {
        throw new UnsupportedOperationException();
    }

    public static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <E> E[] concat(E[] left, E[] right) {
        final E[] result = Arrays.copyOf(left, left.length + right.length);
        System.arraycopy(right, 0, result, left.length, right.length);
        return result;
    }
}
