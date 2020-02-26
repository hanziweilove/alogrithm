package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ziweihan on 2/21/20.
 *
 * 409. Longest Palindrome
 *Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 This is case sensitive, for example "Aa" is not considered a palindrome here.
 Note:
 Assume the length of given string will not exceed 1,010.

 Example:
 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome_E {

    /**
     * 1. Count number of odd and even chars and odd chars
     * if odd>0, result = 1+even char count
     * if odd==0, result = even char count
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] charTable = new int[216];
        for(int i=0; i<s.length(); i++){
            charTable[s.charAt(i)]++;
        }

        int oddCount = 0;
        int evenCount = 0;
        for(int i = 0; i<charTable.length; i++){
           int count = charTable[i];
           if(count>0) {
               if (count % 2 == 0) { //case even number
                   evenCount = evenCount + count;
               }
               else{
                   if(count ==1){ //case 1
                      oddCount++;
                   }else{
                      evenCount = evenCount + count-1; //case 3,5,7...
                      oddCount++;
                   }
               }
           }
        }
        return oddCount>0? 1+evenCount:evenCount;
    }

    /**
     * 2. Use set to keep track of the unique characters, if not seen, add it to the set, if it's seen, remove it.
     * so it makes sure the set has all unique characters
     * "aaabb" set has 'a', so longest palindrome is 5-1+1 = 5 ->"baaab"
     * "abcdd" set has 'abc', so longest palindrome is 5-3+1 = 3 ->"dad"
     * @param s
     * @return
     */
    public int longestPalindrom_set(String s){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c))
                set.add(c);
            else
                set.remove(c);
        }

        int remove = set.size();
        if(remove >0) //if there is at least one unique char
            return s.length()-set.size()+1;
        //if there is no unique char at all
        return s.length();
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindrome_E solution = new LongestPalindrome_E();
        System.out.print(solution.longestPalindrom_set(s));
    }
}
