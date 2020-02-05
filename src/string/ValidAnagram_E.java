package string;

/**
 * Created by ziweihan on 5/12/19.
 *
 * 242. Valid Anagram
 *
 Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:
 Input: s = "anagram", t = "nagaram"
 Output: true

 Example 2:
 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram_E {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return true;
        if(s.length() != t.length()) return false;

        int[] letters = new int[26];
        for(int i = 0; i< s.length(); i++){
            letters[s.charAt(i)-'a']++;
            letters[t.charAt(i)-'a']--;
        }

        for(int isShown: letters){
            if(isShown>0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        ValidAnagram_E anagram = new ValidAnagram_E();
        String s = "supercalifragalisticespialidocius";
        String t = "supercalifragalisticespialidociaa";
        System.out.print("s = "+s+ ",and t = " + t + " are anagram: "+anagram.isAnagram(s, t));
    }


}
