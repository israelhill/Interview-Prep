public class BinarySearch {

  //a recursive implementation of binary search
  public int binarySearch(int[] array, int key, int imin, int imax) {
    if(imax < imin) {
      //the array is empty, key is not found
      return -1;
    }
    else {
      int imid = (imin + imax) / 2;

      if(key < array[imid]) {
        //key is in the lower half of array
        return binarySearch(array, key, imin, imid - 1);
      }
      else if (key > array[imid]) {
        //key is in the upper half od the array
        return binarySearch(array, key, imid + 1, imax);
      }
      else {
        //key = imid
        return imid;
      }
    }
  }

  public int iterativeBinarySearch(int[] array, int key, int imin, int imax) {
    while(imin <= imax) {
      int imid = (imax + imin) / 2;
      if(array[imid] == key) {
        //found key
        return imid;
      }
      else if(key < array[imid]) {
        //key in lower half of array -> update indecie of imax
        imax = imid - 1;
      }
      else if(key > array[imid]) {
        //key is in upper half of array -> update indecie of imin
        imin = imid + 1;
      }
    }

    //key was not found
    return -1;
  }

  public static void main(String[] args) {
      BinarySearch bs = new BinarySearch();
      int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 23, 34, 37, 46, 58, 69, 70, 71, 77, 79, 81, 83, 84};
      int key = 34;
      System.out.println("Key is at index: " + bs.iterativeBinarySearch(array, key, 0, array.length - 1));
  }
}
