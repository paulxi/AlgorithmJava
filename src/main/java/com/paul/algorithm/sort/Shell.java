package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Shell<T> {
  /**
   * Shell sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    int gap = 1;
    while (gap < items.length / 3) {
      gap = 3 * gap + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < items.length; i++) {
        int j = i;
        while (j >= gap && isOrderedBefore.test(result[j], result[j - gap])) {
          T temp = result[j];
          result[j] = result[j - gap];
          result[j - gap] = temp;
          j -= gap;
        }
      }

      gap = gap / 3;
    }

    return result;
  }
}
