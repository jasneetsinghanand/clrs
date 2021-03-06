package com.singhjasneet.clrs.ch01.s1;

import java.util.Comparator;

public class DescendingIterativeInsertionSorter<E extends Comparable<E>> extends InsertionSorter<E> {

    private final Comparator<E> comparator;

    public DescendingIterativeInsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(E[] items) {
        for (int i=1; i<items.length;i++){
            E currentKey = items[i];
            /**
             * - Find the place in sub-array items[0..i-1] where currentKey could be placed
             * - Sub-array items[0..i-1], has already been sorted in ascending order
             * **/
            int placement = findPlacementDesc(items, currentKey, i, this.comparator);
            System.arraycopy(items, placement, items, placement + 1, i - placement);
            items[placement] = currentKey;
        }
    }
}
