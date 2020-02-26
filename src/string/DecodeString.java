package string;

import java.util.Stack;

/**
 * Created by ziweihan on 4/30/19.
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and
 * that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    /**************************************************
     * Iterative way
     ***************************************************/

    public String decodeString(String s) {
        // corner cases
        if(s == null || s.isEmpty())
            return "";

        // general case
        int count = 0;
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for(int i = 0; i< s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
               count = 10*count + c -'0'; //100 case: char '1', char '0', char'0', needs to times 10 for each char.
            } else if(Character.isLetter(c)){
                result = result.append(c);
            } else if(c == '['){
                numStack.push(count);
                strStack.push(result.toString());
                result = new StringBuilder();
                count = 0;
            } else {
                // ']' case
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int j = 0; j< repeat; j++){
                    temp.append(result);
                }
                result = temp;
            }
        }

        return result.toString();

    }

    /**************************************************
     * Recursive way
     ***************************************************/
    public String decodeString_recursively(String s) {
        return decodeString_recursively(s, 0);
    }

    private String decodeString_recursively(String s, int i) {
        String res = "";
        int n = s.length();
        while (i < n && s.charAt(i) != ']') {
            if (Character.isLetter(s.charAt(i))) {
                res += s.charAt(i);
                i++;
            } else {
                int cnt = 0;
                while (Character.isDigit(s.charAt(i))) {
                    cnt = cnt * 10 + s.charAt(i) - '0';
                    i++;
                }
                ++i;
                String t = decodeString_recursively(s, i);
                ++i;
                while (cnt-- > 0) {
                    res += t;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        //String input = "2[a]";
        //String input = "2[a]2[b]"; //pass
        String input = "3[ab2[c]]"; //pass
        //String input =  "2[abc]3[cd]ef"; //pass
        //String input = "100[Leetcode]"; //pass
        DecodeString decodeString = new DecodeString();
        System.out.print(decodeString.decodeString(input));


    }
}
