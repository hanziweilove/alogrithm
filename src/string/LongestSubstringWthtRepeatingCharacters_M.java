package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ziweihan on 5/7/19.
 *
 * 3. Longest Substring Without Repeating Characters
 Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWthtRepeatingCharacters_M {

    public int lengthOfLongestSubstring(String s) {
        //error case handling
        if(s == null || s.length() == 0)
            return 0;

        int left = 0; //left pointer is farthest non-repeating char
        int right = 0; //right pointer is expand the sliding window
        int max = 0;
        Set<Character> set = new HashSet<>(); //for unique characters
        while(right < s.length()){
            if(set.add(s.charAt(right))){
                //if set doesn't contain, it will add the char, and return false
                max = Math.max(max, set.size());
                right ++;
            }else {
                //if set contains the char, remove the last left pointer char from the set
                //because we need to find the next non repeating char to recalculate the max.
                set.remove(s.charAt(left));
                left ++;
            }
        }


        return max;
    }

    public static void main(String[] args) {
        String s = "abbb";
        LongestSubstringWthtRepeatingCharacters_M pro = new LongestSubstringWthtRepeatingCharacters_M();
        System.out.print(pro.lengthOfLongestSubstring(s));
    }
}
