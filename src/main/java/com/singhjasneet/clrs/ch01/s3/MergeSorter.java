package com.singhjasneet.clrs.ch01.s3;

import com.singhjasneet.clrs.common.Sorter;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

    private final Comparator<E> comparator;

    public MergeSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public final void sort(E[] items) {
        sort(items, 0, items.length - 1);
    }

    protected void sort(E[] items, int p, int r) {
        if (p < r) {
            int mid = p + (r - p) / 2;
            sort(items, p, mid);
            sort(items, mid + 1, r);
            merge(items, p, mid, r);

        }
    }

    protected void merge(E[] items, int p, int mid, int r) {
        final E[] left = (E[]) Array.newInstance(items.getClass().getComponentType(), mid - p + 1);
        final E[] right = (E[]) Array.newInstance(items.getClass().getComponentType(), r - mid);


        System.arraycopy(items, p, left, 0, left.length);
        System.arraycopy(items, mid + 1, right, 0, right.length);

        int i = 0, j = 0;
        for (int k = p; k < r + 1; k++) {
            final E leftItem;
            final E rightItem;

            if (i < left.length) {
                leftItem = left[i];
            } else {
                leftItem = null;
            }

            if (j < right.length) {
                rightItem = right[j];
            } else {
                rightItem = null;
            }

            if (leftItem == null) {
                items[k] = rightItem;
                j += 1;
            } else if (rightItem == null) {
                items[k] = leftItem;
                i += 1;
            } else if (comparator.compare(left[i], right[j]) <= 0) {
                items[k] = leftItem;
                i += 1;
            } else {
                items[k] = rightItem;
                j += 1;
            }
        }
    }
}
