package string;

/**
 * Created by ziweihan on 2/19/20.
 *
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.
 Example 1:
 Input: "A man, a plan, a canal: Panama"
 Output: true

 Example 2:
 Input: "race a car"
 Output: false
 */
public class ValidPalindrome_E {

    public boolean isPalindrome(String s) {
        if( s== null || s.isEmpty())
            return true;
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i = 0;
        while(i<s.length()/2){
            char l = s.charAt(i);
            char r = s.charAt(s.length()-1-i); //remember to subtract 1 to get the last char
            if(l!=r)
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome_E solution  = new ValidPalindrome_E();
        System.out.println(solution.isPalindrome(s));
    }
}
