package array;

/**
 * Created by ziweihan on 1/30/20.
 *
 * 977. Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
 * also in sorted non-decreasing order.
 *

 Example 1:

 Input: [-4,-1,0,3,10]
 Output: [0,1,9,16,100]
 Example 2:

 Input: [-7,-3,2,3,11]
 Output: [4,9,9,49,121]
 */
public class SquresOfSortedArray_E {

    /** Two pointers method
     * Find the boundary between negative and positive numbers
     * compare the squres of both sides and put the result in result array
     * i goes to the left
     * j goes to the right
     * put the rest of the number into the result array after
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int size = A.length;
        int i = 0; //negative index
        int j = 0; //positive index
        int ans[] = new int[size];

        //find the index of where negative and positive numbers split
        while(j<size && A[j]<0){
            j++;
        }
        i = j-1;

        // compare squares and put smaller answer into result array
        int ansIndex = 0;
        while(i>=0 && j<size){
            if(A[i] * A[i]< A[j]* A[j]){
                ans[ansIndex++] = A[i] * A[i];
                i--;
            }else {
                ans[ansIndex++] = A[j] * A[j];
                j++;
            }
        }

        while(i>=0) {
            ans[ansIndex++] = A[i] * A[i];
            i--;
        }

        while(j< size){
            ans[ansIndex++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        SquresOfSortedArray_E problem = new SquresOfSortedArray_E();
        int[] result = problem.sortedSquares(new int[]{-7,-3,2,3,11});

        for(int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
    }
}
