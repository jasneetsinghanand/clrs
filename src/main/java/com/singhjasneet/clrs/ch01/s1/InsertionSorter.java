package com.singhjasneet.clrs.ch01.s1;

import com.singhjasneet.clrs.common.Sorter;

import java.util.Comparator;

public abstract class InsertionSorter<E extends Comparable<E>> implements Sorter<E> {


    protected int findPlacement(E[] items, E currentKey, int length, Comparator<E> comparator) {
        int placement = length;
        for (int i = length-1; i >=0; i--){
            if (comparator.compare(currentKey,items[i]) > 0) {
                placement = i+1;
                break;
            }
        }
        if (placement == length && comparator.compare(items[0], currentKey) > 0)
            placement = 0;
        return placement;
    }

    protected E[] moveElementsAndPlaceKey(E[] items, int placement, int length) {
        E currentKey = items[length];
        for (int j=length-1; j>=placement; j--) {
            items[j+1] = items[j];
        }
        items[placement] = currentKey;
        return items;
    }

    protected int findPlacementDesc(E[] items, E currentKey, int length, Comparator<E> comparator) {
        int placement = length;
        for (int i = length-1; i >=0; i--){
            if (comparator.compare(currentKey,items[i]) < 0) {
                placement = i+1;
                break;
            }
        }
        if (placement == length && comparator.compare(items[0], currentKey) < 0)
            placement = 0;
        return placement;
    }
}
