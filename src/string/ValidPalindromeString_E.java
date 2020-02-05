package string;

/**
 * Created by ziweihan on 5/29/19.
 *
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 */
public class ValidPalindromeString_E {

    public boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;
         String sb = sanitizeString(s);
         int i = 0;
         while(i<sb.length()/2){
             //remember to subtract 1 to get the last char
             if(sb.charAt(i) != sb.charAt(sb.length()-i-1))
                 return false;
             i++;
         }
         return true;
    }

    private String sanitizeString(String s){
        return s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    }

    public static void main(String[] args){
        ValidPalindromeString_E problem = new ValidPalindromeString_E();
        System.out.print(problem.isPalindrome("A man, a pln, a canal: Panama"));
    }


}
