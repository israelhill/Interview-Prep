// Merge sort is a comparison based divide and conquer sorting algorithm
// Time complexity: O(n log n)

// Step 1: Divide the unsorted list into n sublists (a list containing 1
// element is sorted)
// Step 2: Repeatedly merge sublists until only 1 sorted list remains

public class MergeSort {

  public void merge(int[] arr, int left, int middle, int right) {
    //variables for indexing
    int i, j, k;

    // get the size of left and right sub arrays
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // create temp arrays for left and right portions
    int[] L = new int[n1];
    int[] R = new int[n2];

    // copy data into temp arrays
    for(i = 0; i < n1; i++) {
      L[i] = arr[left + i];
    }
    for(j = 0; j < n2; j++) {
      R[j] = arr[middle + 1 + j];
    }

    // merge temp arrays back into orginal array
    i = 0;
    j = 0;
    k = left;

    while(i < n1 && j < n2) {
      if(L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    // copy remaing elements of left or right sub array
    while(i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while(j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public void mergeSort(int[] arr, int left, int right) {
    if(left < right) {
      int middle = (left + right) / 2;
      mergeSort(arr, left, middle);
      mergeSort(arr, middle + 1, right);
      merge(arr, left, middle, right);
    }
  }
  public static void main(String[] args) {
    MergeSort sort = new MergeSort();
    int[] arr = {2, 0, 6, 4, 9, 56, 24, 65, 71, 17, 10, 21, 9, 43};
    System.out.print("Unsorted Array: ");
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }

    System.out.println("");
    sort.mergeSort(arr, 0, arr.length - 1);

    //print the sorted array
    System.out.print("Sorted Array: ");
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println("");
  }
}
