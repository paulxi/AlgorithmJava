package com.paul.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Merge<T> {
  /**
   * Merge sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);

    mergeSort(result, 0, items.length - 1, isOrderedBefore);

    return result;
  }

  private void mergeSort(T[] items, int low, int high,
                         BiPredicate<? super T, ? super T> isOrderedBefore) {
    if (low < high) {
      int mid = low + (high - low) / 2;

      mergeSort(items, low, mid, isOrderedBefore);
      mergeSort(items, mid + 1, high, isOrderedBefore);

      @SuppressWarnings("unchecked")
      T[] temp = (T[])Array.newInstance(items.getClass().getComponentType(), high - low + 1);

      int i = low;
      int j = mid + 1;

      int k = 0;

      while (i <= mid && j <= high) {
        if (isOrderedBefore.test(items[i], items[j])) {
          temp[k] = items[i];
          i++;
        } else {
          temp[k] = items[j];
          j++;
        }

        k++;
      }

      if (i <= mid) {
        System.arraycopy(items, i, temp, k, mid - i + 1);
      }

      if (j <= high) {
        System.arraycopy(items, j, temp, k, high - j + 1);
      }

      for (int index = 0; index < temp.length; index++) {
        items[low + index] = temp[index];
      }
    }
  }
}
