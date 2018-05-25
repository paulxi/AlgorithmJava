package com.paul.algorithm.sort;

import static org.junit.Assert.assertTrue;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.function.BiPredicate;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class SelectionSpec {
  /**
   * Property test.
   *
   * @param items an integer array
   */
  @Property
  public void propertyTestSortedArray(Integer[] items) {
    Selection<Integer> selection = new Selection<>();
    BiPredicate<Integer, Integer> isOrderedBefore = (v1, v2) -> v1 < v2;
    Integer[] result = selection.sort(items, isOrderedBefore);
    assertTrue("Array should be sorted", Util.isSorted(result, isOrderedBefore));
  }

}
