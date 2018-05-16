package com.paul.algorithm.sort;

import java.util.function.BiPredicate;

public interface ISort<T> {
  T[] sort(T[] items, BiPredicate<? super T, ? super T> isOrderedBefore);
}
