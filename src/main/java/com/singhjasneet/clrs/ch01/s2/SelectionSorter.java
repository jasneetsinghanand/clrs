package com.singhjasneet.clrs.ch01.s2;

import com.singhjasneet.clrs.common.ArrayUtils;
import com.singhjasneet.clrs.common.Sorter;

import java.util.Comparator;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

    private final Comparator<E> comparator;

    public SelectionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(E[] items) {

        for (int i = 0; i < items.length; i++) {
            // Find minimum for items[i..length]
            int minimumIndex = i;
            for (int j = i; j < items.length; j++) {
                if (comparator.compare(items[j], items[minimumIndex]) < 0) {
                    minimumIndex = j;
                }
            }
            // Swap minimumIndex with i
            ArrayUtils.swap(items, i, minimumIndex);
        }
    }
}
