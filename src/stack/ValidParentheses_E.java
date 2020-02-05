package stack;

import java.util.Stack;

/**
 * Created by ziweihan on 4/9/19.
 *
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 */
public class ValidParentheses_E {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;

        if(s.length()%2 >0)
            return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c ==']'&& top !='[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses_E validParentheses = new ValidParentheses_E();
        System.out.print(validParentheses.isValid("(){}[{}]"));
    }

}
