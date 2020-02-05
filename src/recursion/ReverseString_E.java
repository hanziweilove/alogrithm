package recursion;

/**
 * Created by ziweihan on 3/19/19.
 */
public class ReverseString_E {

    public static String reverseString(String s) {
        if(s == null || s.length()==1) return s;
        char temp;
        int i = 0;
        char[] charArray = s.toCharArray(); //needs to convert string to charArray to swap characters
        while(i<s.length()/2) {
            temp = charArray[i];
            charArray[i] = charArray[s.length()-1-i];
            charArray[s.length()-1-i] = temp;
            i++;
        }
        return String.valueOf(charArray);
    }

    public static String reverseStringRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        helper(0, s.toCharArray(), sb);
        return sb.toString();
    }

    private static void helper(int index, char[] s, StringBuilder sb){
        if(s == null || index >=s.length)
            return ;
        helper(index+1, s, sb);
        sb.append(s[index]);
    }

    public static void main(String[] args) {
        System.out.print(reverseStringRecursive("ILOVEYOU"));
    }
}
