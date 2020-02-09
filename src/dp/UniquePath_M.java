package dp;

/**
 * Created by ziweihan on 2/8/20.
 *
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 Note: m and n will be at most 100.

 Example 1:
 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 */
public class UniquePath_M {

    /**
     Use dp to store unique path numbers for each grid,
     1*1 matrix: dp[0][0]=1,
     1*2 matrix: dp[0][1]=1,
     1*n matrix: dp[0][n]=1,
     2*1 matrix: dp[[1][0]=1,
     m*1 matrix: dp[m][0]=1
     m*n matrix: dp[m][n] = dp[m][n-1] + dp[m-1][n]
     it's a sum of unique path numbers of left dp grid, and top dp grid.
    **/
    public int uniquePaths(int m, int n) {
        //init dp matrix
        int[][] dp = new int[m][n];

        //init top row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //init left col
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        //fill in the dp M*N matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
               dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath_M slt = new UniquePath_M();
        System.out.print(slt.uniquePaths(3, 3));
    }
}
