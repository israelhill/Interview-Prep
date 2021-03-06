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

  //a cool way to reverse a string
  public String reverseString(String s) {
    int length = s.length();
    int last = length - 1;
    char[] chars = s.toCharArray();
    for(int i = 0; i < length / 2; i++) {
      //swap front and back characters
      char c = chars[i];
      chars[i] = chars[last - i];
      chars[last - i] = c;
    }
    return new String(chars);
  }

  //return the nth fibonacci number, one line of code!
  //naive approach: O(2^n)
  public int fib(int n) {
    return n <= 1 ? n : fib(n - 1) + fib(n - 2);
  }

  //Fib using caching, must faster
  //O(n)
  public int fibonacci(int i) {
    return fibonacci(i, new int[i + 1]);
  }

  public int fibonacci(int i, int[] cache) {
    if(i == 0) return 0;
    if(i == 1) return 1;

    if(cache[i] == 0) {
      cache[i] = fibonacci(i - 1, cache) + fibonacci(i - 2, cache);
    }

    return cache[i];
  }

  public static void main(String[] args) {
      BinarySearch bs = new BinarySearch();
      int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 23, 34, 37, 46, 58, 69, 70, 71, 77, 79, 81, 83, 84};
      int key = 34;
      String s = "Reverse Me";
      System.out.println("Key is at index: " + bs.iterativeBinarySearch(array, key, 0, array.length - 1));
      System.out.println("Reversed string: " + bs.reverseString(s));
      System.out.println("Fibanocci: " + bs.fibonacci(7));
  }
}
