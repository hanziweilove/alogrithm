package recursion;

/**
 * Created by ziweihan on 4/5/19.
 *
 * 200. Number of Islands
 *
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1

 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 */
public class NumberOfIslands_M {

    public int islandCount(char[][] grid) {
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    recursivelyChangeLandToWater(grid, i, j);
                }
            }
        }
        return islandCount;
    }


    private void recursivelyChangeLandToWater(char[][] isLandArray, int i, int j) {
        //base case: out of bound or it's already 0
        if ( i< 0|| i >= isLandArray.length || j < 0 || j >= isLandArray[0].length || isLandArray[i][j] == '0')
            return;
        isLandArray[i][j] = '0';
        recursivelyChangeLandToWater(isLandArray, i, j+1); // go right
        recursivelyChangeLandToWater(isLandArray, i, j-1); // go left
        recursivelyChangeLandToWater(isLandArray, i+1, j); // go down
        recursivelyChangeLandToWater(isLandArray, i-1, j); // go up
    }

    public static void main(String[] args) {
        NumberOfIslands_M numberOfIslands = new NumberOfIslands_M();
        char[][] island1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0','0', '0'}};
        char[][] island2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] island3 = {{'1','1','1'},
                            {'0','1','0'},
                            {'1','1','1'}};
        System.out.print(numberOfIslands.islandCount(island3));
    }
}
