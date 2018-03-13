/*
  WhatShouldOurNameBe -- Rohan Ahammed, Joan Chirinos, Soojin Choi
  APCS2 pd08
  L01 -- What Does the Data Say?
  2018-03-13
*/

import java.util.ArrayList;
import jutils.FileRW;

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
    for (int size = 1000; size <= 20000; size += 100) {
      //trying each size a bunch of times
      for (int test = 0; test < 1; test++) {
        double[] testArr = {size, time(size)}; //Things we learned: you can put function calls into an array!
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
