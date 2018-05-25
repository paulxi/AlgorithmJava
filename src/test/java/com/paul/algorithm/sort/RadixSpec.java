package com.paul.algorithm.sort;

import static org.junit.Assert.assertTrue;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class RadixSpec {
  /**
   * Property test.
   *
   * @param items an integer array
   */
  @Property
  public void propertyTestSortedArray(@InRange(minInt = 0, maxInt = 100000) int[] items) {
    Radix radix = new Radix();
    int[] result = radix.sort(items);
    assertTrue("Array should be sorted", Util.isSorted(result));
  }
}
