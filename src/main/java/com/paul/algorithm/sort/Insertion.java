package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Insertion<T> {
  /**
   * Insertion sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    for (int i = 1; i < items.length; i++) {
      int j = i;
      while (j >= 1 && isOrderedBefore.test(result[j], result[j - 1])) {
        T temp = result[j];
        result[j] = result[j - 1];
        result[j - 1] = temp;
        j--;
      }
    }
    return result;
  }
}
