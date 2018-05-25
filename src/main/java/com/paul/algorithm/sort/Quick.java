package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Quick<T> {
  /**
   * Quick sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    if (items.length <= 1) {
      return items;
    }

    quickSort(result, 0, result.length - 1, isOrderedBefore);

    return result;
  }

  private void quickSort(T[] items, int low, int high,
                         BiPredicate<? super T, ? super T> isOrderedBefore) {
    if (low < high) {
      int pivotIndex = partition(items, low, high, isOrderedBefore);
      quickSort(items, low, pivotIndex - 1, isOrderedBefore);
      quickSort(items, pivotIndex + 1, high, isOrderedBefore);
    }
  }

  private int partition(T[] items, int low, int high,
                        BiPredicate<? super T, ? super T> isOrderedBefore) {
    T pivot = items[low];

    int i = low;
    int j = high;
    while (i < j) {
      while (i < j && isOrderedBefore.test(pivot, items[j])) {
        j--;
      }

      if (i < j) {
        items[i] = items[j];
        i++;
      }

      while (i < j && isOrderedBefore.test(items[i], pivot)) {
        i++;
      }

      if (i < j) {
        items[j] = items[i];
        j--;
      }
    }

    items[i] = pivot;

    return i;
  }
}
