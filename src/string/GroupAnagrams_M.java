package string;

import java.util.*;

/**
 * Created by ziweihan on 2/5/20.
 *
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.
 */
public class GroupAnagrams_M {

    /**
     * Time : O(n^2)
     * Space: O(n)
     *
     * Use a hash map
     * key = char array of each string
     * value = ArrayList of the anagram set
     *
     * The trick is to use the char array to record the count of each character in the string,
     * and use it as a key to look up in the table
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();

        for(int i = 0; i< strs.length; i++){
            char[] chars = new char[26];
            String str = strs[i];

            //convert each string to a char array with count of each char
            //by incrementing ASCII index
            for(int j = 0; j< str.length(); j++){
                chars[str.charAt(j)-'a']++;
            }
            //create new string key based on the char array
            String strKey = String.valueOf(chars);

            //check if map contains the key
            if(hashMap.containsKey(strKey)){
                hashMap.get(strKey).add(str);
            }else{
                List<String> value  = new ArrayList<>();
                value.add(str);
                hashMap.put(strKey, value);
            }
        }
        result.addAll(hashMap.values());
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_M solution = new GroupAnagrams_M();
        solution.groupAnagrams(strs);
    }
}
