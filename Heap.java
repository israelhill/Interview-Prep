import java.util.Arrays;

public class Heap {

    private int left(int i) {
        if(i == 0) {
            return 1;
        }
        return i * 2 + 1;
    }

    private int right(int i) {
        if(i == 0) {
            return 2;
        }
        return i * 2 + 2;
    }

    private void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int[] arr, int i, int size) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if(left < size && arr[left] > arr[i]) {
            largest = left;
        }
        if(right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if(i != largest) {
            exchange(arr, largest, i);
            heapify(arr, largest, size);
        }
    }

    private void buildHeap(int[] arr) {
        int size = arr.length;
        for(int i = size/2; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    private void heapSort(int[] arr) {
        buildHeap(arr);
        int size = arr.length;
        for(int i = size-1; i > 0; i--) {
            exchange(arr, 0, i);
            size--;
            heapify(arr, 0, size);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        h.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
