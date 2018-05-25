package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Heap<T> {
  /**
   * Heap sort algorithm.
   *
   * @param items           an array to be sorted
   * @param isOrderedBefore a predicate to check if the first parameter is less than
   *                        the second parameter
   * @return a sorted array
   */
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    heapSort(result, isOrderedBefore);

    return result;
  }

  private void heapSort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    buildMaxHeap(items, isOrderedBefore);
    for (int i = items.length - 1; i >= 0; i--) {
      T temp = items[0];
      items[0] = items[i];
      items[i] = temp;

      maxHeapify(items, 0, i, isOrderedBefore);
    }
  }

  private void buildMaxHeap(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    int parentIndex = items.length / 2 - 1;
    for (int i = parentIndex; i >= 0; i--) {
      maxHeapify(items, i, items.length, isOrderedBefore);
    }
  }

  private void maxHeapify(T[] items, int from, int heapSize,
                          BiPredicate<? super T, ? super T> isOrderedBefore) {
    int index = from;
    while (true) {
      int k = index;
      int leftIndex = 2 * index + 1;
      int rightIndex = leftIndex + 1;

      if (leftIndex < heapSize && isOrderedBefore.test(items[index], items[leftIndex])) {
        index = leftIndex;
      }

      if (rightIndex < heapSize && isOrderedBefore.test(items[index], items[rightIndex])) {
        index = rightIndex;
      }

      if (k != index) {
        T temp = items[k];
        items[k] = items[index];
        items[index] = temp;
      } else {
        break;
      }
    }
  }
}
