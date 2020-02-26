package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziweihan on 1/24/20.
 *
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 Strings consists of lowercase English letters only and the length of both strings s and p
 will not be larger than 20,100.
 The order of output does not matter.

 Example 1:
 Input:
 s: "cbaebabacd" p: "abc"
 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".

 Example 2:
 Input:
 s: "abab" p: "ab"
 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams_M {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length()<p.length()){
            return res;
        }

        int i = 0;
        //check each pLength word in s.
        //s = "cbaebabacd", p = "abc"
        //check "cba", "bae", "aeb"..."acd" to see if it's a anagram of "abc"
        while((i+p.length()) <= s.length()){
            String subString = s.substring(i,i+p.length()); //subString  endIndex, exclusive.
            if(isAnagram(subString, p)){
                res.add(i);
            }
            i++;
        }
        return res;
    }

    private boolean isAnagram(String str, String p){
        int[] words = new int[256];
        int i = 0;
        while(i<p.length()){
            words[str.charAt(i)]++;
            words[p.charAt(i)]--;
            i++;
        }

        for(int num: words){
            if(num != 0) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        FindAllAnagrams_M pro = new FindAllAnagrams_M();
        List<Integer> result = pro.findAnagrams("cbaebabacd", "abc");
        for(int num: result){
            System.out.println(num);
        }


    }
}
