package com.paul.algorithm.sort;

import static org.junit.Assert.assertTrue;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.function.BiPredicate;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class InsertionSpec {
  /**
   * Property test.
   *
   * @param items an integer array
   */
  @Property
  public void propertyTestSortedArray(Integer[] items) {
    Insertion<Integer> insertion = new Insertion<>();
    BiPredicate<Integer, Integer> isOrderedBefore = (Integer v1, Integer v2) -> v1 < v2;
    Integer[] result = insertion.sort(items, isOrderedBefore);
    assertTrue("Array should be sorted", Util.isSorted(result, isOrderedBefore));
  }

}