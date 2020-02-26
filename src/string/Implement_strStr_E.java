package string;

/**
 * Created by ziweihan on 2/19/20.
 *
 * 28. Implement strStr()
 *
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 Example 1:
 Input: haystack = "hello", needle = "ll"
 Output: 2

 Example 2:
 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.
 For the purpose of this problem, we will return 0 when needle is an empty string.
 This is consistent to C's strstr() and Java's indexOf().
 */
public class Implement_strStr_E {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty())
            return 0;
        int i = 0;
        while(i<=haystack.length()-needle.length()){
            //string.substring(start, end) end is exclusive
            if(haystack.substring(i, needle.length()+i).equals(needle))
                return i;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Implement_strStr_E solution = new Implement_strStr_E();
        int i = solution.strStr("hello", "ll");
        System.out.println(i);
    }
}
