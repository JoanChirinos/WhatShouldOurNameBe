/*
  Joan Chirinos
  APCS2 pd08
  HW18 -- So So Quick
  2018-03-12
*/

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): calls qsortHelper(arr, 0, arr.length - 1)
 * qsortHelper(arr, left, right): if left < right, partition [left, right] at a random index and
 * call qsortHelper on the 2 sides of the array split at the final pivot resting point
 *
 * 2a. Worst pivot choice and associated runtime:
 * Worst pivot choice would be the first or last index because, they have a definite and
 * common worst case scenario. However, this is just one worst case. Random might run multiple different worst cases
 * on the same array (I think)
 *
 * 2b. Best pivot choice and associated runtime:
 * I pivoted at a random index because it makes qsort less likely to pick a worst case scenario.
 * Additionally, it makes it even less likely to do the same data set at worst time twice.
 * Math.random() might be expensive but in O(n), I think your average time is proably nlogn ish
 *
 * 3. Approach to handling duplicate values in array:
 * I think it kinda deals with itself. Presumably, picking a static pivot position might deal with loops,
 * but the random pvtPos makes an infinite loop infinitely less likely
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d ) {
    qsortHelper( d, 0, d.length - 1 );
  }//end qsort

  /***
  * void qsortHelper(int[], int, int)
  * @param arr -- array of ints to be sorted in place
  * @param left -- lower bound for partition range
  * @param right -- upper bound for partition range
  ***/
  public static void qsortHelper( int[] arr, int left, int right ) {
    if (left < right) {
      int pvt = partition(arr, left, right);
      qsortHelper(arr, left, pvt - 1);
      qsortHelper(arr, pvt + 1, right);
    }
  }//end qsortHelper

  public static int partition( int[] arr, int left, int right ) {

    //CHOOSING RANDOM PIVOT POS
    int pvtPos = left + (int)(Math.random() * (right - left + 1));

    int pvtVal = arr[pvtPos];
    swap(pvtPos, right, arr);
    int storePos = left;
    for (int i = left; i < right; i++) {
      if (arr[i] < pvtVal) {
        swap(storePos, i, arr);
        storePos++;
      }
    }
    swap(right, storePos, arr);
    return storePos;
  }//end partition

  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after qsort: " );
    printArr(arrN);

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);

    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);

  }//end main

}//end class QuickSort
