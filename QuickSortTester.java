/*
WhatShouldOurNameBe -- Rohan Ahammed, Joan Chirinos, Soojin Choi
APCS2 pd08
L01 -- What Does the Data Say?
2018-03-13
*/
/*
  Timing Mechanism: Runtime is calculated by calling System.nanonTime() before running
  QuickSort, and then calling it again after, and using the difference between the two.
  It is then put into an arraylist (chosen because it is easier to simply AL.add things),
  into which all of the differences, representing the time it took to run QuickSort, are
  stored. Background processes and other running applications are minimized, which is achieved
  to the best of our ability through Activity Monitor on OSX
*/

/*
Uses FileRW, Joan's generic file reader and Writer
*/

import java.util.ArrayList;

public class QuickSortTester {

  public static void popArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int)(Math.random() * 100) - 100;
    }
  }//end popArray

  public static double time(int arrSize) {
    int[] arr = new int[arrSize];
    popArray(arr);
    double start = System.nanoTime();
    QuickSort.qsort(arr);
    double end = System.nanoTime();
    return end - start;
  }//end time

  public static void main(String[] args) {
    ArrayList<Double[]> timeStore = new ArrayList<Double[]>();

    //trying different sizes of array
    for (int size = 1000; size <= 40000; size += 100) {
      //trying each size a bunch of times
      for (int test = 0; test < 100; test++) {
        Double[] testArr = {size * 1.0, time(size)}; //Things we learned: you can put method calls into an array!
        timeStore.add(testArr);
      }
    }

    //write to csv file
    String toWrite = "";
    for (Double[] i : timeStore) {
      toWrite += i[0] + "," + i[1] + "\n";
    }
    FileRW.write(toWrite, "data.csv");

  }//end main

}//end class
