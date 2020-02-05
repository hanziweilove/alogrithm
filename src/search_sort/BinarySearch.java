package search_sort;

/**
 * Created by ziweihan on 1/15/20.
 */

public class BinarySearch {

    /**
     * return the index of the found item,
     * return -1 if not found.
     * @param input
     * @param target
     * @return
     */
    public int search(int[] input, int target){
        int L = 0;
        int R = input.length;
        int M = 0;
        while(L<R){
            M = (L+R)/2;
            if(input[M] == target) {
                return M;
            }
            if(input[M]< target){
                //target is on the right
                L = M;
            }else {
                R = M;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        BinarySearch problem = new BinarySearch();
        System.out.print(problem.search(new int[]{1,2,3,4,7,9,10,15,30,31,34}, 34));
    }
}
