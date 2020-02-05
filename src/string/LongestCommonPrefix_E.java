package string;

/**
 * Created by ziweihan on 3/25/19.
 *
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string
 * amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:
 Input: ["flower","flow","flight"]
 Output: "fl"

 Example 2:
 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix_E {

    private static String longestCommonString(String[] strs) {
        if(strs == null || strs.length ==0)
            return "";
        String commonPrefix = strs[0];
        for(String word: strs) {
            //use first string to find common prefix, since first string is the longest possible prefix
            //loop through every string, and find the next common prefix
            commonPrefix = findCommonPrefix(commonPrefix, word);
        }
        return commonPrefix;
    }


    private static String findCommonPrefix(String commonPrefix, String word){
        //find common prefix of two words by subtracting commonPrefix: "flower" -> "flowe"-> "flow"-> "flo"...
        String newPrefix = commonPrefix;
        for(int i = 0; i < commonPrefix.length(); i++){
            if(word.startsWith(newPrefix))
                return newPrefix;
            //Note: String.substring(beginIndex(inclusive), endIndex(exclusive)
            newPrefix = commonPrefix.substring(0, commonPrefix.length()-i-1);
        }

        return "";
    }

    public static void main(String[] args) {
        String[] input = {"ab", "aa"};
        System.out.print(longestCommonString(input));
    }
}
