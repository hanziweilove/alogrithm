package string;

/**
 * Created by ziweihan on 4/1/19.
 *
 *387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return
 * it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 *
 */
public class FirstUniqueCharacter_E {

    public int firstUniqChar(String s) {
        if(s==null || s.length() ==0)
            return -1;

        // used to mark the occurance of each character
        int[] stringTable = new int[256];
        int i;
        for(i = 0; i<s.length(); i++){
            stringTable[s.charAt(i)]++;
        }

        // traverse the string to find which character appears only once.
        for(i = 0; i<s.length(); i++){
            if(stringTable[s.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FirstUniqueCharacter_E solution = new FirstUniqueCharacter_E();
        String inputStr = "eetcode";
        System.out.print(solution.firstUniqChar(inputStr));
    }
}
