package com.paul.algorithm.sort;

import java.util.function.BiPredicate;

class Util {
  static <T> boolean isSorted(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore) {
    for (int i = 1; i < items.length; i++) {
      if (isOrderedBefore.test(items[i], items[i - 1])) {
        return false;
      }
    }

    return true;
  }
}
