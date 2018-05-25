package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Selection<T> {
  /**
   * Selection sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    for (int i = 0; i < items.length; i++) {
      int min = i;

      for (int j = i + 1; j < items.length; j++) {
        if (isOrderedBefore.test(result[j], result[min])) {
          min = j;
        }
      }

      T temp = result[i];
      result[i] = result[min];
      result[min] = temp;
    }
    return result;
  }
}
