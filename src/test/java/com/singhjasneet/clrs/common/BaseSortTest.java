package com.singhjasneet.clrs.common;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Comparator;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;

import static org.hamcrest.MatcherAssert.assertThat;

public abstract class BaseSortTest {

    protected abstract Sorter<Integer> getAscendingSorter();
    protected abstract Sorter<Integer> getDescendingSorter();

    protected static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    @Test
    public void testSimpleAscendingSortWithNegativeItems() throws Exception{
        final Integer[] items = {-7, -9, -8, 7, 9, 8, 0};
        final int length = items.length;
        getAscendingSorter().sort(items);
        assertThat(items, arrayWithSize(length));
        assertThat(items, arrayContaining(-9, -8, -7, 0, 7, 8, 9));
    }


    @Test
    public void testSortIntegrity() throws Exception {
        Integer[] target = {31,41,59,26,41,58,-1};
        Integer[] expected = {31,41,59,26,41,58, -1};
        Arrays.sort(expected);
        getAscendingSorter().sort(target);
        assertThat(target, arrayWithSize(expected.length));
        assertThat(target, arrayContaining(expected));
    }

    @Test
    public void testSortIntegrityDescending() throws Exception {
        if (getDescendingSorter() == null) {
            return;
        }
        Integer[] target = {31,41,59,26,41,58};
        Integer[] expected = {31,41,59,26,41,58};
        Arrays.sort(expected);
        Integer[] descArray = new Integer[expected.length];
        for(int i=0; i<expected.length; i++) {
            descArray[i] = expected[(expected.length-1)-i];
        }

        getDescendingSorter().sort(target);
        assertThat(target, arrayWithSize(descArray.length));
        assertThat(target, arrayContaining(descArray));
    }
}
