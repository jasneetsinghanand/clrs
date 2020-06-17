package com.singhjasneet.clrs.common;

public interface Sorter<E extends Comparable<E>> {

    void sort(E[] items);
}
