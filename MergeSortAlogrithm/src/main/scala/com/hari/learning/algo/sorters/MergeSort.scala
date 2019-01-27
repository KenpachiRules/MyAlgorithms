package com.hari.learning.algo.sorters

import scala.collection.mutable.ListBuffer

object MergeSort {

  def main(args: Array[String]): Unit = {
    divideAndConquer(List(2,4,3,5,1)).foreach(println)
  }

  private def divideAndConquer(list: List[Int]): List[Int] = {
    if (list.size == 1)
      return list
    // divide the list into two halves. if even split evenly if odd split with one side more than the other
    val splitSize = if (list.size % 2 == 0) {
      list.size / 2
    } else {
      list.size / 2 + 1
    }
    var list1 = list.take(splitSize)
    list1 = divideAndConquer(list1)
    var list2 = list.takeRight(list.size - splitSize)
    list2 = divideAndConquer(list2)
    // now merge it together, have two pointers to check for sort order.
    val combinedList: ListBuffer[Int] = new ListBuffer()
    var j = 0
    var i = 0
    while (i < list1.size && j < list2.size) {
      if (list1(i) <= list2(j)) {
        combinedList.+=(list1(i))
        i += 1
      } else {
        combinedList.+=(list2(j))
        j += 1
      }
    }
    // if there are remaining elements in the second list just add to the combined list as such
    if (j < list2.size)
      combinedList.++=(list2.takeRight(list2.size - j))
    else if (i < list1.size)
      combinedList.++=(list1.takeRight(list1.size - i))
    return combinedList.toList

  }

}