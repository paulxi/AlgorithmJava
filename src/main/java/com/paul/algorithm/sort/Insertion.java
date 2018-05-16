package com.paul.algorithm.sort;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Insertion<T> implements ISort<T> {
  @Override
  public T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    T[] result = Arrays.copyOf(items, items.length);
    for (int i = 0; i < items.length; i++) {
      int j = i;
      while (j > 0 && isOrderedBefore.test(result[j], result[j - 1])) {
        T temp = result[j];
        result[j] = result[j - 1];
        result[j - 1] = temp;
        j--;
      }
    }
    return result;
  }
}
