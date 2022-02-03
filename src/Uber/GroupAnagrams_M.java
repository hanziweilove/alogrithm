package Uber;

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
     * Time :O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs.
     * The outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log K)O(KlogK) time.
     * Space: O(NK), the total information content stored in ans.
     *
     * Use a hash map
     * key = char array of each string
     * value = ArrayList of the anagram set
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(String str: strs){
            //convert each string to a char array
            char[] charArray= str.toCharArray();
            //sort the strings, so all anagram will have the same key
            Arrays.sort(charArray);
            //convert charArray to String as a key
            String key = String.valueOf(charArray);
            if(map.containsKey(key)){
               map.get(key).add(str);
            }else{
                List newList = new ArrayList();
                newList.add(str);
                map.put(key, newList);
            }

        }
        return new ArrayList(map.values());

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_M solution = new GroupAnagrams_M();
        System.out.print(solution.groupAnagrams(strs).toString());

    }
}
