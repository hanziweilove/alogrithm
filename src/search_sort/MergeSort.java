package search_sort;

/**
 * Created by ziweihan on 10/6/18.
 */
public class MergeSort {

    public static void mergeSort(int[]a, int first, int last) {
        if(first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            mergeParts(a, first, mid, last);
        }
    }

    private static void mergeParts(int[]arr, int first, int mid, int last) {
        // Find sizes of two subarrays to be merged
        int n1 = mid-first+1;
        int n2 = last - mid;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for(int i = 0; i<n1; i++) {
            L[i] = arr[first+i];
        }
        for (int j = 0; j< n2; j++) {
            R[j] = arr[mid+1+j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarry array
        int k = first;
        while(i<n1 && j<n2) {
            if(L[i] <=R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }


        /* Copy remaining elements of L[] if any */
        while(i<n1) {
            arr[k++] = L[i++];
        }

        /* Copy remaining elements of R[] if any */
        while(j<n2) {
            arr[k++] = R[j++];
        }

    }


    /**
     * O(nlogn)
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {9,24,70,1,2,4,82,145,30};
        mergeSort(a, 0, a.length-1);
        for( int i = 0; i<a.length; i++) {
            System.out.println(String.valueOf(a[i]));
        }
    }
}
