package com.singhjasneet.clrs.common;

public interface Sorter<E extends Comparable<E>> {

    E[] sort(E[] items);
}
