package array;


import java.util.PriorityQueue;

/**
 * Created by ziweihan on 9/10/19.
 *
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */


public class KthSmallestElementInSortedMatrix_M {

    /**
     * use priority queue as a min heap, it helps to sort the array.
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j< matrix[i].length; j++){
                queue.offer(matrix[i][j]);
            }
        }

        int n = 1;
        while(n<k){
            queue.poll();
            n++;
        }
       return queue.peek();
    }

    /**
     * Build a minHeap of elements from the first row.
     Do the following operations k-1 times :
     Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number
     of that element(so we can create a tuple class here), replace that root with the next element from the
     same column.
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int j = 0; j <= n-1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }

        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue; //avoid index out of bound in x+1
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }


    public static void main(String[] args){
        int[][] input = {{1,  5,  9 },
                         {6, 8, 10},
                         {7, 11, 15}};

        KthSmallestElementInSortedMatrix_M problem = new KthSmallestElementInSortedMatrix_M();
        System.out.print(problem.kthSmallest_2(input, 6));



    }

}


