package string;

/**
 * Created by ziweihan on 2/19/20.
 *
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s
 * is 1000.

 Example 1:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.

 Example 2:
 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring_M {

    /**
     * Used expending from center method to find the longest palindrom.
     * Then use two pointer sliding window to go left and right side of the center to find the longest palindrom.
     * Every palindrome string is either a odd or even length.
     *
     * Time: O(n^2) and Space: O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null)
            return null;
        if(s.isEmpty())
            return "";
        if(s.length() == 1)
            return s;
        String longest = ""; //default longest string
        int i = 1;
        while(i<s.length()){
            // get longest palindrome with center of i
            String temp = findLongestPalindromeFromCenter(s, i, i);
            if(temp.length()> longest.length()){
                longest = temp;
            }
            // get longest palindrome with center of i, i+1
            temp = findLongestPalindromeFromCenter(s, i, i+1);
            if(temp.length()>longest.length()){
                longest = temp;
            }
            i++;
        }
        return longest;
    }

    private String findLongestPalindromeFromCenter(String s, int start, int end){
        while(start >= 0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end); //start was decremented, so we need to add 1.
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_M solution = new LongestPalindromicSubstring_M();
        String input = "cbabcdefedc";
        System.out.print(solution.longestPalindrome(input));

    }


}
