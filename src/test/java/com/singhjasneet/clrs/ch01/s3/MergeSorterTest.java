package com.singhjasneet.clrs.ch01.s3;

import com.singhjasneet.clrs.common.BaseSortTest;
import com.singhjasneet.clrs.common.Sorter;

public class MergeSorterTest extends BaseSortTest {

    @Override
    protected Sorter<Integer> getAscendingSorter() {
        return new MergeSorter<>(INTEGER_COMPARATOR);
    }

    @Override
    protected Sorter<Integer> getDescendingSorter() {
        // no-op
        return null;
    }
}
