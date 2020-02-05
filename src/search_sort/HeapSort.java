package search_sort;

/**
 * Created by ziweihan on 1/17/20.
 *
 * https://www.geeksforgeeks.org/heap-sort/
 */
public class HeapSort {

    public void sort(int[] arr){
        //1. build a max heap (rearrange array), bottom up from bottom left parent.
        int n = arr.length;
        for(int i = n/2-1; i >= 0; i--){
            maxHeapify(arr, n, i);
        }
        //2. Move current root to end (swap the root with last element of reduced heap)

        for(int i = n-1 ; i >= 0 ; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;

            // call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }

    }


    /**
     * To heapify a subtree rooted with node i which is an index in arr[].
     * n is size of heap
     * @param arr
     * @param n
     * @param i
     */
    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i +1; // left = 2*i + 1, left child of i
        int r = 2*i +2; // right = 2*i + 2 , right child of i

        // If left child is larger than root
        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }

        // If right child is larger than largest so far
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }

        // If largest is not root
        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }

    private void printResult(int[] arr){
        for(int num: arr){
            System.out.print(num+ ",");
        }
    }

    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();
        int[] arr = {12, 11,48, 13, 5, 6,4, 1,53, 7, 24, 69};
        heapSort.sort(arr);
        heapSort.printResult(arr);
    }
}

