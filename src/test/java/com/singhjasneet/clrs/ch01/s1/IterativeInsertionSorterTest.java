package com.singhjasneet.clrs.ch01.s1;

import com.singhjasneet.clrs.common.BaseSortTest;
import com.singhjasneet.clrs.common.Sorter;

public class IterativeInsertionSorterTest extends BaseSortTest {

    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new IterativeInsertionSorter<>(INTEGER_COMPARATOR);
    }

    @Override
    protected Sorter<Integer> getDescendingSorter() {
        return new DescendingIterativeInsertionSorter<>(INTEGER_COMPARATOR);
    }
}
