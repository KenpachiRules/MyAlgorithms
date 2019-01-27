package com.hari.learning.algo.sorters.test

import org.testng.annotations.Test
import org.testng.Assert
import com.hari.learning.algo.sorters.MergeSort

class MergeSortTests {

  @Test
  private def testSingleElementArray: Unit = {
    val result = MergeSort.divideAndConquer(20 :: Nil)
    assert(result != null && !result.isEmpty && result(0) == 20)
  }

  @Test
  private def testDescendingOrderArray: Unit = {
    val result = MergeSort.divideAndConquer(100 :: 75 :: 50 :: 25 :: 0 :: (-25) :: Nil)
    assert(result != null && !result.isEmpty && isOrdered(result))
  }

  @Test
  private def testAlreadySortedArray: Unit = {
    val result = MergeSort.divideAndConquer((-10) :: 0 :: 10 :: 20 :: 30 :: 40 :: 50 :: Nil)
    assert(result != null && !result.isEmpty && isOrdered(result))
  }

  private def isOrdered(list: List[Int]): Boolean = {
    for (i <- 1 until list.size) {
      if (list(i - 1) > list(i))
        return false
    }
    true
  }

}