package search_sort;

/**
 * Created by ziweihan on 10/6/18.
 */
public class QuickSort {

    public static void quickSort(int[] a, int first, int last) {
        /**
         * THIS CHECK is important since if sp = 0, sp-1 = -1, throws indexOutOfBoundException
         * Recursively search_sort the array divided by the pivot position
         */
        if(first < last) {
            int sp = partition(a, first, last);
            quickSort(a, first, sp - 1);
            quickSort(a, sp + 1, last);
       }

    }

    /**
     * return the position of the split point for next partition
     * @param a
     * @param first
     * @param last
     * @return
     */
    private static int partition(int[] a, int first, int last) {
        int pivot = a[first];
        do {
            while(first<last && a[last]>=pivot) {
                //check from high positions, if last position number >pivot, keep going
                last--;
            }
            if(first == last)
                break;
            a[first] = a[last]; //move smaller number into the empty first position
            first++;

            while(first<last && a[first]<= pivot) {
                //check from low positions, if lower position number<= pivot, keep going
                first ++;
            }
            if(first == last)
                break;
            a[last] = a[first]; //move bigger number into the empty last position
            last --;

        }while(true);

        a[first] = pivot; //put pivot number to it's position in order of the array
        return first; //next split point

    }

    /**
     * O(nlogn)
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {9,24,70,1,2,4,82,145,30};
        quickSort(a, 0, a.length-1);
        for( int i = 0; i<a.length; i++) {
            System.out.println(String.valueOf(a[i]));
        }

    }
}
