package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ziweihan on 5/27/19.
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it.
 Example:

 Input: 5
 Output:
 [
        [1],
       [1,1],
      [1,2,1],
     [1,3,3,1],
    [1,4,6,4,1]
 ]

 */
public class PascalsTriangle_M {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(numRows == 0)
            return resultList;
        if(numRows ==1){
            resultList.add(Arrays.asList(1));
            return resultList;
        }

        //Generate previous list
        List<List<Integer>> preLists = generate(numRows-1);
        List<Integer> preLastRow = preLists.get(numRows-2);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for(int i = 1; i<numRows - 1; i++){
            // Use previous lists' last row to generate the new row
            int element = preLastRow.get(i-1)+ preLastRow.get(i);
            newRow.add(element);
        }
        newRow.add(1);

        resultList.addAll(preLists);
        resultList.add(newRow);
        return resultList;
    }

    public static void main(String[] args){
        PascalsTriangle_M problem = new PascalsTriangle_M();
        List<List<Integer>> result = problem.generate(5);
    }
}
