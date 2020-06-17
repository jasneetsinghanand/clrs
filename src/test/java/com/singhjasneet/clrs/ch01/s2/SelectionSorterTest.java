package com.singhjasneet.clrs.ch01.s2;

import com.singhjasneet.clrs.common.BaseSortTest;
import com.singhjasneet.clrs.common.Sorter;

public class SelectionSorterTest extends BaseSortTest {

    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new SelectionSorter<>(INTEGER_COMPARATOR);
    }

    @Override
    protected Sorter<Integer> getDescendingSorter() {
        //no-op
        return null;
    }
}
