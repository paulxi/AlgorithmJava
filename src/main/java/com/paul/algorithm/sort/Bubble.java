package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Bubble<T> {
  /**
   * Bubble sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);

    for (int i = 0; i < items.length; i++) {
      boolean changed = false;
      for (int j = 1; j < items.length - i; j++) {
        if (isOrderedBefore.test(result[j], result[j - 1])) {
          T temp = result[j];
          result[j] = result[j - 1];
          result[j - 1] = temp;
          changed = true;
        }
      }

      if (!changed) {
        break;
      }
    }

    return result;
  }
}
